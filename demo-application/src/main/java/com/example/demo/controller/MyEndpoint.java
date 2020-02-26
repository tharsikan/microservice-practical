package com.example.demo.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Endpoint(id = "stage")
public class MyEndpoint {
    Map<String, Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, Stage> getAllStages() {
        return stages;
    }

    @WriteOperation
    public void setStage(@Selector String name, Stage stage, String ool, String cool) {
        stages.put(name, stage);
    }

    @ReadOperation
    public Stage getStage(@Selector String name) {
        return stages.get(name);
    }

    static class Stage {
        String value;

        public Stage(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
