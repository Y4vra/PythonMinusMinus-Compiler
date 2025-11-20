package codegenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {
    private PrintWriter out;
    private int labels = 0;

    public CodeGenerator(String outputFileName, String inputFileName) throws FileNotFoundException {
        out=new PrintWriter(outputFileName);
        out.println();
        out.println("#source\t\""+inputFileName+"\"");
        out.println();
        out.flush();
    }
    public void push(char c){
        out.println("\tpushb\t"+(int)c);
        out.flush();
    }
    public void push(int i){
        out.println("\tpushi\t"+i);
        out.flush();
    }
    public void push(double d){
        out.println("\tpushf\t"+d);
        out.flush();
    }
    public void pushLine(){
        out.println();
        out.flush();
    }
    public void pushAddress(int address) {
        out.println("\tpusha\t"+address);
        out.flush();
    }
    public void pushBP(){
        out.println("\tpush\tbp");
        out.flush();
    }
    public void load(char suffix){
        if(!(suffix=='i' || suffix=='f' || suffix=='b')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        out.println("\tload"+suffix);
        out.flush();
    }
    public void store(char suffix){
        if(!(suffix=='i' || suffix=='f' || suffix=='b')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        out.println("\tstore"+suffix);
        out.flush();
    }
    public void pop(char suffix){
        if(!(suffix=='i' || suffix=='f' || suffix=='b')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        out.println("\tpop"+suffix);
        out.flush();
    }
    /**
     * Duplicate the top value of the stack.
     * @param suffix either b, i or f depending on the type of the element on top of the stack.
     */
    public void dup(char suffix){
        if(!(suffix=='i' || suffix=='f' || suffix=='b')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        out.println("\tdup"+suffix);
        out.flush();
    }
    public void arithmetic(String operator,char suffix){
        if(!(suffix=='i' || (suffix=='f' && !operator.equals("%")) )){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        switch(operator){
            case "+":
                out.println("\tadd"+suffix);
                break;
            case "-":
                out.println("\tsub"+suffix);
                break;
            case "*":
                out.println("\tmul"+suffix);
                break;
            case "/":
                out.println("\tdiv"+suffix);
                break;
            case "%":
                out.println("\tmod"+suffix);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: "+operator);
        }
        out.flush();
    }
    public void comparison(String operator,char suffix){
        if(!(suffix=='i' || suffix=='f')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        switch(operator){
            case ">":
                out.println("\tgt"+suffix);
                break;
            case ">=":
                out.println("\tge"+suffix);
                break;
            case "<":
                out.println("\tlt"+suffix);
                break;
            case "<=":
                out.println("\tle"+suffix);
                break;
            case "==":
                out.println("\teq"+suffix);
                break;
            case "!=":
                out.println("\tne"+suffix);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: "+operator);
        }
        out.flush();
    }
    public void and(){
        out.println("\tand");
        out.flush();
    }
    public void or(){
        out.println("\tor");
        out.flush();
    }
    public void not(){
        out.println("\tnot");
        out.flush();
    }
    public void output(char suffix){
        if(!(suffix=='i' || suffix=='f' || suffix=='b')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        out.println("\tout"+suffix);
        out.flush();
    }
    public void input(char suffix){
        if(!(suffix=='i' || suffix=='f' || suffix=='b')){
            throw new IllegalArgumentException("Invalid suffix: "+suffix);
        }
        out.println("\tin"+suffix);
        out.flush();
    }
    public void convert(char from,char to){
        if ((from=='b' && to=='i') ||
                (from == 'i' && to == 'f') ||
                (from == 'f' && to == 'i') ||
                (from == 'i' && to == 'b')) {
            out.println("\t"+from+"2"+to);
        }else if(from=='b' && to=='f'){
            out.println("\tb2i");
            out.println("\ti2f");
        }else{
            throw new IllegalArgumentException("Invalid suffix at conversion: "+from+" to "+to);
        }
        out.flush();
    }

    public void jump(String label){
        out.println("\tjmp\t"+label);
        out.flush();
    }
    public void jumpZero(String label){
        out.println("\tjz\t"+label);
        out.flush();
    }
    public void jumpNotZero(String label){
        out.println("\tjnz\t"+label);
        out.flush();
    }

    public void pushLabel(String label){
        out.println(" "+label+":");
        out.flush();
    }
    public void call(String functionName){
        out.println("\tcall\t"+functionName);
        out.flush();
    }
    public void enter(int numberOfBytes){
        out.println("\tenter\t"+numberOfBytes);
        out.flush();
    }
    public void ret(int returnBytes, int localVariablesBytes, int parametersBytes){
        out.println(String.format("\tret\t%d, %d, %d",returnBytes,localVariablesBytes,parametersBytes));
        out.flush();
    }
    public void halt(){
        out.println("halt");
        out.flush();
    }
    public void pushLineDelimiter(int numLine){
        out.print("#line\t");
        out.println(numLine);
        out.flush();
    }
    public void pushComment(String comment){
        out.println("\t' * "+comment);
        out.flush();
    }
    public String nextLabel(){
        return "label" + this.labels++;
    }
}
