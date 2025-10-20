package com.example.taskapi.model;

public class Task {
    private String id;
    private String name;
    private String owner;
    private String command;

    public Task() {}
    public Task(String id, String name, String owner, String command) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.command = command;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public String getCommand() { return command; }
    public void setCommand(String command) { this.command = command; }
}