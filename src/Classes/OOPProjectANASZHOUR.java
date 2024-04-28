package Classes;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OOPProjectANASZHOUR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\" This Application is about blending fruits to make great and delicious Cocktails \"");
        System.out.println("Add Your Choosen Fruits To The Blender To Make a MasterPiece Cocktail, Please!\n");
        Blender blender = new Blender(1600);
        Cup cup = new Cup(200);
        
        while (true){
            Minu();
            int choice = in.nextInt();
            switch (choice) {
            case 1:
                addFruit(blender);
                break;
            case 2:
                addMilk(blender);
                break;
            case 3:
                addSuger(blender);
                break;
            case 4:
                blender.blend();
                break;
            case 5:
                try {
                    blender.pourIntoCup(cup);
                } catch (emptyBlenderException ex) {
                    ex.getMessage();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                break;
            case 6:
                System.exit(0);

        }

    }
        
}

    public static void Minu() {
        Scanner in = new Scanner(System.in);
//        System.out.println("How Many Fruits Do You Want To Blend?!");
//        Integer num = in.nextInt();
//        System.out.println("Enter your choice : ");
        System.out.println("1) Add Fruit ");
        System.out.println("2) Add Milk ");
        System.out.println("3) Add Suger ");
        System.out.println("4) Blend ");
        System.out.println("5) pour in cup");
    }

    public static void addFruit(Blender b1) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Insert The Name Of The Fruit : ");
            String name = in.next();
            System.out.println("What's the color of the fruit ?");
            System.out.println("Note: You Must Enter color in RGB format (e.g., 255 0 0) : ");
            Color color = new Color(in.nextInt(), in.nextInt(), in.nextInt());
            b1.addColor(color);

            System.out.println("Enter The Number Of calories in Fruit ");
            double calories = in.nextDouble();

            System.out.println("Enter The Volume Of Fruit ");
            double volume = in.nextDouble();

            Ingredient f1 = new Fruit(name, color, calories, volume);

            b1.addIngredient(f1);
        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        } catch (BlenderOverflowException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void addMilk(Blender blender) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Pour The Milk In The Blender : ");
            System.out.println("Note: How many ml do you want to pour?!");
            double v = in.nextDouble();
            System.out.println("Note: How Many Calories In The Quantity That You Poured");
            double c = in.nextDouble();
            Color color = new Color(255, 255, 255);
            Ingredient m1 = new Milk(color, c, v);
            blender.addColor(color);
            blender.addIngredient(m1);
        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        } catch (BlenderOverflowException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void addSuger(Blender blender) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("How Many Cubes Of Suger Do You Want, Don't Put That Much For Your Health ");
            int NumberOfCubeSugar = in.nextInt();
            Ingredient s1 = new Sugar(NumberOfCubeSugar);
            blender.addIngredient(s1);
            
        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        } catch (BlenderOverflowException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
