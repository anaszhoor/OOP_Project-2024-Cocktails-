/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author m1
 */
public class MainGUI {

    public Blender blender;
    private Cup cup;

    public MainGUI() {
        blender = new Blender(1600);
        cup = new Cup(200);
    }
    
    public void addFruit(String name, Color color, double calories, double volume) {
        try {
            Ingredient i1 = new Fruit(name, color, calories, volume);
            blender.addIngredient(i1);
            blender.addColor(color);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "Input Invalid!!");
        } catch (BlenderOverflowException ex) {
            JOptionPane.showMessageDialog(null, "Enough, It Will Overflow -_-\n\nNote: You Can Add a Smaller Peace Of Ingredient ^_^");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addMilk(double volume , double calories) {
        try {
            Color color = new Color(255, 255, 255, volume);
            Ingredient m1 = new Milk(color, calories, volume);
            blender.addIngredient(m1);
            blender.addColor(color);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "Input Invalid!!");
        } catch (BlenderOverflowException ex) {
            JOptionPane.showMessageDialog(null, "Enough, It Will Overflow -_-\n\nNote: You Can Add a Smaller Peace Of Ingredient ^_^");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addSuger(int cubes) {
        try {
            Ingredient s1 = new Sugar(cubes);
            blender.addIngredient(s1);
            
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "Input Invalid!!");
        } catch (BlenderOverflowException ex) {
            JOptionPane.showMessageDialog(null, "Enough, It Will Overflow -_-\n\nNote: You Can Add a Smaller Peace Of Ingredient ^_^");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    public void Blend(){
        blender.blend();
    }
    
    public double caloriesCup(){
        return Math.round((double) cup.pourCocktail());
    }
    
    public void pour()throws emptyBlenderException, BlendException{
        blender.pourIntoCup(cup);
    }
}
