package com.attilene.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.attilene.models.data.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RestAPI {
    private static final String SERVER_URL = "http://localhost:10000";

//    public List<User> getUsers() {
//        List<User> result = new ArrayList<>();
//        String buffer = HttpClass.getRequest(SERVER_URL + "/users");
//        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(buffer)).getAsJsonArray();
//
//        for (int i = 0; i < jsonResult.size(); i++) {
//            JsonObject curUser = jsonResult.get(i).getAsJsonObject();
//
//            Long id = curUser.get("id").getAsLong();
//            String login = curUser.get("login").getAsString();
//            String email = curUser.get("email").getAsString();
//            String password = curUser.get("password").getAsString();
//
//            User user = new User(login, email, password);
//            user.setId(id);
//            result.add(user);
//        }
//        return result;
//    }

//    public User getTask(Object pathVariable) {
//        String buffer = HttpClass.getRequest(SERVER_URL + "/users/" + pathVariable);
//        return getUser(buffer);
//    }

    public User userSignUpIn(User user, String url) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        String response = HttpClass.sendPOST_PUT(SERVER_URL + url, jsonString, "POST");

        if (response == null) {
            return null;
        }
//        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(response)).getAsJsonArray();
//        JsonObject curUser = jsonResult.get(0).getAsJsonObject();

        JsonObject curUser = JsonParser.parseString(response).getAsJsonObject();
        Long id = curUser.get("id").getAsLong();
        String login = curUser.get("login").getAsString();
        String email = curUser.get("email").getAsString();
        String password = curUser.get("password").getAsString();

        User newUser = new User(login, email, password);
        newUser.setId(id);
        return newUser;
    }

//    private User getUser(String buffer) {
//
//    }

//    public List<Task> getTasks() {
//        List<Task> result = new ArrayList<>();
//        String buffer = HttpClass.getRequest(SERVER_URL + "/tasks");
//        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(buffer)).getAsJsonArray();
//
//        for (int i = 0; i < jsonResult.size(); i++) {
//            JsonObject curUser = jsonResult.get(i).getAsJsonObject();
//
//            Long id = curUser.get("id").getAsLong();
//            String title = curUser.get("name").getAsString();
//            String text = curUser.get("description").getAsString();
//            Boolean complete = curUser.get("complete").getAsBoolean();
//
//            Task task = new Task(title, text, complete);
//            task.setId(id);
//            result.add(task);
//        }
//        return result;
//    }
}