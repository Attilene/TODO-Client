package com.attilene.utils.http.api;

import com.attilene.models.data.Task;
import com.attilene.utils.http.HttpClass;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskAPI extends AbstractAPI {
    public String addAndUpdateTask(Task task, String url, String method) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(task);
        return HttpClass.sendPOST_PUT(SERVER_URL + url, jsonString, method);
    }

    public List<Task> getTasksByUserAndCategory(String url) {
        List<Task> result = new ArrayList<>();
        String response = HttpClass.sendGET(SERVER_URL + url);

        if (response == null) {
            return null;
        }
        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(response)).getAsJsonArray();

        for (int i = 0; i < jsonResult.size(); i++) {
            JsonObject curUser = jsonResult.get(i).getAsJsonObject();

            Long id = curUser.get("id").getAsLong();
            String name = curUser.get("name").getAsString();
            String description = curUser.get("description").getAsString();
            Boolean complete = curUser.get("complete").getAsBoolean();

            Task task = new Task(name, description, complete);
            task.setId(id);
            result.add(task);
        }
        return result;
    }

    public String deleteTask(String url) {
        return HttpClass.sendDELETE(SERVER_URL + url);
    }
}
