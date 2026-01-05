package kagishomangaba.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties;

    private ConfigLoader() {}

    public static Properties getProperties() {
        if (properties == null) {
            loadProperties();
        }
        return properties;
    }

    private static void loadProperties() {
        try {
            String path = Paths.get(
                    System.getProperty("user.dir"),
                    "src", "main", "java",
                    "kagishomangaba", "resources",
                    "Globaldata.properties"
            ).toString();

            properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }
}
