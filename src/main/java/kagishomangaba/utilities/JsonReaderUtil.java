package kagishomangaba.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class JsonReaderUtil{

    public static List<HashMap<String, String>> getJsonDataToMap(String filePath) {
        try {
            String jsonContent = FileUtils.readFileToString(
                    new File(filePath),
                    StandardCharsets.UTF_8
            );

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    jsonContent,
                    new TypeReference<List<HashMap<String, String>>>() {}
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON test data: " + filePath, e);
        }
    }
}
