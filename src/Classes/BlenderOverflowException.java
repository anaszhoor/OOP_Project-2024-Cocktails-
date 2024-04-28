package Classes;

public class BlenderOverflowException extends Exception {
    
    @Override
    public String getMessage(){
        return "Enough, It Will Overflow -_-\nNote: You Can Add a Smaller Peace Of Ingredient";
    }
}
