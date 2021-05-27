package com.attilene.utils.http.api;

import com.attilene.utils.http.HttpClass;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.attilene.models.data.User;


public class UserAPI extends AbstractAPI {
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

    public User userSignUpIn(User user, String url) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        String response = HttpClass.sendPOST_PUT(SERVER_URL + url, jsonString, "POST");

        if (response == null) {
            return null;
        }
        else if (response.equals("500")) {
            return new User();
        }

        JsonObject curUser = JsonParser.parseString(response).getAsJsonObject();
        Long id = curUser.get("id").getAsLong();
        String login = curUser.get("login").getAsString();
        String email = curUser.get("email").getAsString();
        String password = curUser.get("password").getAsString();

        User newUser = new User(login, email, password);
        newUser.setId(id);
        return newUser;
    }
}
