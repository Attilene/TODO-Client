package sample.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sample.models.data.Category;
import sample.models.data.Task;
import sample.models.data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestAPI {
    private static final String SERVER_URL = "http://localhost:10000";

    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        String buffer = HttpClass.getRequest(SERVER_URL + "/users");
        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(buffer)).getAsJsonArray();

        for (int i = 0; i < jsonResult.size(); i++) {
            JsonObject curUser = jsonResult.get(i).getAsJsonObject();

            Long id = curUser.get("id").getAsLong();
            String login = curUser.get("login").getAsString();
            String email = curUser.get("email").getAsString();
            String password = curUser.get("password").getAsString();

            User user = new User(login, email, password);
            user.setId(id);
            result.add(user);
        }
        return result;
    }

    public User getTask(Object pathVariable) {
        String buffer = HttpClass.getRequest(SERVER_URL + "/users/" + pathVariable);
        return getUser(buffer);
    }

    public User addUser(User user) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        String buffer = HttpClass.ppdRequest(SERVER_URL + "/users", "POST", jsonString);
        return getUser(buffer);
    }

    private User getUser(String buffer) {
        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(buffer)).getAsJsonArray();
        JsonObject curUser = jsonResult.get(0).getAsJsonObject();

        Long id = curUser.get("id").getAsLong();
        String login = curUser.get("login").getAsString();
        String email = curUser.get("email").getAsString();
        String password = curUser.get("password").getAsString();

        User newUser = new User(login, email, password);
        newUser.setId(id);
        return newUser;
    }

    public List<Task> getTasks() {
        List<Task> result = new ArrayList<>();
        String buffer = HttpClass.getRequest(SERVER_URL + "/tasks");
        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(buffer)).getAsJsonArray();

        for (int i = 0; i < jsonResult.size(); i++) {
            JsonObject curUser = jsonResult.get(i).getAsJsonObject();

            Long id = curUser.get("id").getAsLong();
            String title = curUser.get("name").getAsString();
            String text = curUser.get("description").getAsString();
            Boolean complete = curUser.get("complete").getAsBoolean();

            Task task = new Task(title, text, complete);
            task.setId(id);
            result.add(task);
        }
        return result;
    }
}
