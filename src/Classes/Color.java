package Classes;


public class Color implements informations {
    
    private double red;
    private double green;
    private double blue;
    private double volumeOfIngredient;

    public Color(double red, double green, double blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Color(double red, double green, double blue, double volumeOfIngredient) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.volumeOfIngredient = volumeOfIngredient;
    }
    

    public double getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public double getGreen() {
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
