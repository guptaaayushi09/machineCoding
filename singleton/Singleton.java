public class Singleton {
    // Private constructor to prevent instantiation
    private Singleton() {}

    // Inner static class responsible for holding Singleton instance
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public method to access the Singleton instance
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Singleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
