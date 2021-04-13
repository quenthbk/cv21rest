package fr.univ.rouen.cv21rest.model;

import org.jetbrains.annotations.NotNull;

public class Objective {
    private String job;

    private String request;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "job='" + job + '\'' +
                ", request='" + request + '\'' +
                '}';
    }
}
