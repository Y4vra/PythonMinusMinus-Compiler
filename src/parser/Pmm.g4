grammar Pmm;
@header{
import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
}

program returns [Program ast] locals [List<Definition> optional = new ArrayList<>()]:
    (definition{$optional.addAll($definition.ast);})* mainDefinition EOF
    {$ast = new Program($optional,$mainDefinition.ast);}
    ;

//Lexer part

mainDefinition returns [Definition ast] locals [List<Statement> body=new ArrayList<>()]:
    'def' id='main' '('')' '->' 'None'':''{' (varDefinition{$body.addAll($varDefinition.ast);})* (statement{$body.add($statement.ast);})*'}'
    {$ast = new FuncDefinition($id.getLine(),$id.getCharPositionInLine(),$body);}
    ;

definition returns [List<Definition> ast = new ArrayList<>()] : varDefinition
    {$ast.addAll($varDefinition.ast);}
    |   funcDefinition
    {$ast.add($funcDefinition.ast);}
    ;

funcDefinition returns [Definition ast] locals [Type returnType,List<VarDefinition> params=new ArrayList<>(),List<Statement> body=new ArrayList<>()]:
    'def'ID'('(parameters{$params=$parameters.ast;})?')''->'(builtInType{$returnType=$builtInType.ast;}|'None'{$returnType=VoidType.getInstance();})':''{'(varDefinition{$body.addAll($varDefinition.ast);})*(statement{$body.add($statement.ast);})*'}'
    {$ast = new FuncDefinition($ID.getLine(),$ID.getCharPositionInLine(),$ID.getText(),new FunctionType($returnType,$params),$body);}
    ;

parameters returns [List<VarDefinition> ast=new ArrayList<>()] :
    id1=ID':'t1=type {$ast.add(new VarDefinition($id1.getLine(),$id1.getCharPositionInLine()+1,$id1.getText(),$t1.ast));}(','id2=ID ':' t2=type {$ast.add(new VarDefinition($id2.getLine(),$id2.getCharPositionInLine()+1,$id2.getText(),$t2.ast));})*
    ;

varDefinition returns [List<VarDefinition> ast=new ArrayList<>()] locals [List<String> ids = new ArrayList<>()]:
    id1=ID {$ids.add($id1.getText());}(',' id2=ID{$ids.add($id2.getText());})* ':' type ';'
    {$ids.stream().forEach(id->{
        var variable = new VarDefinition($id1.getLine(),$id1.getCharPositionInLine()+1,id,$type.ast);
        if($ast.contains(variable))new ErrorType("Duplicate identifier in variable definition",variable);
        $ast.add(variable);
    });}
    ;

type returns [Type ast] locals [List<Field> aux]:
    builtInType
    {$ast = $builtInType.ast;}
    |   '['INT_CONSTANT']' t2=type
    {$ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.getText()),$t2.ast);}
    |   'struct' '{' {$aux=new ArrayList<>();}(field{
        $field.ast.forEach(fieldFound->{
            if($aux.contains(fieldFound))new ErrorType("Duplicate field in struct definition",fieldFound);
            $aux.add(fieldFound);
        });})* '}'
    {$ast = new StructType($aux);}
    ;
field returns [List<Field> ast=new ArrayList<>()] locals [List<String> ids = new ArrayList<>()]:
    id1=ID {$ids.add($id1.getText());}(',' id2=ID{$ids.add($id2.getText());})* ':' type ';'
    {$ids.stream().forEach(id->{
        var field = new Field($id1.getLine(),$id1.getCharPositionInLine()+1,id,$type.ast);
        if($ast.contains(field))new ErrorType("Duplicate identifier in field definition",field);
        $ast.add(field);
    });}
    ;

builtInType returns [Type ast]: 'double'
    {$ast = DoubleType.getInstance();}
     |   'char'
     {$ast = CharacterType.getInstance();}
     |   'int'
     {$ast = IntegerType.getInstance();}
     ;

