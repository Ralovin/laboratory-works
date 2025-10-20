package ki305.vladyka.lab2;

/**
 * Клас Engine представляє двигун автомобіля.
 */
class Engine {
    private boolean isRunning;

    private Engine() {}

    static Engine of() {
        return new Engine();
    }

    void start() { isRunning = true; }
    void stop() { isRunning = false; }
    boolean isRunning() { return isRunning; }
}
