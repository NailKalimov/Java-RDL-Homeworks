package Singleton;

public class Sun {
    private static Sun instance;

    private Sun() {
    }

    static synchronized Sun getSun() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }

}
