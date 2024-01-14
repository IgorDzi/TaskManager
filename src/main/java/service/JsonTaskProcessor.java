package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import data.Task;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The type Json task processor.
 */
public class JsonTaskProcessor implements TaskProcessor{

    @Override
    public List<Task> importTasks(String filePath) {
        JsonMapper objectMapper = new JsonMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
        List<Task> tasks = null;
        try {
            tasks = objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void saveTasks(List<Task> tasks, String filePath) {
        JsonMapper objectMapper = new JsonMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);

        try {
            objectMapper.writeValue(new File(filePath), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
