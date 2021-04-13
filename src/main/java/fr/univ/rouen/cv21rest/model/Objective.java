package fr.univ.rouen.cv21rest.model;

import org.jetbrains.annotations.NotNull;

public class Objective {
    private String job;

    private ObjectiveRequest request;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ObjectiveRequest getRequest() {
        return request;
    }

    public void setRequest(ObjectiveRequest request) {
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
