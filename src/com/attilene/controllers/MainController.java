package com.attilene.controllers;

import com.attilene.Main;
import com.attilene.models.data.User;
import javafx.fxml.FXML;

public class MainController {
    private Main main;

    @FXML
    private void handleEnterAction() {
        User user = main.showEnterPage();
        if (user.getLogin() != null) { main.showTODOPage(user); }
    }

    @FXML
    private void handleRegistrationAction() { main.showRegistrationPage(); }

    public void setMainApp(Main main) { this.main = main; }
}
