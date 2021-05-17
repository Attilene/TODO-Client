package sample.controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import sample.models.data.User;
import sample.models.fields.EnterModel;

public class AuthorisationController extends EnterModel {
    private final Gson gson = new Gson();
    private User user;

    @FXML
    private void initialize() {
        userLogEmailField.setText(null);
        passwordField.setText(null);
        user = new User();
    }

    @FXML
    private void handleEnter() {
//        if (passwordToggle.isSelected())
//            passwordField.setText(visiblePasswordField.getText());
//        if (ValidUtil.isInputValidEnter(this, dialStage)) {
//            if (ValidUtil.isRegExValidEnter(this, dialStage)) {
//                RequestsUtil requestsUtil = new RequestsUtil("/enter", "POST");
//                requestsUtil.setParams(new HashMap<>() {{
//                    put("login_email", userLogEmailField.getText());
//                    put("password", passwordField.getText());
//                }});
//                requestsUtil.thread.start();
//                RequestsUtil.runningThread(requestsUtil, dialStage);
//                if (!Objects.equals(requestsUtil.getResponse(), "") && requestsUtil.getResponse() != null) {
//                    User user = gson.fromJson(requestsUtil.getResponse(), User.class);
//                    person.setId(user.getId());
//                    person.setFirstName(user.getFirst_name());
//                    person.setLastName(user.getLast_name());
//                    person.setLogin(user.getLogin());
//                    person.setEmail(user.getEmail());
//                    person.setPhoneNumber(user.getPhone_number());
//                    if (user.getBirthday() == null) person.setBirthday(null);
//                    else person.setBirthday(LocalDate.parse(user.getBirthday()));
//                    person.setPassword(passwordField.getText());
//                    person.setRepeatPassword(passwordField.getText());
//                    dialStage.close();
//                } else if (!requestsUtil.getDisconnect()
//                        && Objects.equals(requestsUtil.getResponse(), ""))
//                    AlertsUtil.showNoValidEnterAlert(dialStage);
//            }
//        }
    }

    public User getUser() { return user; }
}
