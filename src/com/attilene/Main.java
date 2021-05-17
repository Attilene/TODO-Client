package com.attilene;

import com.attilene.controllers.TodoController;
import com.attilene.models.data.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.attilene.controllers.AuthorisationController;
import com.attilene.controllers.MainController;
import com.attilene.controllers.RegistrationController;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;

    public Main() {}

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TODO");
        showMainPage();
    }

    @FXML
    public void showMainPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/Main.fxml"));
            AnchorPane page = loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            MainController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Не удалось загрузить окно!");
        }
    }

    @FXML
    public User showEnterPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/Authorisation.fxml"));
            AnchorPane page = loader.load();
            Stage dialStage = new Stage();
            dialStage.setTitle("Вход в личный кабинет");
            dialStage.initModality(Modality.WINDOW_MODAL);
            dialStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialStage.setScene(scene);
            AuthorisationController controller = loader.getController();
            controller.setDialStage(dialStage);
            dialStage.showAndWait();
            return controller.getUser();
        } catch (IOException e) {
            System.out.println("Не удалось загрузить окно!");
            return null;
        }
    }

    @FXML
    public void showRegistrationPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/Registration.fxml"));
            AnchorPane page = loader.load();
            Stage dialStage = new Stage();
            dialStage.setTitle("Регистрация пользователя");
            dialStage.initModality(Modality.WINDOW_MODAL);
            dialStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialStage.setScene(scene);
            RegistrationController controller = loader.getController();
            controller.setDialStage(dialStage);
            dialStage.showAndWait();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    public void showTODOPage(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/TODO.fxml"));
            AnchorPane page = loader.load();
            Stage dialStage = new Stage();
            dialStage.setTitle("Главная страница");
            dialStage.initModality(Modality.WINDOW_MODAL);
            dialStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialStage.setScene(scene);
            TodoController controller = loader.getController();
//            controller.setDialStage(dialStage);
            dialStage.showAndWait();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
