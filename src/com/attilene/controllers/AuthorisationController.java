package com.attilene.controllers;

import com.attilene.models.data.User;
import com.attilene.models.fields.EnterModel;
import com.attilene.utils.AlertsUtil;
import com.attilene.utils.RestAPI;
import com.attilene.utils.ValidUtil;
import javafx.fxml.FXML;

public class AuthorisationController extends EnterModel {
    private User user;

    @FXML
    private void initialize() {
        userLogEmailField.setText(null);
        passwordField.setText(null);
        user = new User();
    }

    @FXML
    private void handleEnter() {
        if (passwordToggle.isSelected())
            passwordField.setText(visiblePasswordField.getText());
        if (ValidUtil.isInputValidEnter(this, dialStage)) {
            if (ValidUtil.isRegExValidEnter(this, dialStage)) {
                RestAPI restAPI = new RestAPI();
                User new_user = restAPI.userSignUpIn(
                        new User(
                                userLogEmailField.getText(),
                                userLogEmailField.getText(),
                                passwordField.getText()),
                        "/authorization"
                );

                if (new_user != null) {
                    user = new_user;
                    dialStage.close();
                }
                else AlertsUtil.showNoValidEnterAlert(dialStage);
            }
        }
    }

    public User getUser() { return user; }
}
