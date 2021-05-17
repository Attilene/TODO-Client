package com.attilene.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public final class AlertsUtil {
    private AlertsUtil() {}

    public static boolean showDeleteProfileConfirmationAlert(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(stage);
        alert.setTitle("Удаление профиля");
        alert.setHeaderText("Вы уверены, что хотите удалить свой профиль?");
        for (ButtonType type: alert.getButtonTypes())
            ((Button) alert.getDialogPane().lookupButton(type)).setDefaultButton(type == ButtonType.CANCEL);
        return alert.showAndWait().get() == ButtonType.OK;
    }

    public static void showInputValidAlert(Stage stage, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Неправильно заполненные поля");
        alert.setHeaderText("Исправьте неправильно заполненные поля");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showWrongFormatStandardAlert(Stage stage, String name) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Неверный формат строки");
        alert.setHeaderText("Неправильный формат текстового поля: " + name);
        alert.setContentText("Не допускаются символы: % \" ' ; :");
        alert.showAndWait();
    }

    public static void showNoValidEnterAlert(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Ошибка входа");
        alert.setHeaderText("Недействительные логин/почта или пароль!");
        alert.setContentText("Введите корректные данные или зарегистрируйтесь");
        alert.showAndWait();
    }

    public static void showIncorrectEmailAlert(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Неправильный формат почты");
        alert.setHeaderText("Введите корректную электронную почту!");
        alert.showAndWait();
    }

    public static void showWrongFormatPasswordAlert(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Неправильный формат пароля");
        alert.setHeaderText("Введите пароль в нужном формате");
        alert.setContentText("""
                Длина пароля: не менее 8 символов
                Пароль должен содержать:
                заглавные буквы, строчные буквы, цифры,
                специальные символы из списка: @ # $""");
        alert.showAndWait();
    }

    public static void showBigStringAlert(Stage stage, String name, int symbols) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Превышение длины строки");
        alert.setHeaderText("Длина поля " + name + " больше " + symbols + " символов!");
        alert.setContentText("Измените значение текстового поля");
        alert.showAndWait();
    }

    public static void showUserExistAlert(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Пользователь существует");
        alert.setHeaderText("Пользователь с такими данными уже существует!");
        alert.setContentText("Логин и почта должны быть уникальными");
        alert.showAndWait();
    }

    public static void showUserNotExistAlert(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Пользователь не существует");
        alert.setHeaderText("Пользователь с такой электронной почтой не существует!");
        alert.setContentText("Введите корректную почту");
        alert.showAndWait();
    }

//    public static void showNotSelectedHistory(Stage stage) {
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.initOwner(stage);
//        alert.setTitle("Ничего не выбрано!");
//        alert.setHeaderText("История перевода не выбрана!");
//        alert.setContentText("Пожалуйста, выберите историю!");
//        alert.showAndWait();
//    }

//    public static void showInternalServerErrorAlert(Stage stage) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.initOwner(stage);
//        alert.setTitle("Ошибка сервера");
//        alert.setHeaderText("Сервер временно недоступен!");
//        alert.setContentText("Свяжитесь с администратором или повторите попытку позже");
//        alert.showAndWait();
//    }

//    public static void showFailedTranslateAlert(Stage stage) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.initOwner(stage);
//        alert.setTitle("Перевод не удался");
//        alert.setHeaderText("Введите правильную строку для перевода!");
//        alert.setContentText("Строка не должна быть пустой.\nЯзык строки должен соответствовать переключателям");
//        alert.showAndWait();
//    }
}
