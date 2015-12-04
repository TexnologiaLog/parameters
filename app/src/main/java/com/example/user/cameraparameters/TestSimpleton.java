package com.example.user.cameraparameters;

/**
 * Created by User on 4/12/2015.
 */
public class TestSimpleton {
    private static TestSimpleton ourInstance = new TestSimpleton();
    private String parameters;
    public static TestSimpleton getInstance() {
        return ourInstance;
    }

    private TestSimpleton() {
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
