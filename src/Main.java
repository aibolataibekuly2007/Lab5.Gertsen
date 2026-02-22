public class Main {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("MODULE 05 - DESIGN PATTERNS");
        System.out.println("Singleton | Builder | Prototype");
        System.out.println("=================================\n");

        SingletonTest.main(args);

        System.out.println("\n" + "=".repeat(50) + "\n");
        MultiThreadSingletonTest.main(args);

        System.out.println("\n" + "=".repeat(50) + "\n");
        BuilderTest.main(args);

        System.out.println("\n" + "=".repeat(50) + "\n");
        PrototypeTest.main(args);
    }
}