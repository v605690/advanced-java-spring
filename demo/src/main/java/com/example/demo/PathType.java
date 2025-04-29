package com.example.demo;

public enum PathType{

    HELLO("hello"),
    GOODBYE("goodbye"),
    SUCCESS("success");

    private final String path;
    private static final String BASE_PATH = "spring fundamentals/";
    PathType(String path) {
        this.path = BASE_PATH + path;
    }

    public String getFullPath() {
        return path;
    }
}
