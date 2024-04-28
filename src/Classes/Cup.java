package Classes;

public class Cup implements informations {
    private double capacity; 
    private double contentCalories;
    
    
    public Cup(double capacity) {
        this.capacity = capacity;
        this.contentCalories = 0;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    

    public double getContentCalories() {
        return contentCalories;
    }

    public double pourCocktail() {
        contentCalories = capacity * Blender.getNumberOfCaloriesPerMl();
        
        return contentCalories;
    }

    @Override
    public String getInfo() {
        return "Cup{" + "capacity=" + capacity + ", contentCalories=" + contentCalories + '}';
    }
    
    

    
    
    
    
}