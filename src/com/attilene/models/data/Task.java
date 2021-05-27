package com.attilene.models.data;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Boolean complete;
    private Date operation_date;

    public Task() {}

    public Task(String name, String description, Boolean complete, Date operation_date) {
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.operation_date = operation_date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", operation_date=" + operation_date +
                '}';
    }
}
