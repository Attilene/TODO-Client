package com.attilene.controllers;

import com.attilene.models.data.User;
import com.attilene.models.fields.RegistrationEditModel;
import com.attilene.utils.AlertsUtil;
import com.attilene.utils.RestAPI;
import javafx.fxml.FXML;
import com.attilene.utils.ValidUtil;

public class RegistrationController extends RegistrationEditModel {
    @FXML
    public void initialize() {
        loginField.setText(null);
        emailField.setText(null);
        passwordField.setText(null);
        repeatPasswordField.setText(null);
    }

    @FXML
    private void handleRegistration () {
        if (passwordToggle.isSelected()) {
            passwordField.setText(visiblePasswordField.getText());
            repeatPasswordField.setText(visibleRepeatPasswordField.getText());
        }
        if (ValidUtil.isInputValidRegistrationEdit(this, dialStage)) {
            if (ValidUtil.isInputValidLength(this, dialStage)) {
                if (ValidUtil.isRegExValidRegistrationEdit(this, dialStage)) {
                    RestAPI restAPI = new RestAPI();
                    User new_user = restAPI.userSignUpIn(
                            new User(
                                    loginField.getText(),
                                    emailField.getText(),
                                    passwordField.getText()),
                            "/users"
                    );

                    if (new_user != null) dialStage.close();
                    else AlertsUtil.showUserExistAlert(dialStage);
                    System.out.println(new_user);
                }
            }
        }
    }
}
