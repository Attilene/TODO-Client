package com.attilene.controllers;

import com.attilene.models.data.Category;
import com.attilene.utils.alerts.AlertsUtil;
import com.attilene.utils.http.api.CategoryAPI;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryController {
    @FXML
    private TextField categoryNameField;

    private String method;

    private String url;

    private Stage dialStage;

    @FXML
    private void handleCreateAndUpdate() {
        if (categoryNameField.getText() != null) {
            CategoryAPI categoryAPI = new CategoryAPI();
            String response = categoryAPI.addCategory(
                    new Category(categoryNameField.getText()), url, method);
            if (response == null || response.equals("500"))
                AlertsUtil.showInternalServerErrorAlert(dialStage);
            dialStage.close();
        } else
            AlertsUtil.showInputValidAlert(dialStage, "Пустая строка имени категории!");
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

    public void setCategory(Category category) {
        if (category != null)
            categoryNameField.setText(category.getName());
    }
}
