
package Classes;
import java.util.Scanner;


public class OOPProjectANASZHOUR {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Blender b1 = new Blender(1600);
        
        System.out.println("Add Your Choosen Fruits To The Blender To Make MasterPiece Cocktail, Please!\n");
        System.out.println("How Many Fruits Do You Want To Blend?!");
        Integer num = in.nextInt();
        
        while (num > 0){
            System.out.println("Insert The Name Of The Fruit : ");
            String name = in.next();
            System.out.println("What's the color of the fruit ?");
            System.out.println("Note: You Must Enter color in RGB format (e.g., 255 0 0) : ");
            Color color = new Color(in.nextInt() , in.nextInt() , in.nextInt());
            
            System.out.println("Enter The Number Of calories in Fruit ");
            double calories = in.nextDouble();
            
            System.out.println("Enter The Volume Of Fruit ");
            double volume = in.nextDouble();
            
            Ingredient f1 = new Fruit(name , color , calories , volume);
            
            b1.addIngredient(f1);num--;
            
        }
        
        System.out.println("Pour The Milk In The Blender : ");
        System.out.println("Note: How many ml do you want to pour?!");
        double v = in.nextDouble();
        System.out.println("Note: How Many Calories In The Quantity That You Poured");
        double c = in.nextDouble();
            
        Ingredient m1 = new Milk(new Color(255 , 255 , 255) , c , v);
        b1.addIngredient(m1);
        
        System.out.println("How Many Cubes Of Suger Do You Want, Don't Put That Much For Your Health ");
        int NumberOfCubeSugar = in.nextInt();
        Ingredient s1 = new Sugar(NumberOfCubeSugar);
        b1.addIngredient(s1);
   
        
    }
    
}
