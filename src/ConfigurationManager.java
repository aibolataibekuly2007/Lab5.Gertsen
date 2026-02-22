import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance;
    private static final ReentrantLock lock = new ReentrantLock();

    private Map<String, String> settings;
    private String configFile;

    private ConfigurationManager() {
        settings = new HashMap<>();
        loadDefaultSettings();
    }

    private ConfigurationManager(String configFile) {
        this();
        this.configFile = configFile;
        loadFromFile();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public static ConfigurationManager getInstance(String configFile) {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConfigurationManager(configFile);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private void loadDefaultSettings() {
        settings.put("app.name", "MyApplication");
        settings.put("app.version", "1.0.0");
        settings.put("app.language", "en");
        settings.put("app.theme", "light");
        settings.put("database.url", "jdbc:mysql://localhost:3306/mydb");
        settings.put("database.username", "root");
        settings.put("database.password", "password");
        settings.put("logging.level", "INFO");
        settings.put("logging.file", "app.log");
        settings.put("max.connections", "10");
        settings.put("timeout.seconds", "30");
    }

    public void loadFromFile() {
        if (configFile == null) {
            configFile = "config.properties";
        }

        Properties props = new Properties();
        try (InputStream input = new FileInputStream(configFile)) {
            props.load(input);
            for (String key : props.stringPropertyNames()) {
                settings.put(key, props.getProperty(key));
            }
            System.out.println("Configuration loaded from file: " + configFile);
        } catch (IOException e) {
            System.out.println("Config file not found, using defaults: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        this.configFile = filename;
        loadFromFile();
    }

    public void saveToFile() {
        saveToFile("config.properties");
    }

    public void saveToFile(String filename) {
        Properties props = new Properties();
        props.putAll(settings);

        try (OutputStream output = new FileOutputStream(filename)) {
            props.store(output, "Application Configuration");
            System.out.println("Configuration saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving configuration: " + e.getMessage());
        }
    }

    public String getSetting(String key) {
        String value = settings.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Setting not found: " + key);
        }
        return value;
    }

    public String getSetting(String key, String defaultValue) {
        return settings.getOrDefault(key, defaultValue);
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }

    public int getIntSetting(String key) {
        try {
            return Integer.parseInt(getSetting(key));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Setting is not a valid integer: " + key);
        }
    }

    public boolean getBooleanSetting(String key) {
        String value = getSetting(key).toLowerCase();
        return value.equals("true") || value.equals("yes") || value.equals("1");
    }

    public void displayAllSettings() {
        System.out.println("\n=== Current Configuration ===");
        for (Map.Entry<String, String> entry : settings.entrySet()) {
            if (entry.getKey().contains("password")) {
                System.out.println(entry.getKey() + " = [HIDDEN]");
            } else {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    public void resetToDefaults() {
        settings.clear();
        loadDefaultSettings();
        System.out.println("Configuration reset to defaults");
    }
}