package com.interview;

public class MySingleton2 {


    private static volatile MySingleton2 instance;

    private MySingleton2() {}

    public static MySingleton2 getInstance() {
        if (instance == null) {
            synchronized(MySingleton2.class) {
                if (instance == null) {
                    instance = new MySingleton2();
                }
            }
        }
        return instance;
    }


}
