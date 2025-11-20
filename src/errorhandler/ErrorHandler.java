package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler instance;
    private List<ErrorType> errors=new ArrayList<>();

    private ErrorHandler(){}
    public static ErrorHandler getInstance() {
        if (instance==null){
            instance = new ErrorHandler();
        }
        return instance;
    }

    public void addError(ErrorType error){
        errors.add(error);
        errors.sort(ERROR_TYPE_COMPARATOR);
    }
    public boolean anyError(){
        return !errors.isEmpty();
    }
    public void showErrors(PrintStream out){
        errors.forEach(err->out.println(err.toString()));
        out.println("Total errors: "+errors.size());
    }
    public static final Comparator<ErrorType> ERROR_TYPE_COMPARATOR = new Comparator<ErrorType>() {
        @Override
        public int compare(ErrorType e1, ErrorType e2) {
            // Compare by line first
            int lineComparison = Integer.compare(e1.getLine(), e2.getLine());
            if (lineComparison != 0) {
                return lineComparison;
            }
            // If lines are the same, compare by column
            return Integer.compare(e1.getColumn(), e2.getColumn());
        }
    };
}
