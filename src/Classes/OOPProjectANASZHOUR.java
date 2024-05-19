package Classes;

import Classes.FileLogger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OOPProjectANASZHOUR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\" This Application is about blending fruits to make great and delicious Cocktails \"");
        System.out.println("Add Your Choosen Fruits To The Blender To Make a MasterPiece Cocktail, Please!\n");
        Logger FileLogger = new FileLogger("ConsoleLog.log");
        Blender blender = new Blender(1600 , FileLogger);
        Cup cup = new Cup(200);

        while (true) {
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
                    } catch (BlendException ex) {
                        System.out.println(ex.getMessage());
                    } catch (emptyBlenderException ex) {
                        System.out.println(ex.getMessage());
                    } catch (Exception ex) {
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
        System.out.println("6) Exit");
    }

    public static void addFruit(Blender b1) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Insert The Name Of The Fruit : ");
            String name = in.next();

            System.out.println("Enter The Number Of calories in Fruit ");
            double calories = in.nextDouble();

            System.out.println("Enter The Volume Of Fruit ");
            double volume = in.nextDouble();

            System.out.println("What's the color of the fruit ?");
            System.out.println("Note: You Must Enter color in RGB format (e.g., 255 100 150) : ");
            Color color = new Color(in.nextInt(), in.nextInt(), in.nextInt(), volume);
            Ingredient f1 = new Fruit(name, color, calories, volume);
            b1.addIngredient(f1);
            b1.addColor(color);
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
            System.out.println("How many ml do you want to pour?!");
            double v = in.nextDouble();
            System.out.println("How Many Calories In The Quantity That You Poured");
            double c = in.nextDouble();
            Color color = new Color(255, 255, 255, v);
            Ingredient m1 = new Milk(color, c, v);
            blender.addIngredient(m1);
            blender.addColor(color);
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
