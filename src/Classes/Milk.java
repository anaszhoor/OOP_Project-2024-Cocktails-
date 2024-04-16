/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author m1
 */
public class Milk extends Ingredient {

    public Milk(Color color, double calories, double volume) {
        super(color, calories, volume);
    }

    /**
     *
     * @return
     */
    @Override
    public String getInfo() {
        return "Milk{"  + super.getInfo() +   '}';
    }
    
    
    
    
}
