package Classes;

public class emptyBlenderException extends Exception{
    
    @Override
    public String getMessage(){
        return "The Blender Is Empty";
    }
    
}
