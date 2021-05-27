package com.attilene.controllers;

import com.attilene.models.data.User;
import com.attilene.models.fields.RegistrationEditModel;
import com.attilene.utils.alerts.AlertsUtil;
import com.attilene.utils.http.api.UserAPI;
import javafx.fxml.FXML;
import com.attilene.utils.validation.ValidUtil;

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
                    UserAPI userAPI = new UserAPI();
                    User new_user = userAPI.userSignUpIn(
                            new User(
                                    loginField.getText(),
                                    emailField.getText(),
                                    passwordField.getText()),
                            "/users"
                    );
                    if (new_user != null) {
                        if (new_user.getId() == null) {
                            AlertsUtil.showInternalServerErrorAlert(dialStage);
                        }
                        else
                            dialStage.close();
                    }
                    else AlertsUtil.showUserExistAlert(dialStage);
                }
            }
        }
    }
}
