/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author m1
 */
public class Fruit extends Ingredient{

    private String name;

    public Fruit(String name, Color color, double calories, double volume) {
        super(color, calories, volume);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        return "Fruit{" + "name=" + name + super.getInfo() + '}';
    }
    
    
    
}
