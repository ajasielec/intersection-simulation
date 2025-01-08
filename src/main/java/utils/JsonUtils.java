package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import simulation.CommandList;
import simulation.SimulationResult;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // JSON commands deserialization
    public static CommandList deserializeCommands (String filename) throws IOException {
        return objectMapper.readValue(new File(filename), CommandList.class);
    }

    // JSON result serialization
    public static void serializeResult (SimulationResult simulationResult, String outputPath) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File (outputPath), simulationResult);
    }
}
