package com.attilene.utils.http.api;

import com.attilene.models.data.Category;
import com.attilene.models.data.User;
import com.attilene.utils.http.HttpClass;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryAPI extends AbstractAPI {
    public String addCategory(Category category, String url, String method) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(category);
        return HttpClass.sendPOST_PUT(SERVER_URL + url, jsonString, method);
    }

    public List<Category> getCategories(String url) {
        List<Category> result = new ArrayList<>();
        String response = HttpClass.sendGET(SERVER_URL + url);

        if (response == null) {
            return null;
        }
        JsonArray jsonResult = JsonParser.parseString(Objects.requireNonNull(response)).getAsJsonArray();

        for (int i = 0; i < jsonResult.size(); i++) {
            JsonObject curUser = jsonResult.get(i).getAsJsonObject();

            Long id = curUser.get("id").getAsLong();
            String name = curUser.get("name").getAsString();

            Category category = new Category(name);
            category.setId(id);
            result.add(category);
        }
        return result;
    }

    public String deleteCategory(String url) {
        return HttpClass.sendDELETE(SERVER_URL + url);
    }
}
