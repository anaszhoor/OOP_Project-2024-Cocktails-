package Classes;

public class Milk extends Ingredient {

    public Milk(Color color, double calories, double volume) {
        super(color, calories, volume);
    }

    
    @Override
    public String getInfo() {
        return "Milk{"  + super.getInfo() +   '}';
    }
    
    
    
    
}
