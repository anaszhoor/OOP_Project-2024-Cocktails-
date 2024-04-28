package Classes;

public class Sugar extends Ingredient {
    
    private int NumberOfCubeSugar;
    private final double NumberOfCaloriesPerCube = 16;

    public Sugar() {
    }

    public Sugar(int NumberOfCubeSugar) {
        this.NumberOfCubeSugar = NumberOfCubeSugar;
    }

    public int getNumberOfCubeSugar() {
        return NumberOfCubeSugar;
    }

    public void setNumberOfCubeSugar(int NumberOfCubeSugar) {
        this.NumberOfCubeSugar = NumberOfCubeSugar;
    }

    public double getNumberOfCaloriesPerCube() {
        return NumberOfCaloriesPerCube;
    }
    
    
    @Override
    public double getCalories() {
        return NumberOfCubeSugar * NumberOfCaloriesPerCube;
    }

 
    @Override
    public String getInfo() {
        return "Sugar{" + "Number Of CubeSugar = " + NumberOfCubeSugar + ", Number Of Calories Per Cube = " + NumberOfCaloriesPerCube + '}';
    }
   
    
    
   
}
