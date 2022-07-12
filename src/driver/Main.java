package driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        /// arabic text fix
        System.setProperty("prism.text", "t2k");
        System.setProperty("prism.lcdtext", "false");
        
        Parent root = FXMLLoader.load(getClass().getResource("/gui/dashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        Image i = new Image("/Resources/047-connection.png");
        stage.getIcons().add(i);
        
        stage.setTitle("Weapons Repair Data Base");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        
        // connect data base
        dataBase.connect();
        
        // launch gui
        launch(args);
        
    }
}
