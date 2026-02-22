public class MultiThreadSingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Multi-threaded Singleton Test ===");

        Runnable task = () -> {
            ConfigurationManager config = ConfigurationManager.getInstance();
            System.out.println("Thread " + Thread.currentThread().getId() +
                    " got instance: " + System.identityHashCode(config));

            config.setSetting("thread." + Thread.currentThread().getId(),
                    "value_" + Thread.currentThread().getId());

            String value = config.getSetting("thread." + Thread.currentThread().getId(), "not found");
            System.out.println("Thread " + Thread.currentThread().getId() +
                    " set and read: " + value);
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("\nFinal state from main thread:");
        for (int i = 0; i < 5; i++) {
            System.out.println("thread." + i + " = " +
                    config.getSetting("thread." + i, "not found"));
        }
    }
}