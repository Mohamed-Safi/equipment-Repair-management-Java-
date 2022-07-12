package gui;


import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import driver.Form;
import driver.Report;
import driver.Unit;
import driver.User;
import driver.Weapon;
import driver.dataBase;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.CheckListView;


public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane loginPane;
    @FXML
    private AnchorPane FormsPane;
    @FXML
    private AnchorPane repairPane;
    @FXML
    private AnchorPane reportsPane;
    @FXML
    private AnchorPane unitsPane;
    @FXML
    private AnchorPane weaponsPane;
    @FXML
    private AnchorPane dashDoorPane;
    @FXML
    private JFXButton unitsButton;
    @FXML
    private JFXButton weaponsButton;
    @FXML
    private JFXButton repairButton;
    @FXML
    private JFXButton userButton;
    @FXML
    private JFXButton formsButton;
    @FXML
    private JFXButton reportsButton;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXPasswordField uPassField;
    @FXML
    private JFXTextField uNameField;
    @FXML
    private TableView<Unit> unitTable;
    @FXML
    private TableColumn<?, ?> unitNameColmn;
    @FXML
    private TextField unitNameField;
    @FXML
    private JFXButton addUnitBtn;
    @FXML
    private JFXButton editUnitBtn;
    @FXML
    private JFXButton deleteUnitBtn;
    @FXML
    private TextField weaponNameField;
    @FXML
    private TextField weaponLabelField;
    @FXML
    private TextField weaponModelField;
    @FXML
    private TextField weaponCaliberField;
    @FXML
    private JFXButton deleteWeaponBtn;
    @FXML
    private JFXButton editWeaponBtn;
    @FXML
    private JFXButton addWeaponBtn;
    @FXML
    private TableView<Weapon> weaponsTable;
    @FXML
    private TableColumn<?, ?> weaponCaliberColumn;
    @FXML
    private TableColumn<?, ?> weaponModelColumn;
    @FXML
    private TableColumn<?, ?> weaponLabelColumn;
    @FXML
    private TableColumn<?, ?> weaponNameColumn;
    @FXML
    private AnchorPane imagePane;
    @FXML
    private JFXButton exit;
    @FXML
    private TextField formNameField;
    @FXML
    private TextField formNumField;
    @FXML
    private JFXButton saveFormBtn;
    @FXML
    private JFXButton addFormBtn;
    @FXML
    private ImageView formImg;
    @FXML
    private Label formImgPathLabel;
    @FXML
    private JFXButton formSearchBtn;
    @FXML
    private JFXButton deleteFormBtn;
    @FXML
    private JFXButton formUpdateBtn;
    @FXML
    private JFXButton printFormBtn;
    String oldFormNum = "";
    
    @FXML
    private TextField repairIDField;
    @FXML
    private TextField repairWeaponDField;
    @FXML
    private TextField repairInspectionFiled;
    @FXML
    private ComboBox<String> repairUnitNameCompo;
    @FXML
    private ComboBox<String> repairWeaponNameCompo;
    @FXML
    private ImageView repiarImageView;
    @FXML
    private Label repairImgPathLabel;
    String oldRepairNum = "";
    @FXML
    private JFXButton saveRepairBtn;
    @FXML
    private JFXButton addRepairBtn;
    @FXML
    private JFXButton repairSearchBtn;
    @FXML
    private JFXButton deleteRepairBtn;
    @FXML
    private JFXButton repairUpdateBtn;
    @FXML
    private JFXButton printRepair;
    @FXML
    private AnchorPane searchPane;
    @FXML
    private JFXButton searchDetailBtn;
    @FXML
    private JFXButton deleteRepairBtn_1;
    @FXML
    private JFXButton printRepair_1;
    @FXML
    private ImageView repiarImageView_1;
    @FXML
    private TableView<Report> searchTable;
    @FXML
    private TableColumn<?, ?> inspectionColmun;
    @FXML
    private TableColumn<?, ?> WeaponColmun;
    @FXML
    private TableColumn<?, ?> UnitColmun;
    @FXML
    private TableColumn<?, ?> WeaponIDColmun;
    @FXML
    private TableColumn<?, ?> orderIDColmun;
    @FXML
    private JFXButton searchSearchBtn;
    @FXML
    private Label dateLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private JFXButton searchDetailBtn2;
    @FXML
    private JFXButton deleteRepairBtn_2;
    @FXML
    private JFXButton printRepair_2;
    @FXML
    private TableView<Report> searchTable2;
    @FXML
    private JFXButton searchSearchBtn2;
    @FXML
    private TableColumn<?, ?> inspectionColmun2;
    @FXML
    private TableColumn<?, ?> WeaponColmun2;
    @FXML
    private TableColumn<?, ?> UnitColmun2;
    @FXML
    private TableColumn<?, ?> WeaponIDColmun2;
    @FXML
    private TableColumn<?, ?> orderIDColmun2;
    @FXML
    private CheckListView<String> unitListView;
    @FXML
    private CheckListView<String> weaponListView;
    @FXML
    private JFXDatePicker startDate;
    @FXML
    private JFXDatePicker endDate;
    @FXML
    private AnchorPane userPane;
    @FXML
    private JFXButton deleteUser;
    @FXML
    private JFXButton searchUser;
    @FXML
    private JFXButton addUser;
    @FXML
    private JFXCheckBox editeCheckBox;
    @FXML
    private JFXCheckBox printCheckBox;
    @FXML
    private JFXCheckBox userCheckBox;
    @FXML
    private JFXCheckBox addCheckBox;
    @FXML
    private JFXCheckBox deleteCheckBox;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField userPassField;
    @FXML
    private JFXButton updateUserBtn;
    
    String oldUserName = "";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Font.loadFont(DashBoardController.class.getResource("SC_AMEEN.ttf").toExternalForm(), 10);
        Font.loadFont(DashBoardController.class.getResource("JannaLT-Regular.ttf").toExternalForm(), 10);
        
        ///////////////'
        
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat st = new SimpleDateFormat("hh:mm a");
        dateLabel.setText(sd.format(d));
        timeLabel.setText(st.format(d));
        
        ////////////////
        Timeline fiveSecondsWonder = new Timeline(
                 new KeyFrame(Duration.seconds(1), 
                 new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Date d = new Date();
                SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat st = new SimpleDateFormat("hh:mm a");
                
                Calendar cl=Calendar.getInstance();
                cl.setTime(d);
                HijrahDate islamyDate = HijrahChronology.INSTANCE.date(LocalDate.of(cl.get(Calendar.YEAR),cl.get(Calendar.MONTH)+1, cl.get(Calendar.DATE))); 
                String hijrah = ""+islamyDate;
                hijrah = hijrah.substring(19);
                
                dateLabel.setText(hijrah);
                timeLabel.setText(st.format(d));
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
        /////////////**
        
        fillUnitTable();
        fillWeaponTable();
        
        startDate.setChronology(HijrahChronology.INSTANCE);
        endDate.setChronology(HijrahChronology.INSTANCE);
        
    }    

    @FXML
    private void btnAction(ActionEvent event) {
        
        if(event.getSource()==loginButton){
            loginCheck(uNameField.getText(),uPassField.getText());
        }else if(event.getSource()==weaponsButton){
            fillWeaponTable();
            dashDoorPane.toFront();
            weaponsPane.toFront();
        }else if(event.getSource()==unitsButton){
            fillUnitTable();
            dashDoorPane.toFront();
            unitsPane.toFront();
        }else if(event.getSource()==repairButton){
            fillCompoBox();
            dashDoorPane.toFront();
            repairPane.toFront();
        }else if(event.getSource()==formsButton){
            dashDoorPane.toFront();
            FormsPane.toFront();
        }else if(event.getSource()==reportsButton){
            listViewFill();
            dashDoorPane.toFront();
            reportsPane.toFront();
        }else if(event.getSource()==logoutButton){
            logOut();
        }else if(event.getSource()==addUnitBtn){
            addUnit(unitNameField.getText());
        }else if(event.getSource()==editUnitBtn){
            editUnit(unitNameField.getText());
        }else if (event.getSource()==deleteUnitBtn){
            deleteUnit();
        }else if(event.getSource()==addWeaponBtn){
            addWeapon(weaponNameField.getText(),weaponLabelField.getText(),weaponModelField.getText(),weaponCaliberField.getText());
        }else if(event.getSource()==exit){
            System.exit(0);
        }else if(event.getSource()==editWeaponBtn){
            editWeapon(weaponNameField.getText(),weaponLabelField.getText(),weaponModelField.getText(),weaponCaliberField.getText());
        }else if(event.getSource()==deleteWeaponBtn){
            deleteWeapon();
        }else if(event.getSource()==saveFormBtn){
            saveForm();
        }else if(event.getSource()==addFormBtn){
            addForm(formNameField.getText(),formNumField.getText(),formImgPathLabel.getText());
        }else if(event.getSource()==formSearchBtn){
            formSearch();
        }else if(event.getSource()==deleteFormBtn){
            deleteForm(formNumField.getText());
        }else if(event.getSource()==formUpdateBtn){
            updateForm(formNameField.getText(),formNumField.getText(),formImgPathLabel.getText());
        }else if(event.getSource()==printFormBtn){
            printForm(formNumField.getText());
        }else if(event.getSource()==saveRepairBtn){
            saveReport();
        }else if(event.getSource()==addRepairBtn){
            String slectedWeapon = repairWeaponNameCompo.getSelectionModel().getSelectedItem();
            String slectedUnit = repairUnitNameCompo.getSelectionModel().getSelectedItem();
            addReport(repairIDField.getText(),slectedWeapon,slectedUnit,repairInspectionFiled.getText(),repairWeaponDField.getText(),repairImgPathLabel.getText());
        }else if(event.getSource()==repairSearchBtn){
            reportSearch();
        }else if(event.getSource()==deleteRepairBtn){
            deleteRepair(repairIDField.getText());
        }else if(event.getSource()==deleteRepairBtn_1){
            deleteRepair_1();
        }else if(event.getSource()==repairUpdateBtn){
            String slectedWeapon = repairWeaponNameCompo.getSelectionModel().getSelectedItem();
            String slectedUnit = repairUnitNameCompo.getSelectionModel().getSelectedItem();
            updateReport(repairIDField.getText(),slectedWeapon,slectedUnit,repairInspectionFiled.getText(),repairWeaponDField.getText(),repairImgPathLabel.getText());
        }else if(event.getSource()==printRepair){
            printReport(repairIDField.getText());
        }else if(event.getSource()==printRepair_1){
            printReport_1();
        }else if(event.getSource()==searchSearchBtn){
            searchByUnit();
        }else if(event.getSource()==searchDetailBtn){
            searchByReportId_1();
        }else if(event.getSource()==userButton){
            dashDoorPane.toFront();
            userPane.toFront();
        }else if(event.getSource()==searchSearchBtn2){
            search_3();
        }else if(event.getSource()==searchDetailBtn2){
            searchByReportId_2();
        }else if(event.getSource()==printRepair_2){
            printReport_2();
        }else if(event.getSource()==deleteRepairBtn_2){
            deleteRepair_2();
        }else if(event.getSource()==addUser){
            addNewUser();
        }else if(event.getSource()==deleteUser){
            deleltUser_(userNameField.getText());
        }else if(event.getSource()==searchUser){
            searchUser_();
        }else if(event.getSource()==updateUserBtn){
            udateUser();
        }
        
    }

    private void loginCheck(String name, String pass) {
        
        if(name!=null&&pass!=null&&!"".equals(name)&&!"".equals(pass)){
            
            User user = dataBase.userSelect(name);
            if(user!=null){
                if(user.getPassword().equals(pass)){
                dashDoorPane.toFront();
                imagePane.toFront();
                uNameField.setText("");
                uPassField.setText("");
                
                /// print access
                printFormBtn.setDisable(!user.isPrint());
                printRepair.setDisable(!user.isPrint());
                printRepair_1.setDisable(!user.isPrint());
                printRepair_2.setDisable(!user.isPrint());
                
                /// edit access
                editUnitBtn.setDisable(!user.isEdit());
                editWeaponBtn.setDisable(!user.isEdit());
                formUpdateBtn.setDisable(!user.isEdit());
                repairUpdateBtn.setDisable(!user.isEdit());
                updateUserBtn.setDisable(!user.isEdit());
                
                /// add access
                addFormBtn.setDisable(!user.isAdd());
                addRepairBtn.setDisable(!user.isAdd());
                addUnitBtn.setDisable(!user.isAdd());
                addWeaponBtn.setDisable(!user.isAdd());
                addUser.setDisable(!user.isAdd());
                
                /// delete access
                deleteFormBtn.setDisable(!user.isDelete());
                deleteRepairBtn.setDisable(!user.isDelete());
                deleteRepairBtn_1.setDisable(!user.isDelete());
                deleteRepairBtn_2.setDisable(!user.isDelete());
                deleteUnitBtn.setDisable(!user.isDelete());
                deleteWeaponBtn.setDisable(!user.isDelete());
                deleteUser.setDisable(!user.isDelete());
                
                /// access to user
                userButton.setDisable(!user.isAccessToUSer());
                
                fillUnitTable();
                fillWeaponTable();
                }else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("حدث خطا اثناء تسجيل الدخول");
                    a.setContentText("تاكد من ادخال اسم المستخدم و كلمة المرور بشكل صحيح");
                    a.showAndWait();
                }
            }
        }
    }

    private void fillUnitTable() {
        ObservableList<Unit> data = FXCollections.observableArrayList();
        unitNameColmn.setCellValueFactory( new PropertyValueFactory<>("name") );
        unitTable.setItems(data);
        
        ArrayList<Unit> units = dataBase.unitSelect();
        
        for (Unit u : units) { 		      
               data.add(u);
        }
    }
    
    private void addUnit(String name) {
        if(name!=null&!"".equals(name)){
            dataBase.unitInsert(name);
            fillUnitTable();
            unitNameField.setText("");
        }
    }

    private void editUnit(String name) {
        int i = unitTable.getSelectionModel().getSelectedIndex();
        String oldName;
        
        if(name!=null&!"".equals(name)){
            if(i!=-1){
                oldName = unitTable.getSelectionModel().getSelectedItem().getName();
                dataBase.unitUpdate(name, oldName);
                unitTable.getItems().remove(unitTable.getSelectionModel().getSelectedItem());
                unitNameField.setText("");
                
                fillUnitTable();
            }else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Warnning");
                a.setHeaderText("قم بتحديد عنصر للتعديل");
                a.setContentText("");
                a.showAndWait();
            }
        }
    }

    private void deleteUnit() {
        int i = unitTable.getSelectionModel().getSelectedIndex();
        String name;
        
            if(i!=-1){
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("سوف يتم حذف العنصر نهائيا");
                alert.setContentText("");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    name = unitTable.getSelectionModel().getSelectedItem().getName();
                    dataBase.unitDelete(name);
                    unitTable.getItems().remove(unitTable.getSelectionModel().getSelectedItem());
                    unitNameField.setText("");
                    fillUnitTable();
                } else {
                    // ... user chose CANCEL or closed the dialog
                }
            }else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Warnning");
                a.setHeaderText("قم بتحديد عنصر للحذف");
                a.setContentText("");
                a.showAndWait();
            }
    }
    
    private void fillWeaponTable() {
        ObservableList<Weapon> data = FXCollections.observableArrayList();
        weaponNameColumn.setCellValueFactory( new PropertyValueFactory<>("name") );
        weaponLabelColumn.setCellValueFactory( new PropertyValueFactory<>("label") );
        weaponModelColumn.setCellValueFactory( new PropertyValueFactory<>("model") );
        weaponCaliberColumn.setCellValueFactory( new PropertyValueFactory<>("caliber") );
        
        weaponsTable.setItems(data);
        
        ArrayList<Weapon> weapons = dataBase.weaponsSelect();
        
        for (Weapon w : weapons) { 		      
               data.add(w);
        }
    }

    @FXML
    private void importUnitData(MouseEvent event) {
        int i = unitTable.getSelectionModel().getSelectedIndex();
        String name;
        if(i!=-1){
                name = unitTable.getSelectionModel().getSelectedItem().getName();
                unitNameField.setText(name);
            }
    }

    @FXML
    private void unitAddEnter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            String name = unitNameField.getText();
            addUnit(name);
        }
    }

    @FXML
    private void loginKeyEnter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            String name = uNameField.getText();
            String pass = uPassField.getText();
            loginCheck(name, pass);
        }
    }

    private void addWeapon(String name, String label, String model, String caliper) {
        if(!"".equals(name)||!"".equals(label)||!"".equals(model)||!"".equals(caliper)){
            dataBase.weaponInsert(new Weapon(name, label, model, caliper));
            fillWeaponTable();
            
            weaponNameField.setText("");
            weaponLabelField.setText("");
            weaponCaliberField.setText("");
            weaponModelField.setText("");
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة العنصر");
            a.setContentText("يجب تعبئة حقل واحد على الاقل لاضافة العنصر");
            a.showAndWait();
        }
    }

    @FXML
    private void addWeaponKeyEnter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
        addWeapon(weaponNameField.getText(),weaponLabelField.getText(),weaponModelField.getText(),weaponCaliberField.getText());
        }
    }

    @FXML
    private void importWeaponsData(MouseEvent event) {
        int i = weaponsTable.getSelectionModel().getSelectedIndex();
        String name;
        String label;
        String model;
        String Caliber;
        if(i!=-1){
                name = weaponsTable.getSelectionModel().getSelectedItem().getName();
                label = weaponsTable.getSelectionModel().getSelectedItem().getLabel();
                model = weaponsTable.getSelectionModel().getSelectedItem().getModel();
                Caliber = weaponsTable.getSelectionModel().getSelectedItem().getCaliber();
                
                weaponNameField.setText(name);
                weaponLabelField.setText(label);
                weaponModelField.setText(model);
                weaponCaliberField.setText(Caliber);
            }
    }

    private void editWeapon(String name, String label, String model, String caliber) {
        int i = weaponsTable.getSelectionModel().getSelectedIndex();
        String oldName;
        String oldLabel;
        String oldModel;
        String oldCaliber;
        
        if(!"".equals(name)||!"".equals(label)||!"".equals(model)||!"".equals(caliber)){
            
            if(i!=-1){
                oldName = weaponsTable.getSelectionModel().getSelectedItem().getName();
                oldLabel = weaponsTable.getSelectionModel().getSelectedItem().getLabel();
                oldModel = weaponsTable.getSelectionModel().getSelectedItem().getModel();
                oldCaliber = weaponsTable.getSelectionModel().getSelectedItem().getCaliber();
                
                dataBase.weaponUpdate(new Weapon(name, label, model, caliber),new Weapon(oldName, oldLabel, oldModel, oldCaliber));
                weaponsTable.getItems().remove(weaponsTable.getSelectionModel().getSelectedItem());
                
                weaponNameField.setText("");
                weaponLabelField.setText("");
                weaponModelField.setText("");
                weaponCaliberField.setText("");
                
                fillWeaponTable();
                
            }else{
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Warnning");
                a.setHeaderText("قم بتحديد عنصر للتعديل");
                a.setContentText("");
                a.showAndWait();
                
            }
            
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة العنصر");
            a.setContentText("يجب تعبئة حقل واحد على الاقل  لحفظ التعديل");
            a.showAndWait();
        }
        
    }

    private void deleteWeapon() {
        int i = weaponsTable.getSelectionModel().getSelectedIndex();
        
        String name;
        String label;
        String model;
        String caliper;
        
            if(i!=-1){
                
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("سوف يتم حذف العنصر نهائيا");
                alert.setContentText("");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    
                    name = weaponsTable.getSelectionModel().getSelectedItem().getName();
                    label = weaponsTable.getSelectionModel().getSelectedItem().getLabel();
                    model = weaponsTable.getSelectionModel().getSelectedItem().getModel();
                    caliper = weaponsTable.getSelectionModel().getSelectedItem().getCaliber();

                    dataBase.weaponDelete(new Weapon(name, label, model, caliper));
                    weaponsTable.getItems().remove(weaponsTable.getSelectionModel().getSelectedItem());

                    fillWeaponTable();
                    
                    
                    weaponNameField.setText("");
                    weaponLabelField.setText("");
                    weaponCaliberField.setText("");
                    weaponModelField.setText("");

                } else {
                    // ... user chose CANCEL or closed the dialog
                }
                
            }else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Warnning");
                a.setHeaderText("قم بتحديد عنصر للحذف");
                a.setContentText("");
                a.showAndWait();
            }
    }

    private void saveForm() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpeg", "*.jpg", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if( selectedFile != null )
        {
            
            formImgPathLabel.setText(selectedFile.getAbsolutePath());
            Image img = new Image(selectedFile.toURI().toString());
            formImg.setImage(img);
            
        }
        
    }

    private void addForm(String name, String num, String img) {
        
        if(!"".equals(num)&&num!=null&&!"".equals(name)&&!"".equals(img)){
            
            String fileName = "Form_"+num+".sre";
            
            File source = new File(img);
            File dest = new File("data/"+fileName);
            try {
                if(!source.getName().equals(dest.getName())){
                    FileUtils.copyFile(source, dest);
                    dataBase.formInsert(new Form(name,num,fileName));
                    
                    formNameField.setText("");
                    formNumField.setText("");
                    formImgPathLabel.setText("");
                    oldFormNum = "";

                    File file = new File("data/empty.sre");
                    formImg.setImage(new Image(file.toURI().toString()));
                }
            } catch (IOException e) {
                
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة النوذج");
            a.setContentText("يجب ادخال جميع البيانات");
            a.showAndWait();
        }
    }

    private void formSearch() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Search");
        dialog.setHeaderText("البحث برقم النموذج");
        dialog.setContentText("ادخل رقم النموذج:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            Form form = dataBase.formSelect(result.get());
            
            if(form!=null){
                formNameField.setText(form.getName());
                formNumField.setText(form.getId());
                
                oldFormNum = form.getId();
                
                File file = new File("data/"+form.getImg());
                formImgPathLabel.setText(file.getAbsolutePath());

                Image img = new Image(file.toURI().toString());
                formImg.setImage(img);
            }
        }

    }

    private void deleteForm(String id) {
       if(!"".equals(id)&&id!=null){
           Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("سوف يتم حذف العنصر نهائيا");
            alert.setContentText("");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                
                boolean isDeleted = dataBase.formDelete(id);
                if(isDeleted){
                    formNameField.setText("");
                    formNumField.setText("");
                    formImgPathLabel.setText("");

                    File f = new File("data/Form_"+oldFormNum+".sre");
                    f.delete();

                    oldFormNum = "";

                    File file = new File("data/empty.sre");
                    formImg.setImage(new Image(file.toURI().toString()));
                }

            } else {
                // ... user chose CANCEL or closed the dialog
            }
       }
    }

    private void updateForm(String name, String num, String img) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("سيتم التعديل على النموذج رقم  "+oldFormNum);
        alert.setContentText("ليس هو؟ ابحث عن النموذج قبل التعديل");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            if(!"".equals(num)&&num!=null&&!"".equals(name)&&!"".equals(img)){

                String fileName = "Form_"+num+".sre";

                File source = new File(img);
                File dest = new File("data/"+fileName);
                try {
                    if(!source.getName().equals(dest.getName())){
                        FileUtils.copyFile(source, dest);

                        if(!oldFormNum.equals(num)){
                            File f = new File("data/Form_"+oldFormNum+".sre");
                            f.delete();
                        }
                    }

                    dataBase.formUpdate(new Form(name,num,fileName),oldFormNum);
                    oldFormNum = formNumField.getText();
                } catch (IOException e) {

                }
            }else{

            }
            
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    private void printForm(String id) {
        
        String IMG_NAME = dataBase.getFormImgName(id);
        
        if(IMG_NAME!=null){
            String FILE_NAME = "toPrint.pdf";
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                document.open();
               
                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("data/"+IMG_NAME);
                int indentation = 0;
                float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
               - document.rightMargin() - indentation) / image.getWidth()) * 100;
                image.scalePercent(scaler);
                document.add(image);
                
                document.close();
                Desktop.getDesktop().open(new File(FILE_NAME));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fillCompoBox() {
        
        ObservableList<String> data = FXCollections.observableArrayList();
        repairUnitNameCompo.setItems(data);
        
        ArrayList<Unit> units = dataBase.unitSelect();
        
        for (Unit u : units) { 		      
               data.add(u.getName());
        }
        
        ObservableList<String> data_2 = FXCollections.observableArrayList();
        
        repairWeaponNameCompo.setItems(data_2);
        
        ArrayList<Weapon> weapons = dataBase.weaponsSelect();
        
        for (Weapon w : weapons) { 		      
               data_2.add(w.getLabel());
        }
        
    }

    private void saveReport() {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpeg", "*.jpg", "*.png"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if( selectedFile != null )
        {
            repairImgPathLabel.setText(selectedFile.getAbsolutePath());
            Image img = new Image(selectedFile.toURI().toString());
            repiarImageView.setImage(img);
            
        }
    }

    private void addReport(String reportID, String slectedWeapon, String slectedUnit,String inspection ,String weaponID, String img) {
        if(!"".equals(reportID)&&!"".equals(weaponID)){
            if(slectedUnit==null||"".equals(slectedUnit)) slectedUnit="غير محدد";
            if(slectedWeapon==null||"".equals(slectedWeapon)) slectedWeapon="غير محدد";
            if(inspection==null||"".equals(inspection)) inspection="غير محدد";
            if("".equals(img)||img==null) img = "data/empty.sre";
            
            Date d = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            
            String date = sd.format(d)+"";
            String fileName = "Report_"+reportID+".sre";
            
            File source = new File(img);
            File dest = new File("data/"+fileName);
            try {
                if(!source.getName().equals(dest.getName())){
                    FileUtils.copyFile(source, dest);
                    
                    dataBase.reportInsert(new Report(reportID, slectedWeapon, slectedUnit, inspection, weaponID, fileName,date));
                    
                    fillCompoBox();
                    repairIDField.setText("");
                    repairInspectionFiled.setText("");
                    repairWeaponDField.setText("");

                    repairUnitNameCompo.getSelectionModel().select(-1);
                    repairWeaponNameCompo.getSelectionModel().select(-1);


                    oldRepairNum = "";

                    File file = new File("data/empty.sre");
                    repiarImageView.setImage(new Image(file.toURI().toString()));
                    
                }
            } catch (IOException e) {
                
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء اضافة النوذج");
            a.setContentText(" يجب ادخال جميع البيانات الأساسية");
            a.showAndWait();
        }
    }

    private void reportSearch() {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Search");
        alert.setHeaderText("اختر طريقة البحث");
        alert.setContentText("");

        ButtonType buttonTypeOne = new ButtonType("رقم أمر العمل");
        ButtonType buttonTypeTwo = new ButtonType("رقم السلاح");
        ButtonType buttonTypeThree = new ButtonType("الوحدة");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
        

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            searchByReportId();
        } else if (result.get() == buttonTypeTwo) {
            searchByWeaponId();
        } else if (result.get() == buttonTypeThree) {
             searchPane.toFront();
             searchByUnit();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
    }
    
    private void searchByReportId(){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Search");
        dialog.setHeaderText("البحث برقم أمر العمل");
        dialog.setContentText("ادخل رقم أمر العمل");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            Report report = dataBase.reportSelect(result.get());
            
            if(report!=null){
                fillCompoBox();
                repairIDField.setText(report.getId());
                repairWeaponDField.setText(report.getWeaponID());
                repairUnitNameCompo.getSelectionModel().select(report.getUnit());
                repairWeaponNameCompo.getSelectionModel().select(report.getWeapon());
                repairInspectionFiled.setText(report.getInspection());
                
                oldRepairNum = report.getId();
                
                File file = new File("data/"+report.getImg());
                repairImgPathLabel.setText(file.getAbsolutePath());

                Image img = new Image(file.toURI().toString());
                repiarImageView.setImage(img);
            }
        }
    }
    
    private void searchByWeaponId(){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Search");
        dialog.setHeaderText("البحث برقم السلاح");
        dialog.setContentText("ادخل رقم السلاح");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            Report report = dataBase.reportSelectWeapon(result.get());
            
            if(report!=null){
                fillCompoBox();
                repairIDField.setText(report.getId());
                repairWeaponDField.setText(report.getWeaponID());
                repairUnitNameCompo.getSelectionModel().select(report.getUnit());
                repairWeaponNameCompo.getSelectionModel().select(report.getWeapon());
                repairInspectionFiled.setText(report.getInspection());
                
                oldRepairNum = report.getId();
                
                File file = new File("data/"+report.getImg());
                repairImgPathLabel.setText(file.getAbsolutePath());

                Image img = new Image(file.toURI().toString());
                repiarImageView.setImage(img);
            }
        }
    }
    
    private void searchByUnit(){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Search");
        dialog.setHeaderText("البحث باسم الوحدة");
        dialog.setContentText("ادخل اسم الوحدة");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
         
            ObservableList<Report> data = FXCollections.observableArrayList();
            orderIDColmun.setCellValueFactory( new PropertyValueFactory<>("id") );
            WeaponIDColmun.setCellValueFactory( new PropertyValueFactory<>("weaponID") );
            WeaponColmun.setCellValueFactory( new PropertyValueFactory<>("weapon") );
            UnitColmun.setCellValueFactory( new PropertyValueFactory<>("unit") );
            inspectionColmun.setCellValueFactory( new PropertyValueFactory<>("inspection") );

            searchTable.setItems(data);
            
            
            ArrayList<Report> report= dataBase.reportSelectUnit(result.get());
            
            for (Report r : report) { 		      
                   data.add(r);
            }
                
        }
    }

    private void deleteRepair(String id) {
        if(!"".equals(id)&&id!=null){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("سوف يتم حذف العنصر نهائيا");
            alert.setContentText("");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                boolean isDeleted = dataBase.reportDelete(id);
                if(isDeleted){
                    fillCompoBox();
                    repairIDField.setText("");
                    repairInspectionFiled.setText("");
                    repairWeaponDField.setText("");

                    repairUnitNameCompo.getSelectionModel().select(-1);
                    repairWeaponNameCompo.getSelectionModel().select(-1);

                    File f = new File("data/Report_"+oldRepairNum+".sre");
                    f.delete();

                    oldRepairNum = "";

                    File file = new File("data/empty.sre");
                    repiarImageView.setImage(new Image(file.toURI().toString()));
                }

            } else {
                // ... user chose CANCEL or closed the dialog
            }
       }
    }

    private void updateReport(String reportID, String slectedWeapon, String slectedUnit, String inspection, String weaponID, String img) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("سيتم التعديل على النموذج رقم  "+oldRepairNum);
        alert.setContentText("ليس هو؟ ابحث عن النموذج قبل التعديل");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            if(!"".equals(reportID)&&!"".equals(weaponID)&&!"".equals(img)){

                String fileName = "Report_"+reportID+".sre";

                File source = new File(img);
                File dest = new File("data/"+fileName);
                try {
                    if(!source.getName().equals(dest.getName())){
                        FileUtils.copyFile(source, dest);

                        if(!oldRepairNum.equals(reportID)){
                            File f = new File("data/Report_"+oldRepairNum+".sre");
                            f.delete();
                        }
                    }

                    dataBase.reportUpdate(new Report(reportID, slectedWeapon, slectedUnit, inspection, weaponID, fileName,""),oldRepairNum);
                    oldRepairNum = repairIDField.getText();
                } catch (IOException e) {
                
                }
            }else{
            
            }
            
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    private void printReport(String id) {
        
        
        String IMG_NAME = dataBase.getReportImgName(id);
        
        if(IMG_NAME!=null){
            String FILE_NAME = "toPrint.pdf";
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                document.open();
                
                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("data/"+IMG_NAME);
                int indentation = 0;
                float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
               - document.rightMargin() - indentation) / image.getWidth()) * 100;
                image.scalePercent(scaler);
                document.add(image);
                
                document.close();
                Desktop.getDesktop().open(new File(FILE_NAME));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void importReportData(MouseEvent event) {
        int i = searchTable.getSelectionModel().getSelectedIndex();
        String id;
        if(i!=-1){
                id = searchTable.getSelectionModel().getSelectedItem().getId();
                String IMG_NAME = dataBase.getReportImgName(id);

                File file = new File("data/"+IMG_NAME);
                Image img = new Image(file.toURI().toString());
                repiarImageView_1.setImage(img);
            }
    }

    private void printReport_1() {
        
        int i = searchTable.getSelectionModel().getSelectedIndex();
        String id;
        if(i!=-1){
            
            id = searchTable.getSelectionModel().getSelectedItem().getId();
            String IMG_NAME = dataBase.getReportImgName(id);

            if(IMG_NAME!=null){
                String FILE_NAME = "toPrint.pdf";
                Document document = new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                    document.open();
                    
                    com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("data/"+IMG_NAME);
                    int indentation = 0;
                    float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                   - document.rightMargin() - indentation) / image.getWidth()) * 100;
                    image.scalePercent(scaler);
                    document.add(image);

                    document.close();
                    Desktop.getDesktop().open(new File(FILE_NAME));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدد عنصر للطباعة");
            a.setContentText("");
            a.showAndWait();
        }
    }

    private void deleteRepair_1() {
        
        int i = searchTable.getSelectionModel().getSelectedIndex();
        
        String id;
        if(i!=-1){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("سوف يتم حذف العنصر نهائيا");
            alert.setContentText("");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                id = searchTable.getSelectionModel().getSelectedItem().getId();

                ///////////////

                boolean isDeleted = dataBase.reportDelete(id);
                if(isDeleted){
                    File f = new File("data/Report_"+id+".sre");
                    f.delete();

                    searchTable.getItems().remove(searchTable.getSelectionModel().getSelectedItem());

                    File file = new File("data/empty.sre");
                    repiarImageView_1.setImage(new Image(file.toURI().toString()));
                }

            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    private void searchByReportId_1() {
        
        int i = searchTable.getSelectionModel().getSelectedIndex();
        
        String id;
        if(i!=-1){
            
            id = searchTable.getSelectionModel().getSelectedItem().getId();
            
                Report report = dataBase.reportSelect(id);
                
                fillCompoBox();
                
                repairIDField.setText(report.getId());
                repairWeaponDField.setText(report.getWeaponID());
                repairUnitNameCompo.getSelectionModel().select(report.getUnit());
                repairWeaponNameCompo.getSelectionModel().select(report.getWeapon());
                repairInspectionFiled.setText(report.getInspection());
                
                oldRepairNum = report.getId();
                
                File file = new File("data/"+report.getImg());
                repairImgPathLabel.setText(file.getAbsolutePath());

                Image img = new Image(file.toURI().toString());
                repiarImageView.setImage(img);
                
                repairPane.toFront(); 
            
        }
    }
    private void logOut() {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("هل تريد تسجيل الخروج الان");
        alert.setContentText("");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            dashDoorPane.toBack();
            loginPane.toFront();
            
            File file = new File("data/empty.sre");
            
            formNameField.setText("");
            formNumField.setText("");
            formImgPathLabel.setText("");
            oldFormNum = "";
            formImg.setImage(new Image(file.toURI().toString()));
            
            repairIDField.setText("");
            repairInspectionFiled.setText("");
            repairWeaponDField.setText("");
            repairUnitNameCompo.getSelectionModel().select(-1);
            repairWeaponNameCompo.getSelectionModel().select(-1);
            oldRepairNum = "";
            repiarImageView.setImage(new Image(file.toURI().toString()));
            
            weaponNameField.setText("");
            weaponCaliberField.setText("");
            weaponLabelField.setText("");
            weaponModelField.setText("");
            
            unitNameField.setText("");
            
            userNameField.setText("");
            userPassField.setText("");
            oldUserName="";
            editeCheckBox.setSelected(false);
            deleteCheckBox.setSelected(false);
            addCheckBox.setSelected(false);
            printCheckBox.setSelected(false);
            userCheckBox.setSelected(false);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    private void listViewFill() {
        unitListView.getItems().remove(0, unitListView.getItems().size());
        ObservableList<String> uitems = FXCollections.observableArrayList();
        ArrayList<Unit> units = dataBase.unitSelect();
        units.forEach((u) -> {
            uitems.add(u.getName());
        });
        unitListView.getItems().addAll(uitems);
        
        weaponListView.getItems().remove(0, weaponListView.getItems().size());
        ObservableList<String> witems = FXCollections.observableArrayList();
        ArrayList<Weapon> weapon = dataBase.weaponsSelect();
        weapon.forEach((w) -> {
            witems.add(w.getLabel());
        });
        weaponListView.getItems().addAll(witems);
        
    }

    private void search_3() {
        ObservableList<Report> data = FXCollections.observableArrayList();
        orderIDColmun2.setCellValueFactory( new PropertyValueFactory<>("id") );
        WeaponIDColmun2.setCellValueFactory( new PropertyValueFactory<>("weaponID") );
        WeaponColmun2.setCellValueFactory( new PropertyValueFactory<>("weapon") );
        UnitColmun2.setCellValueFactory( new PropertyValueFactory<>("unit") );
        inspectionColmun2.setCellValueFactory( new PropertyValueFactory<>("inspection") );

        searchTable2.setItems(data);

        ArrayList<Report> reports = dataBase.reportSelect();
        
        
        ObservableList<String> selectedUnit = unitListView.getCheckModel().getCheckedItems();
        ObservableList<String> selectedWeapon = weaponListView.getCheckModel().getCheckedItems();
        
        String start;
        String end;
        
        LocalDate selecedStartDate = startDate.getValue();
        LocalDate selecedEndDate = endDate.getValue();

        for (Report r : reports) {
            String unit = r.getUnit();
            String weapon = r.getWeapon();
            String date = r.getDate();
            
            if(selecedEndDate!=null&&selecedStartDate!=null){
                
                end = "" + selecedEndDate.toString();
                start = "" + selecedStartDate.toString();
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                
                try {
                    Date RD = sdformat.parse(date);
                    Date SD = sdformat.parse(start);
                    Date ED = sdformat.parse(end);
                    
                    if(RD.compareTo(SD)>=0 && RD.compareTo(ED)<=0){
                        
                        if(unitListView.getCheckModel().getCheckedItems().isEmpty()&&selectedWeapon.contains(weapon)){
                            data.add(r);
                        }
                        else if(selectedUnit.contains(unit)&&selectedWeapon.contains(weapon)){
                            data.add(r);
                        }
                        else if (selectedUnit.contains(unit)&&weaponListView.getCheckModel().getCheckedItems().isEmpty()){
                            data.add(r);
                        }
                        
                    }
                    
                    
                } catch (ParseException ex) {
                    Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }else{
                
                if(unitListView.getCheckModel().getCheckedItems().isEmpty()&&selectedWeapon.contains(weapon)){
                    data.add(r);
                }
                else if(selectedUnit.contains(unit)&&selectedWeapon.contains(weapon)){
                    data.add(r);
                }
                else if (selectedUnit.contains(unit)&&weaponListView.getCheckModel().getCheckedItems().isEmpty()){
                    data.add(r);
                }
            }
        }
    }

    private void searchByReportId_2() {
        
        int i = searchTable2.getSelectionModel().getSelectedIndex();
        
        String id;
        if(i!=-1){
            
            id = searchTable2.getSelectionModel().getSelectedItem().getId();
            
                Report report = dataBase.reportSelect(id);
                
                fillCompoBox();
                
                repairIDField.setText(report.getId());
                repairWeaponDField.setText(report.getWeaponID());
                repairUnitNameCompo.getSelectionModel().select(report.getUnit());
                repairWeaponNameCompo.getSelectionModel().select(report.getWeapon());
                repairInspectionFiled.setText(report.getInspection());
                
                oldRepairNum = report.getId();
                
                File file = new File("data/"+report.getImg());
                repairImgPathLabel.setText(file.getAbsolutePath());

                Image img = new Image(file.toURI().toString());
                repiarImageView.setImage(img);
                
                repairPane.toFront(); 
            
        }

    }

    private void printReport_2() {
        
        int i = searchTable2.getSelectionModel().getSelectedIndex();
        String id;
        if(i!=-1){
            
            id = searchTable2.getSelectionModel().getSelectedItem().getId();
            String IMG_NAME = dataBase.getReportImgName(id);

            if(IMG_NAME!=null){
                String FILE_NAME = "toPrint.pdf";
                Document document = new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                    document.open();
                    
                    com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("data/"+IMG_NAME);
                    int indentation = 0;
                    float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                   - document.rightMargin() - indentation) / image.getWidth()) * 100;
                    image.scalePercent(scaler);
                    document.add(image);

                    document.close();
                    Desktop.getDesktop().open(new File(FILE_NAME));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدد عنصر للطباعة");
            a.setContentText("");
            a.showAndWait();
        }
    }

    private void deleteRepair_2() {
        int i = searchTable2.getSelectionModel().getSelectedIndex();
        
        String id;
        if(i!=-1){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("سوف يتم حذف العنصر نهائيا");
            alert.setContentText("");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                id = searchTable2.getSelectionModel().getSelectedItem().getId();

                ///////////////

                boolean isDeleted = dataBase.reportDelete(id);
                if(isDeleted){
                    File f = new File("data/Report_"+id+".sre");
                    f.delete();

                    searchTable2.getItems().remove(searchTable2.getSelectionModel().getSelectedItem());

                }

            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    private void addNewUser() {
        String name = userNameField.getText();
        String pass = userPassField.getText();
        
        boolean print = printCheckBox.isSelected();
        boolean edit = editeCheckBox.isSelected();
        boolean add = addCheckBox.isSelected();
        boolean delete = deleteCheckBox.isSelected();
        boolean userAccess = userCheckBox.isSelected();
        
        User user = new User(name, pass, print, edit, add, delete, userAccess);
        
        if(!"".equals(name)&&pass!=null){
            dataBase.userInsert(user);
            
            userNameField.setText("");
            userPassField.setText("");
            oldUserName="";
            editeCheckBox.setSelected(false);
            deleteCheckBox.setSelected(false);
            addCheckBox.setSelected(false);
            printCheckBox.setSelected(false);
            userCheckBox.setSelected(false);
            
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("حدث خطا اثناء حفظ المستخدم");
            a.setContentText("تاكد من ادخال اسم المستخدم و كلمة المرور بشكل صحيح");
            a.showAndWait();
        }
        
    }

    private void deleltUser_(String name) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("سوف يتم حذف المستخدم نهائيا");
        alert.setContentText("");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            if(!"".equals(name)){
            dataBase.userDelete(name);
            
            userNameField.setText("");
            userPassField.setText("");
            oldUserName="";
            editeCheckBox.setSelected(false);
            deleteCheckBox.setSelected(false);
            addCheckBox.setSelected(false);
            printCheckBox.setSelected(false);
            userCheckBox.setSelected(false);
            
            }

        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    private void searchUser_() {
        
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Search");
        dialog.setHeaderText("البحث باسم المستخدم");
        dialog.setContentText("ادخل اسم المستخدم");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            User user = dataBase.userSelect(result.get());
            
            if(user!=null){
                fillCompoBox();
                userNameField.setText(user.getName());
                userPassField.setText(user.getPassword());
                printCheckBox.setSelected(user.isPrint());
                editeCheckBox.setSelected(user.isEdit());
                deleteCheckBox.setSelected(user.isDelete());
                addCheckBox.setSelected(user.isAdd());
                userCheckBox.setSelected(user.isAccessToUSer());
                
                oldUserName = user.getName();
                
            }
        }
        
    }

    private void udateUser() {
        String name = userNameField.getText();
        String pass = userPassField.getText();
        
        boolean print = printCheckBox.isSelected();
        boolean edit = editeCheckBox.isSelected();
        boolean add = addCheckBox.isSelected();
        boolean delete = deleteCheckBox.isSelected();
        boolean userAccess = userCheckBox.isSelected();
        
        User user = new User(name, pass, print, edit, add, delete, userAccess);
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(oldUserName+" "+"سيتم التعديل على المستخدم");
        alert.setContentText("ليس هو؟ ابحث عن المستخدم قبل التعديل");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            boolean returnValue = dataBase.userUpdate(user,oldUserName);
            oldUserName = userNameField.getText();
            
            if(!returnValue){
                editeCheckBox.setSelected(true);
                deleteCheckBox.setSelected(true);
                addCheckBox.setSelected(true);
                printCheckBox.setSelected(true);
                userCheckBox.setSelected(true);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
}

