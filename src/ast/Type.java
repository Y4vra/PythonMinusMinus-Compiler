package ast;

import java.util.List;

public interface Type extends ASTNode {
    Type arithmetic(Locatable locatable);
    Type arithmetic(Type type, Locatable locatable);
    Type comparison(Type type, Locatable locatable);
    Type canBeCastTo(Type type, Locatable locatable);
    Type dot(String field, Locatable locatable);
    Type logic(Locatable locatable);
    Type logic(Type type, Locatable locatable);
    void mustBeBuiltIn(Locatable locatable);
    void mustBeLogical(Locatable locatable);
    void mustPromoteTo(Type type, Locatable locatable);
    Type parenthesis(List<Type> types, Locatable locatable);
    Type squareBrackets(Type type, Locatable locatable);
    int numberOfBytes();
    char getSuffix();

    String toCode();
}
