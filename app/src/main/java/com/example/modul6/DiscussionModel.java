package com.example.modul6;

public class DiscussionModel {
    private String name, comment;

    public DiscussionModel(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
