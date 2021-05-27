package com.attilene.controllers;

import com.attilene.models.data.Task;
import com.attilene.utils.alerts.AlertsUtil;
import com.attilene.utils.http.api.TaskAPI;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskController {
    @FXML
    private TextField nameTaskField;

    @FXML
    private TextArea descriptionTaskArea;

    @FXML
    private CheckBox completeCheckBox;

    private String method;

    private String url;

    private Stage dialStage;

    @FXML
    private void initialize() {
        descriptionTaskArea.setWrapText(true);
    }

    @FXML
    private void handleCreateAndUpdate() {
        String errors = "";
        if (nameTaskField.getText() == null)
            errors += "Пустая строка имени задачи!\n";
        if (descriptionTaskArea.getText() == null)
            errors += "Пустое поле описания задачи!\n";
        if (errors.equals("")) {
            TaskAPI taskAPI = new TaskAPI();
            String response = taskAPI.addAndUpdateTask(
                    new Task(
                            nameTaskField.getText(),
                            descriptionTaskArea.getText(),
                            completeCheckBox.isSelected()
                    ),
                    url,
                    method);
            if (response == null || response.equals("500"))
                AlertsUtil.showInternalServerErrorAlert(dialStage);
            else
                dialStage.close();
        }
        else {
            AlertsUtil.showInputValidAlert(dialStage, "Пустая строка имени задачи!");
        }
    }

    @FXML
    private void handleCancel() {
        dialStage.close();
    }

    public void setDialStage(Stage dialStage) {
        this.dialStage = dialStage;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTask(Task task) {
        if (task != null) {
            nameTaskField.setText(task.getName());
            descriptionTaskArea.setText(task.getDescription());
            completeCheckBox.setSelected(task.getComplete());
        }
    }
}
