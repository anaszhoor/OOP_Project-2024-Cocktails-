/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.ArrayList;
/**
 *
 * @author m1
 */
public class Blender implements informations {
    private double capacity;
    private ArrayList<Ingredient> mixture;
    private double totalCalories;
    private double totalVolume;
    private Color mixtureColor;
    private static double numberOfCaloriesPerMl;
    private int numberOfCups;
    private static int numberOfIngredient;

    
    public Blender() {
    }
   
    public Blender(double capacity) {
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

    public Color getMixtureColor() {
        return mixtureColor;
    }

    public void setMixtureColor(Color mixtureColor) {
        this.mixtureColor = mixtureColor;
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

    
    public void addIngredient(Ingredient ingredient) {
        if (totalVolume <= capacity){
            this.mixture.add(ingredient);
            totalCalories += ingredient.getCalories();
            if(ingredient.getClass() != Sugar.class){
                totalVolume += ingredient.getVolume();
            }
            numberOfCaloriesPerMl = totalCalories / totalVolume;
            numberOfIngredient++;
            
        }                               
        
    }

    public void blend() {
        System.out.println("Blender Info : \n" + " Capacity : " + capacity 
                + "\nTotal Calories : " +  totalCalories
                + "\nTotal Volume :  " + totalVolume 
                + "\nMixture Color: " + mixtureColor);
        // Mix the ingredients
    }

    public String pourIntoCup(Cup cup) {
        while(totalVolume >= cup.getCapacity()){
            numberOfCups++;
            totalVolume -= cup.getCapacity();
        }
        return "Number of Cups : " + numberOfCups ;
        // Transfer the mixture to a cup
    }

    @Override
    public String getInfo() {
        return "Blender{" + "capacity=" + capacity + ", mixture=" + mixture + ", totalCalories=" + totalCalories + ", totalVolume=" + totalVolume + ", mixtureColor=" + mixtureColor + ", numberOfCups=" + numberOfCups + '}';
    }

    

    
    
    
}
