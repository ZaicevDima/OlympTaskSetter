package com.zaytsev.d.olymp_task_setter.parsers;

import java.util.List;

public abstract class Parser {
    private final String URL;
    private final String token;


    Parser(String URL, String token) {
        this.URL = URL;
        this.token = token;
    }
    abstract List<String> getUserNames();
    abstract List<String> getActivityName();

    abstract List<String> getAmountTask(String lesson);

    abstract List<String> addUserNames();
    abstract List<String> setActivityName();

    abstract List<String> setAmountTask(String lesson);
}