statement returns [Statement ast] locals [List aux]:
    'print' exp1=expression {$aux=new ArrayList<>();$aux.add($exp1.ast);} (',' exp2=expression{$aux.add($exp2.ast);})* ';'
    {$ast = new Write($exp1.ast.getLine(),$exp1.ast.getColumn(),$aux);}
    |   'input' exp1=expression{$aux=new ArrayList<>();$aux.add($exp1.ast);} (',' exp2=expression{$aux.add($exp2.ast);})* ';'
    {$ast = new Read($exp1.ast.getLine(),$exp1.ast.getColumn(),$aux);}
    |   exp1=expression '=' exp2=expression ';'
    {$ast = new Assignment($exp1.ast.getLine(),$exp1.ast.getColumn(),$exp1.ast,$exp2.ast);}
    |   'while' exp=expression ':' block
    {$ast = new While($exp.ast.getLine(),$exp.ast.getColumn(),$exp.ast,$block.ast);}
    |   'if' exp=expression ':' b1=block {$aux=new ArrayList<>();}('else' ':' b2=block{$aux=$b2.ast;})?
    {$ast = new IfElse($exp.ast.getLine(),$exp.ast.getColumn(),$exp.ast,$b1.ast,$aux);}
    |   'return' exp=expression ';'
    {$ast=new Return($exp.ast.getLine(),$exp.ast.getColumn(),$exp.ast);}
    |   invocation ';'
    {$ast=$invocation.ast;}
    ;

block returns [List<Statement> ast = new ArrayList<>()]: statement
    {$ast.add($statement.ast);}
    |   '{' (statement{$ast.add($statement.ast);})* '}'
    ;

invocation returns [Invocation ast] locals [List<Expression> params=new ArrayList<>()]:
    ID '(' (exp1=expression{$params.add($exp1.ast);}(',' exp2=expression{$params.add($exp2.ast);})*)? ')'
    {$ast = new Invocation($ID.getLine(),$ID.getCharPositionInLine()+1,new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.getText()),$params);}
    ;

expression returns [Expression ast]: ID
    {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);}
    |   REAL_CONSTANT
    {$ast = new DoubleLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToReal($REAL_CONSTANT.getText()));}
    |   INT_CONSTANT
    {$ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.getText()));}
    |   CHAR_CONSTANT
    {$ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar($CHAR_CONSTANT.getText()));}
    |   '(' exp1=expression ')'
    {$ast = $exp1.ast;}
    |   exp1=expression '[' exp2=expression ']'
    {$ast = new ArrayAccess($exp1.ast.getLine(),$exp1.ast.getColumn(),$exp1.ast,$exp2.ast);}
    |   exp1=expression '.' ID
    {$ast = new StructAccess($exp1.ast.getLine(),$exp1.ast.getColumn(),$exp1.ast,$ID.getText());}
    |   '(' type ')' exp1=expression
    {$ast = new Cast($exp1.ast.getLine(),$exp1.ast.getColumn(),$type.ast,$exp1.ast);}
    |   '-' exp1=expression
    {$ast = new UnaryMinus($exp1.ast.getLine(),$exp1.ast.getColumn(),$exp1.ast);}
    |   '!' exp1=expression
    {$ast = new UnaryNot($exp1.ast.getLine(),$exp1.ast.getColumn(),$exp1.ast);}
    |   exp1=expression id=('*'|'/'|'%') exp2=expression
    {$ast = new Arithmetic($exp1.ast.getLine(),$exp1.ast.getColumn(),$id.getText(),$exp1.ast,$exp2.ast);}
    |   exp1=expression id=('+'|'-') exp2=expression
    {$ast = new Arithmetic($exp1.ast.getLine(),$exp1.ast.getColumn(),$id.getText(),$exp1.ast,$exp2.ast);}
    |   exp1=expression id=('>'|'>='|'<'|'<='|'!='|'==') exp2=expression
    {$ast = new Comparison($exp1.ast.getLine(),$exp1.ast.getColumn(),$id.getText(),$exp1.ast,$exp2.ast);}
    |   exp1=expression id=('&&'|'||') exp2=expression
    {$ast = new Logical($exp1.ast.getLine(),$exp1.ast.getColumn(),$id.getText(),$exp1.ast,$exp2.ast);}
    |   invocation
    {$ast = $invocation.ast;}
    ;

ID: (LETTER | '_') (LETTER | DIGIT | '_')*
    ;

REAL_CONSTANT:  DIGIT+ '.' DIGIT* ([Ee] '-'? DIGIT+)?
                | DIGIT* '.' DIGIT+
                | DIGIT+ [Ee] ('-'|'+')? DIGIT+
                ;
INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;
CHAR_CONSTANT: '\'' (~'\''+|('\\' DIGIT+)|'\n'|'\t') '\''
            ;
DIGIT: [0-9]
        ;
LETTER: [a-zA-Z]
        ;
IGNORED:    [\n\r\t\f ]->skip
        ;
COMMENT:    ('#' ~[\r\n]*)->skip
        ;
MULTILINE_COMMENT: '"""' .*? '"""'->skip
                ;