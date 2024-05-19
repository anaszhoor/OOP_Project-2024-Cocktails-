/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author m1
 */
public class ConsloeLogger implements Logger{
    
    @Override
    public void log(String message) {
        System.out.println(message);
    }
    
}
