package com.interview;

public class MySingleton1 {

    private static final MySingleton1 instance = new MySingleton1();

    private MySingleton1() {}

    public static MySingleton1 getInstance() {
        return instance;
    }


}
