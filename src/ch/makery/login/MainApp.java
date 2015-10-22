package ch.makery.login;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;


	  //@FXML private Button loginButton;
	  
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene scene = new Scene(root);
        
        this.primaryStage.setTitle("FPTS");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        
    }




    public static void main(String[] args) {
        launch(args);
    }
}