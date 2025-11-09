package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDataLoader {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static JsonNode loadLoginData() {
        //make this path dynamic
        Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "loginData.json");
        try (InputStream is = Files.newInputStream(path)) {
            return MAPPER.readTree(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load loginData.json from " + path, e);
        }
    }
}
