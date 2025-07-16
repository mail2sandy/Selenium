package testCases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TC013_Jackson_ReadJson {
    public String fixedField;
    public Map<String, Object> dynamicFields = new HashMap<>();

    @JsonAnySetter
    public void add(String key, Object value) {
        dynamicFields.put(key, value);
    }

    public Map<String, Object> getDynamicFields() {
        return dynamicFields;
    }

    public static void main(String[] args) throws Exception {
        String jsonString = "{\"fixedField\": \"value\", \"dynamic1\": 123, \"dynamic2\": \"abc\"}";
        File file = new File(".\\testData\\emp.json");

        ObjectMapper objectMapper = new ObjectMapper();
        TC013_Jackson_ReadJson pojo = objectMapper.readValue(file, TC013_Jackson_ReadJson.class);

        System.out.println("Fixed Field: " + pojo.fixedField);
        System.out.println("Dynamic Fields: " + pojo.getDynamicFields());
        System.out.println(pojo.getDynamicFields().get("Employees"));
        
        pojo.getDynamicFields().get("Employees");
    }
}