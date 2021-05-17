package com.attilene.models.data;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Category implements APIModel {
    private Long id;
    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toJson() {
        Map<String, String> map = new HashMap<>() {{
            put("name", name);
        }};

        Gson gson = new Gson();
        return gson.toJson(map);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
