package com.attilene.controllers;

import com.attilene.Main;
import com.attilene.models.data.Category;
import com.attilene.models.data.Task;
import com.attilene.models.data.User;
import com.attilene.utils.alerts.AlertsUtil;
import com.attilene.utils.http.api.CategoryAPI;
import com.attilene.utils.http.api.TaskAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class TodoController {
    @FXML
    private TableView<Task> taskTableView;

    @FXML
    private TableView<Category> categoryTableView;

    @FXML
    private TableColumn<Task, String> taskNameColumn;

    @FXML
    private TableColumn<Task, String> taskDescriptionColumn;

    @FXML
    private TableColumn<Task, Boolean> taskCompleteColumn;

    @FXML
    private TableColumn<Category, String> categoryNameColumn;

    private User user;

    private Stage dialStage;

    private ObservableList<Task> tasksData;

    private ObservableList<Category> categoriesData;

    private Main main;

    @FXML
    private void handleCreateTask() {

    }

    @FXML
    private void handleUpdateTask() {

    }

    @FXML
    private void handleDeleteTask() {
        int selectedIndex = taskTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            TaskAPI taskAPI = new TaskAPI();
            String response = taskAPI.deleteTask(
                    "/tasks/" + taskTableView.getItems().get(selectedIndex).getId());
            if (response == null) {
                AlertsUtil.showInternalServerErrorAlert(dialStage);
            }
            else if (response.equals("OK")) {
                taskTableView.getItems().remove(selectedIndex);
            }
        }
        else { AlertsUtil.showNotSelectedTask(dialStage); }
    }

    @FXML
    private void handleCreateCategory() {
        main.showCategoryPage(null, dialStage, "/categories", "POST");
        CategoryAPI categoryAPI = new CategoryAPI();
        this.setCategories(categoryAPI.getCategories("/categories"));
        this.showCategoriesData();
    }

    @FXML
    private void handleUpdateCategory() {
        int selectedIndex = categoryTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            main.showCategoryPage(
                    categoryTableView.getItems().get(selectedIndex),
                    dialStage,
                    "/categories/" + categoryTableView.getItems().get(selectedIndex).getId(),
                    "PUT");
            CategoryAPI categoryAPI = new CategoryAPI();
            this.setCategories(categoryAPI.getCategories("/categories"));
            this.showCategoriesData();
        }
        else { AlertsUtil.showNotSelectedCategory(dialStage); }
    }

    @FXML
    private void handleDeleteCategory() {
        int selectedIndex = categoryTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            CategoryAPI categoryAPI = new CategoryAPI();
            String response = categoryAPI.deleteCategory(
                    "/categories/" + categoryTableView.getItems().get(selectedIndex).getId());
            if (response == null) {
                AlertsUtil.showInternalServerErrorAlert(dialStage);
            }
            else if (response.equals("OK")) {
                categoryTableView.getItems().remove(selectedIndex);
            }
        }
        else { AlertsUtil.showNotSelectedCategory(dialStage); }
    }

    @FXML
    public void handleShowTasks() {
        int selectedIndex = categoryTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            TaskAPI taskAPI = new TaskAPI();
            this.setTasks(taskAPI.getTasksByUserAndCategory("/users/" + user.getId() + "/category/" +
                    categoryTableView.getItems().get(selectedIndex).getId() + "/tasks"));
            this.showTasksData();
        }
    }

    public void showTasksData() {
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        taskCompleteColumn.setCellValueFactory(new PropertyValueFactory<>("complete"));
        taskTableView.setItems(tasksData);
    }

    public void showCategoriesData() {
        categoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryTableView.setItems(categoriesData);
    }

    @FXML
    private void handleCancel() { dialStage.close(); }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDialStage(Stage dialStage) {
        this.dialStage = dialStage;
    }

    public void setTasks(List<Task> tasks) {
        tasksData = FXCollections.observableArrayList();
        tasksData.addAll(tasks);
    }

    public void setCategories(List<Category> categories) {
        categoriesData = FXCollections.observableArrayList();
        categoriesData.addAll(categories);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
