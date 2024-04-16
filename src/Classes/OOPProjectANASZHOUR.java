/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Classes;

/**
 *
 * @author m1
 */
public class OOPProjectANASZHOUR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ingredient i1 = new Fruit("Mango" , new Color(15 , 40 ,67) , 50 , 20);
        Ingredient i2 = new Fruit("Kiwi" , new Color(19 , 46 ,17) , 28 , 18);
        Ingredient i3 = new Milk(new Color(0 , 0 , 0) , 17 , 36);
        
        Blender b1 = new Blender(800);
        b1.addIngredient(i1);
        b1.addIngredient(i2);
        b1.addIngredient(i3);
        
        b1.blend();
        
        System.out.println(b1.pourIntoCup(new Cup(15)));
        
        
        
        
    }
    
}
