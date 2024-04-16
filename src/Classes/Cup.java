/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author m1
 */
// Cup class
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

    public void pourCocktail() {
        contentCalories = capacity * Blender.getNumberOfCaloriesPerMl();
    }

    @Override
    public String getInfo() {
        return "Cup{" + "capacity=" + capacity + ", contentCalories=" + contentCalories + '}';
    }
    
    

    
    
    
    
}