package driver;


public class Weapon {
    
    private String name;
    private String label;
    private String model;
    private String caliber;

    public Weapon(String name, String label, String model, String caliber) {
        this.name = name;
        this.label = label;
        this.model = model;
        this.caliber = caliber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }
    
    

}