package sample.controllers;

import javafx.fxml.FXML;
import sample.Main;
import sample.models.data.User;

public class MainController {
    private Main main;

    @FXML
    private void handleEnterAction() {
        User user = main.showEnterPage();
//        if (user.getLogin() != null) { main.showTranslatorPage(person); }
        if (user.getLogin() != null) { System.out.println("kek"); }
    }

    @FXML
    private void handleRegistrationAction() { main.showRegistrationPage(); }

    public void setMainApp(Main main) { this.main = main; }
}
