import java.util.logging.Logger;

public class CustomLogger extends Logger {
    private CustomLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    // Provide a no-arg constructor
    public CustomLogger() {
        super(Logger.GLOBAL_LOGGER_NAME, null);
    }
}
