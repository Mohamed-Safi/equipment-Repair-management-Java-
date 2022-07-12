package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;


public class dataBase {
    
    static Connection con;

    
    public static void connect(){
        
        String currentDir = System.getProperty("user.dir");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            String host = "jdbc:derby:"+currentDir+"\\weapons";
            String uName = "gun";
            String uPass = "gun";
            con = DriverManager.getConnection(host, uName, uPass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "حدث خطا اثناء الاتصال بقاعدة البينات", "Error" , 0);
            System.exit(0);
        }
        
    }
    
    public static User userSelect(String name){
        
        User user = null;
        
        String password;
        boolean print;
        boolean edit;
        boolean add;
        boolean delete;
        boolean accessToUser;
        
        PreparedStatement sql = null;
        ResultSet result = null;
            
        try {
            
            sql = con.prepareStatement("select * from users where name = '"+name+"' ");
            result = sql.executeQuery();
            result.next();
            
            name = result.getString("name");
            password = result.getString("password");
            print = result.getBoolean("print");
            edit = result.getBoolean("edit");
            add = result.getBoolean("xadd");
            delete = result.getBoolean("xdelete");
            accessToUser = result.getBoolean("access_to_user");
                    
            user = new User(name, password, print, edit, add, delete,accessToUser);
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تسجيل الدخول");
            a.setContentText("تاكد من ادخال اسم المستخدم و كلمة المرور بشكل صحيح");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return user;
    }
    
    public static ArrayList<Unit> unitSelect(){
        
        PreparedStatement sql = null;
        ResultSet result = null;
        
        ArrayList<Unit> unit = new ArrayList<>();
        try {
            sql = con.prepareStatement("select * from units");
            result = sql.executeQuery();
            
            String name;
            while(result.next()){
                name = result.getString("name");
                Unit u = new Unit(name);
                
                unit.add(u);
            }
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("لا يمكن للبرنامج الوصول لبيانات الوحدات من الممكن ان الملفات متضررة");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return unit;
    }
    
    public static void unitInsert(String name){
        PreparedStatement sql = null;
        try {
            sql = con.prepareStatement("insert into units values ('"+name+"')");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة العنصر");
            a.setContentText("لا يمكن للبرنامج اضافة العنصر تاكد ان البيانات المدخلة صحيحية وغير مكررة");
            a.showAndWait();
        }
    }
    
    public static void unitUpdate(String newName,String oldName){
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("update units set name = '"+newName+"'where name ='"+oldName+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تعديل العنصر");
            a.setContentText("لا يمكن للبرنامج اضافة العنصر تاكد ان البيانات المدخلة صحيحية وغير مكررة");
            a.showAndWait();
        }
    }

    public static void unitDelete(String name) {
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("delete from units where name = '"+name+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء حذف العنصر");
            a.setContentText("");
            a.showAndWait();
        }
    }

    public static ArrayList<Weapon> weaponsSelect() {
        
        PreparedStatement sql = null;
        ResultSet result = null;
        
        ArrayList<Weapon> weapons = new ArrayList<>();
        try {
            sql = con.prepareStatement("select * from weapons");
            result = sql.executeQuery();
            
            String name;
            String label;
            String model;
            String caliber;
            while(result.next()){
                name = result.getString("name");
                label = result.getString("label");
                model = result.getString("model");
                caliber = result.getString("caliber");
                Weapon u = new Weapon(name, label, model, caliber);
                
                weapons.add(u);
            }
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("لا يمكن للبرنامج الوصول لبيانات الاسلحة من الممكن ان الملفات متضررة");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return weapons;
    }
    
    public static void weaponInsert(Weapon weapon){
        
    String name = weapon.getName();
    String label = weapon.getLabel();
    String model = weapon.getModel();
    String caliber = weapon.getCaliber();
    
    
    PreparedStatement sql;
        try {
            sql = con.prepareStatement("INSERT INTO weapons VALUES ('"+name+"', '"+label+"', '"+model+"', '"+caliber+"')");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة العنصر");
            a.setContentText("لا يمكن للبرنامج اضافة العنصر تاكد ان البيانات المدخلة صحيحية");
            a.showAndWait();
        }
        
    }

    public static void weaponUpdate(Weapon weapon,Weapon old) {
        String name = weapon.getName();
        String label = weapon.getLabel();
        String model = weapon.getModel();
        String caliber = weapon.getCaliber();
        
        String oldName = old.getName();
        String oldLabel = old.getLabel();
        String oldModel = old.getModel();
        String oldCaliber = old.getCaliber();
        
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("update weapons set name = '"+name+"', label = '"+label+"', model = '"+model+"', caliber = '"+caliber+"' where name ='"+oldName+"' and label = '"+oldLabel+"' and model = '"+oldModel+"' and caliber = '"+oldCaliber+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
             System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تعديل العنصر");
            a.setContentText("لا يمكن للبرنامج تعديل العنصر تاكد ان البيانات المدخلة صحيحية");
            a.showAndWait();
        }
    }

    public static void weaponDelete(Weapon weapon) {
        
        String name = weapon.getName();
        String label = weapon.getLabel();
        String model = weapon.getModel();
        String caliper = weapon.getCaliber();
                
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("delete from weapons where name = '"+name+"' and label = '"+label+"' and model = '"+model+"' and caliber = '"+caliper+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء حذف العنصر");
            a.setContentText("");
            a.showAndWait();
        }
    }

    public static boolean formInsert(Form form) {
        String name = form.getName();
        String id = form.getId();
        String img = form.getImg();

        PreparedStatement sql;
        try {
            sql = con.prepareStatement("INSERT INTO forms VALUES ('"+id+"', '"+name+"', '"+img+"')");
            sql.execute();
            sql.close();
            
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("INFORMATION");
            a.setHeaderText("تم ادخال النموذج");
            a.setContentText("");
            a.showAndWait();
            
            return true;
                
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة العنصر");
            a.setContentText("لا يمكن للبرنامج اضافة العنصر تاكد ان البيانات المدخلة صحيحية والرقم غير مكرر");
            a.showAndWait();
            
            return false;
        }
    }

    public static Form formSelect(String id) {
        PreparedStatement sql = null;
        ResultSet result = null;
        
        Form form = null;
        try {
            sql = con.prepareStatement("select * from forms where id = '"+id+"'");
            result = sql.executeQuery();
            
            String num;
            String name;
            String img;
            result.next();
            
            num = result.getString("id");
            name = result.getString("name");
            img = result.getString("img");
            
            form = new Form(name, id, img);
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("تعثر العثور على النموذج");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return form;
    }

    public static boolean formDelete(String id) {

               
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("delete from forms where id = '"+id+"'");
            sql.execute();
            sql.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء حذف العنصر");
            a.setContentText("");
            a.showAndWait();
            return false;
        }

    }

    public static void formUpdate(Form form, String oldFormNum) {
        String name = form.getName();
        String id = form.getId();
        String img = form.getImg();
        
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("update forms set id = '"+id+"', name = '"+name+"', img = '"+img+"' where id ='"+oldFormNum+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
             System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تعديل العنصر");
            a.setContentText("لا يمكن للبرنامج تعديل العنصر تاكد ان البيانات المدخلة صحيحية");
            a.showAndWait();
        }
    }

    public static String getFormImgName(String id) {
         String img_name = null;
         
        PreparedStatement sql = null;
        ResultSet result = null;
        
        try {
            sql = con.prepareStatement("select * from forms where id = '"+id+"'");
            result = sql.executeQuery();
            
            result.next();
            
            img_name = result.getString("img");
            
            
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("تعثر العثور على النموذج");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         
         return img_name;
    }

    public static boolean reportInsert(Report report) {
        
        String id = report.getId();
        String weapon = report.getWeapon();
        String unit = report.getUnit();
        String inspection = report.getInspection();
        String weaponID = report.getWeaponID();
        String img = report.getImg();
        String date = report.getDate();

        PreparedStatement sql;
        try {
            sql = con.prepareStatement("INSERT INTO reports values ('"+id+"', '"+weapon+"', '"+unit+"','"+inspection+"','"+weaponID+"','"+img+"','"+date+"')");
            sql.execute();
            sql.close();
            
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("INFORMATION");
            a.setHeaderText("تم ادخال النموذج");
            a.setContentText("");
            a.showAndWait();
            
            return true;
                
        } catch (SQLException ex) {
            System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة العنصر");
            a.setContentText("لا يمكن للبرنامج اضافة العنصر تاكد ان البيانات المدخلة صحيحية والرقم غير مكرر");
            a.showAndWait();
            
            return false;
        }
    }

    public static Report reportSelect(String id) {
        PreparedStatement sql = null;
        ResultSet result = null;
        
        Report report = null;
        try {
            sql = con.prepareStatement("select * from reports where id = '"+id+"'");
            result = sql.executeQuery();
            
            String weaponID;
            String weapon;
            String unit;
            String inspection;
            String img;
            result.next();
            
            weaponID = result.getString("weaponid");
            weapon = result.getString("weapon");
            unit = result.getString("unit");
            inspection = result.getString("inspection");
            img = result.getString("img");
            
            report = new Report(id, weapon, unit, inspection, weaponID, img ,"");
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("تعثر العثور على النموذج");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return report;
    }

    public static boolean reportDelete(String id) {
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("delete from reports where id = '"+id+"'");
            sql.execute();
            sql.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء حذف العنصر");
            a.setContentText("");
            a.showAndWait();
            return false;
        }
    }

    public static void reportUpdate(Report report, String oldRepairNum) {
        String id = report.getId();
        String unit = report.getUnit();
        String weapon = report.getWeapon();
        String inspection = report.getInspection();
        String img = report.getImg();
        String weaponid = report.getWeaponID();
        
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("update reports set id = '"+id+"',"
                                        + " weapon = '"+weapon+"',"
                                        + " unit = '"+unit+"',"
                                        + " inspection = '"+inspection+"',"
                                        + " weaponid = '"+weaponid+"',"
                                        + " img = '"+img+"'"
                                        + " where id ='"+oldRepairNum+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
             System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تعديل العنصر");
            a.setContentText("لا يمكن للبرنامج تعديل العنصر تاكد ان البيانات المدخلة صحيحية");
            a.showAndWait();
        }
    }

    public static String getReportImgName(String id) {
        String img_name = null;
         
        PreparedStatement sql = null;
        ResultSet result = null;
        
        try {
            sql = con.prepareStatement("select * from reports where id = '"+id+"'");
            result = sql.executeQuery();
            
            result.next();
            
            img_name = result.getString("img");
            
            
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("تعثر العثور على النموذج");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         
         return img_name;
    }

    public static Report reportSelectWeapon(String weaponID) {
        PreparedStatement sql = null;
        ResultSet result = null;
        
        Report report = null;
        try {
            sql = con.prepareStatement("select * from reports where weaponid = '"+weaponID+"'");
            result = sql.executeQuery();
            
            String id;
            String weapon;
            String unit;
            String inspection;
            String img;
            result.next();
            
            id = result.getString("id");
            weapon = result.getString("weapon");
            unit = result.getString("unit");
            inspection = result.getString("inspection");
            img = result.getString("img");
            
            report = new Report(id, weapon, unit, inspection, weaponID, img,"");
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("تعثر العثور على النموذج");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return report;
    }
    
    public static ArrayList<Report> reportSelect() {
        PreparedStatement sql = null;
        ResultSet result = null;
        
        ArrayList<Report> report = new ArrayList();
        try {
            sql = con.prepareStatement("select * from reports");
            result = sql.executeQuery();
            
            String id;
            String weapon;
            String unit;
            String inspection;
            String img;
            String weaponID;
            String date;
            while(result.next()){
                id = result.getString("id");
                weapon = result.getString("weapon");
                unit = result.getString("unit");
                inspection = result.getString("inspection");
                img = result.getString("img");
                weaponID = result.getString("weaponid");
                date = result.getString("reportdate");
                
                Report r = new Report(id, weapon, unit, inspection, weaponID, img,date);
                report.add(r);
            }
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("تعثر العثور على التقارير");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return report;
    }

    public static ArrayList<Report> reportSelectUnit(String unit) {
        
        PreparedStatement sql = null;
        ResultSet result = null;
        
        ArrayList<Report> reports = new ArrayList<>();
        try {
            
            sql = con.prepareStatement("select * from reports where unit = '"+unit+"' ");
            result = sql.executeQuery();
             String id;
             String weapon;
             String inspection;
             String weaponID;
             String img;
             
            while(result.next()){
                
                id = result.getString("id");
                weapon = result.getString("weapon");
                inspection = result.getString("inspection");
                weaponID = result.getString("weaponid");
                img = result.getString("img");
                
                Report report = new Report(id, weapon, unit, inspection, weaponID, img,"");
                
                reports.add(report);
            }
            
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء استدعاء البيانات");
            a.setContentText("لا يمكن للبرنامج الوصول لبيانات الوحدات من الممكن ان الملفات متضررة");
            a.showAndWait();
        }
        try {
            sql.close();
            result.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return reports;

    }

    public static boolean changeUser(String name, String pass, String newName, String newPass) {
        boolean b = true;
        PreparedStatement sql;
        try {
            sql = con.prepareStatement("update users set name = '"+newName+"', password = '"+newPass+"' where name ='"+name+"' and password = '"+pass+"'");
            sql.execute();
            sql.close();
        } catch (SQLException ex) {
             System.out.println(ex);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تعديل العنصر");
            a.setContentText("لا يمكن للبرنامج تعديل العنصر تاكد ان البيانات المدخلة صحيحية");
            a.showAndWait();
            b = false;
        }
        return b;
    }

    public static void userInsert(User user) {
        String name = user.getName();
        String pass = user.getPassword();
        
        boolean print = user.isPrint();
        boolean edit = user.isEdit();
        boolean add = user.isAdd();
        boolean delete = user.isDelete();
        boolean userAccess = user.isAccessToUSer();
        
        PreparedStatement sql = null;
        try {
            sql = con.prepareStatement("insert into users values ('"+name+"','"+pass+"','"+print+"','"+edit+"','"+add+"','"+delete+"','"+userAccess+"', '"+false+"')");
            sql.execute();
            sql.close();
            
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Error");
            a.setHeaderText("تم حفظ المستخدم");
            a.setContentText("");
            a.showAndWait();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة المستخدم");
            a.setContentText("لا يمكن للبرنامج اضافة العنصر تاكد ان البيانات المدخلة صحيحية وغير مكررة");
            a.showAndWait();
        }
    }

    public static void userDelete(String name) {
        PreparedStatement sql;
        ResultSet result = null;
        try {
            ////////////
            sql = con.prepareStatement("select * from users where name = '"+name+"' ");
            result = sql.executeQuery();
            result.next();
            boolean isAdmin = result.getBoolean("isadmin");
            ////////////
            if(!isAdmin){
                sql = con.prepareStatement("delete from users where name = '"+name+"' AND isadmin = '"+false+"'");
                sql.execute();
                sql.close();
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("حدث خطا اثناء حذف المستخدم");
                a.setContentText("لا يمكن حذف الحساب الاساسي");
                a.showAndWait();
            }
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء حذف المستخدم");
            a.setContentText("");
            a.showAndWait();
        }
    }

    public static boolean userUpdate(User user, String oldUserName) {
        
        boolean returnValue = true;
        
        String name = user.getName();
        String pass = user.getPassword();
        
        boolean print = user.isPrint();
        boolean edit = user.isEdit();
        boolean add = user.isAdd();
        boolean delete = user.isDelete();
        boolean userAccess = user.isAccessToUSer();
        
        PreparedStatement sql;
        ResultSet result = null;
        try {
            
            sql = con.prepareStatement("select * from users where name = '"+oldUserName+"' ");
            result = sql.executeQuery();
            result.next();
            
            
            boolean isPrint = result.getBoolean("print");
            boolean isEdit = result.getBoolean("edit");
            boolean isAdd = result.getBoolean("xadd");
            boolean isDelete = result.getBoolean("xdelete");
            boolean isUserAccess = result.getBoolean("access_to_user");
            boolean isAdmin = result.getBoolean("isadmin");
            
            if(!isAdmin){
                
                sql = con.prepareStatement("update users set name = '"+name+"', password = '"+pass+"', print = '"+print+"', edit = '"+edit+"', xadd = '"+add+"', xdelete = '"+delete+"', access_to_user = '"+userAccess+"' where name ='"+oldUserName+"'");
                sql.execute();
                sql.close();
                
            }else{
                
                sql = con.prepareStatement("update users set name = '"+name+"', password = '"+pass+"' where name ='"+oldUserName+"'");
                sql.execute();
                sql.close();
                
                if(isPrint != print || isEdit != edit || isAdd != add || isDelete != delete || isUserAccess != userAccess){
                    
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("حدث خطا اثناء تعديل الصلاحيات");
                    a.setContentText("لا يمكن تعديل صلاحيات الحساب الأساسي");
                    a.showAndWait();
                    
                    returnValue = false;
                }
            }
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء تعديل العنصر");
            a.setContentText("لا يمكن للبرنامج اضافة المستخدم تاكد ان البيانات المدخلة صحيحية وغير مكررة");
            a.showAndWait();
            System.out.println(ex);
        }
        return returnValue;
    }


}
