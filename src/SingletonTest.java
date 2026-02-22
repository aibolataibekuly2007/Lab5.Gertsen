public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===");

        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println("config1 hash: " + System.identityHashCode(config1));
        System.out.println("config2 hash: " + System.identityHashCode(config2));
        System.out.println("Same instance: " + (config1 == config2));

        config1.displayAllSettings();

        config1.setSetting("app.theme", "dark");
        config1.setSetting("max.connections", "20");

        System.out.println("\nconfig1 theme: " + config1.getSetting("app.theme"));
        System.out.println("config2 theme: " + config2.getSetting("app.theme"));

        config1.saveToFile("test_config.properties");

        ConfigurationManager config3 = ConfigurationManager.getInstance("test_config.properties");
        System.out.println("\nconfig3 hash: " + System.identityHashCode(config3));
        System.out.println("Same instance after loading file: " + (config1 == config3));
    }
}