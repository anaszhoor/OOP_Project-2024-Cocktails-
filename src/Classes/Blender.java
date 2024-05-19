package Classes;

import java.util.ArrayList;
import java.util.Calendar;

public class Blender implements informations {

    private double capacity;
    private ArrayList<Ingredient> mixture;
    private double totalCalories;
    private double totalVolume;
    private static double numberOfCaloriesPerMl;
    private int numberOfCups;
    private static int numberOfIngredient;
    private ArrayList<Color> mixtureColor;
    private boolean isBlend = false;
    private Logger logger;

    public Blender() {
    }

    public Blender(double capacity , Logger logger) {
        this.mixtureColor = new ArrayList<>();
        this.capacity = capacity;
        this.mixture = new ArrayList<>();
        numberOfIngredient = 0;
        numberOfCaloriesPerMl = 0;
        numberOfCups = 0;
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public double getCapacity() {
        return capacity;
    }

    public ArrayList<Ingredient> getMixture() {
        return mixture;
    }

    public void setMixture(ArrayList<Ingredient> mixture) {
        this.mixture = mixture;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public static double getNumberOfCaloriesPerMl() {
        return numberOfCaloriesPerMl;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    public void setNumberOfCups(int numberOfCups) {
        this.numberOfCups = numberOfCups;
    }

    Calendar c = Calendar.getInstance();
    public void addIngredient(Ingredient ingredient) throws BlenderOverflowException {

        if (totalVolume + ingredient.getVolume() < capacity) {
            this.mixture.add(ingredient);
            totalCalories += ingredient.getCalories();
            totalVolume += ingredient.getVolume();
            numberOfCaloriesPerMl = totalCalories / totalVolume;
            numberOfIngredient++;
            logger.log(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR)  + "--" + c.get(Calendar.HOUR_OF_DAY)
            + "\nAdding Ingredient to the Blender ..."
            + "\nBlender State : \n" + getInfo() + "\n----------------------------------------------------");

        } else {
            logger.log("Over Flow Exception!!\nEnough, It Will Overflow -_-\nNote: You Can Add a Smaller Peace Of Ingredient ^_^" + "\n----------------------------------------------------");
            throw new BlenderOverflowException();
        }
        // Add ingredient to the mixture
        // Handle capacity constraints
    }

    public void blend() {
        isBlend = true;
        System.out.println("Blender Info : \n" + "Capacity : " + capacity
                + "\nTotal Calories : " + totalCalories
                + "\nTotal Volume :  " + totalVolume
                + "\nMixture Color: " + mixtureColor().getInfo() + "\n");
        logger.log("\n" + c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR)  + "--" + c.get(Calendar.HOUR_OF_DAY) + "\nThe Mixing Process Is Done" + "\n----------------------------------------------------");
        
        // Mix the ingredients
    }

    public void pourIntoCup(Cup cup) throws emptyBlenderException, BlendException {
        if (!isBlend) {
            logger.log("\n" + c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR)  + "--" + c.get(Calendar.HOUR_OF_DAY) + "\nBlend Exception!!\n" + "You Must Blend The Ingredient Befor Pour Into Cup ^_^" + "\n----------------------------------------------------");
            throw new BlendException();
        }
        boolean flag = true;
        while (flag) {
            if (totalVolume > 0) {
                numberOfCups++;
                if (totalVolume >= cup.getCapacity()) {
                    totalVolume -= cup.getCapacity();
                } else {
                    totalVolume = 0;
                }
                logger.log("\n" + c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR)  + "--" + c.get(Calendar.HOUR_OF_DAY) + "\nThe Cocktail is Poured" + "\n----------------------------------------------------");

            } else {
                flag = false;
            }
        }

        System.out.println("Number of Cups : " + numberOfCups + "\nNumber of Calories per Cup : " + Math.round((double) cup.pourCocktail()) + "\n");

        if (!flag) {
            logger.log("\n" + c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR)  + "--" + c.get(Calendar.HOUR_OF_DAY) + "\nEmpty Blender Exception!!\n" + "The Blender Became Empty !!!" + "\n----------------------------------------------------");
            throw new emptyBlenderException();
        }
    }

    public void addColor(Color color) {
        mixtureColor.add(color);
    }

    public Color mixtureColor() {
        double totalRed = 0;
        double totalGreen = 0;
        double totalBlue = 0;
        double totalVolume = 0;
        double volumeRatio = 0.0;
        double tValume = 0.0;

        for (int i = 0; i < mixtureColor.size(); i++) {
            tValume += mixtureColor.get(i).getVolumeOfIngredient();
        }
        // Calculate total volume and sum up RGB values scaled by volume ratios
        for (int i = 0; i < mixtureColor.size(); i++) {
            volumeRatio = (double) (mixtureColor.get(i).getVolumeOfIngredient()) / (double) tValume;
            totalVolume += mixtureColor.get(i).getVolumeOfIngredient();
            totalRed += mixtureColor.get(i).getRed() * volumeRatio;
            totalGreen += mixtureColor.get(i).getGreen() * volumeRatio;
            totalBlue += mixtureColor.get(i).getBlue() * volumeRatio;
        }

        // Ensure total volume does not exceed blender volume
        double volumeScale = Math.min(1.0, capacity / totalVolume);
        // Scale RGB values by total volume and create the color
        totalRed *= volumeScale;
        totalGreen *= volumeScale;
        totalBlue *= volumeScale;

        Color color = new Color((int) totalRed, (int) totalGreen, (int) totalBlue);
        return color;
    }

    @Override
    public String getInfo() {
        return "Blender{" + "capacity=" + capacity + ", mixture=" + mixture + ", totalCalories=" + totalCalories + ", totalVolume=" + totalVolume + ", mixtureColor=" + mixtureColor() + ", numberOfCups=" + numberOfCups + '}';
    }
}
