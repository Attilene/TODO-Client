package sample.models.data;

import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Task implements APIModel {
    private Long id;
    private String title;
    private String text;
    private Boolean complete;

    public Task() {}

    public Task(String title, String text, Boolean complete) {
        this.title = title;
        this.text = text;
        this.complete = complete;
    }

    @Override
    public String toJson() {
        Map<String, String> map = new HashMap<>() {{
            put("name", title);
            put("description", text);
            put("operation_date", new Date().toString());
            put("complete", complete.toString());
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", complete=" + complete +
                '}';
    }
}
