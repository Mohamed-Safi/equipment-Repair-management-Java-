package driver;


public class Report {
    
    private String id;
    private String weapon;
    private String unit;
    private String inspection;
    private String weaponID;
    private String img;
    private String date;  

    public Report(String id, String weapon, String unit, String inspection, String weaponID, String img, String date) {
        this.id = id;
        this.weapon = weapon;
        this.unit = unit;
        this.inspection = inspection;
        this.weaponID = weaponID;
        this.img = img;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(String weaponID) {
        this.weaponID = weaponID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
