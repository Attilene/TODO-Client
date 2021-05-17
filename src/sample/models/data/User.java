package sample.models.data;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class User implements APIModel {
    private Long id;
    private String login;
    private String email;
    private String password;

    public User() {}

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toJson() {
        Map<String, String> map = new HashMap<>() {{
            put("login", login);
            put("email", email);
            put("password", password);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login=" + login +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
