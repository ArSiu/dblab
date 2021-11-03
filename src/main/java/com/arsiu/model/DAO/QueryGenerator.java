package com.arsiu.model.DAO;

public class QueryGenerator {
    private final String className;

    public QueryGenerator(String className) {
        this.className = className;
    }

    public String generateFindAll() {
        return "FROM " + className;
    }

    public String generateFindOne() {
        return String.format("FROM %s WHERE id = :id", className);
    }

    public String generateDelete() {
        return String.format("DELETE %s where id = :id", className);
    }
}