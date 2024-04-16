/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author m1
 */
public abstract class Ingredient implements informations {
    private double calories;
    private double volume;
    private Color color;
   

    public Ingredient(){
        
    }

    public Ingredient(double calories, double volume) {
        this.calories = calories;
        this.volume = volume;
    }
    
    
    public Ingredient( Color color , double calories, double volume) {
        this.calories = calories;
        this.volume = volume;
        this.color = color;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String getInfo() {
        return "calories = " + calories + ", volume = " + volume + ", color = " + color ;
    }
    
    

  
}
