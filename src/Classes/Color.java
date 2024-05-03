package Classes;


public class Color implements informations {
    
    private int red;
    private int green;
    private int blue;
    private double volumeOfIngredient;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Color(int red, int green, int blue, double volumeOfIngredient) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.volumeOfIngredient = volumeOfIngredient;
    }
    

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public double getVolumeOfIngredient() {
        return volumeOfIngredient;
    }

    public void setVolumeOfIngredient(double volumeOfIngredient) {
        this.volumeOfIngredient = volumeOfIngredient;
    }
    
    @Override
    public String getInfo() {
        return "Color{" + "red=" + red + ", blue=" + blue + ", green=" + green + '}';
    }
    
    
    
    
}
