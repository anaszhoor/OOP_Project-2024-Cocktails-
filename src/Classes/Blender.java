package Classes;
import java.util.ArrayList;

public class Blender implements informations {
    private double capacity;
    private ArrayList<Ingredient> mixture;
    private double totalCalories;
    private double totalVolume;
    private static double numberOfCaloriesPerMl;
    private int numberOfCups;
    private static int numberOfIngredient;
    private ArrayList<Color> mixtureColor;

    
    public Blender() {
    }
   
    public Blender(double capacity) {
        this.mixtureColor = new ArrayList<>();
        this.capacity = capacity;
        this.mixture = new ArrayList<>();
        numberOfIngredient = 0;
        numberOfCaloriesPerMl = 0;
        numberOfCups = 0;  
    }

    public double getCapacity() {
        return capacity;
    }

    public ArrayList<Ingredient> getMixture() {
        return mixture;
    }

    public void setMixture(ArrayList<Ingredient> mixture) {
        this.mixture = mixture;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public static double getNumberOfCaloriesPerMl() {
        return numberOfCaloriesPerMl;
    }
    
    public int getNumberOfCups() {
        return numberOfCups;
    }

    public void setNumberOfCups(int numberOfCups) {
        this.numberOfCups = numberOfCups;
    }

    
    public void addIngredient(Ingredient ingredient) throws BlenderOverflowException {
        
        if (totalVolume+ingredient.getVolume() < capacity){
            this.mixture.add(ingredient);
            totalCalories += ingredient.getCalories();
            totalVolume += ingredient.getVolume();
            numberOfCaloriesPerMl = totalCalories / totalVolume;
            numberOfIngredient++;
            
        } 
        else {
            throw new BlenderOverflowException();
        }
        // Add ingredient to the mixture
        // Handle capacity constraints
    }

    public void blend() {
        System.out.println("Blender Info : \n" + "Capacity : " + capacity 
                + "\nTotal Calories : " +  totalCalories
                + "\nTotal Volume :  " + totalVolume 
                + "\nMixture Color: " + mixtureColor().getInfo() + "\n");
        // Mix the ingredients
    }

    public void pourIntoCup(Cup cup) throws emptyBlenderException{
        boolean flag = true;
        while(flag){
            if(totalVolume >= cup.getCapacity()){
                numberOfCups++;
                totalVolume -= cup.getCapacity();
            }
            else{
                flag = false;
            }
        }
        System.out.println("Number of Cups : " + numberOfCups + "\nNumber of Calories per Cup : " + cup.pourCocktail() + "\n");

        if(!flag)
        {
            throw new emptyBlenderException();
        }
    }
    
    public void addColor(Color color){
        mixtureColor.add(color);
    }
    
    public Color mixtureColor(){
        double totalRed = 0;
        double totalGreen = 0;
        double totalBlue = 0;
        for(int i = 0 ; i<mixtureColor.size() ; i++){
            totalRed += mixtureColor.get(i).getRed()/mixtureColor.get(i).getVolumeOfIngredient();
            totalGreen += mixtureColor.get(i).getGreen()/mixtureColor.get(i).getVolumeOfIngredient();
            totalBlue += mixtureColor.get(i).getBlue()/mixtureColor.get(i).getVolumeOfIngredient();
        }
        totalRed *= totalVolume;
        totalGreen *= totalVolume;
        totalBlue *= totalVolume;
   
        Color color = new Color(totalRed , totalGreen , totalBlue);
        return color;
    }

    @Override
    public String getInfo() {
        return "Blender{" + "capacity=" + capacity + ", mixture=" + mixture + ", totalCalories=" + totalCalories + ", totalVolume=" + totalVolume + ", mixtureColor=" + mixtureColor + ", numberOfCups=" + numberOfCups + '}';
    }   
}
