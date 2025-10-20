package ki305.vladyka.lab3;

/**
 * Клас TruckBuilder реалізує шаблон Builder
 * для зручного поетапного створення вантажівки.
 */
public class TruckBuilder {
    private Engine engine;
    private Doors doors;
    private Lights lights;
    private int capacity = 3000;

    // === ENGINE ===

    /** Використати двигун за замовчуванням (100 к.с.). */
    public TruckBuilder withDefaultEngine() {
        this.engine = new Engine();
        return this;
    }

    /**
     * Використати двигун із власною потужністю.
     * @param horsepower Потужність (к.с.)
     */
    public TruckBuilder withCustomEngine(int horsepower) {
        this.engine = new Engine(horsepower);
        return this;
    }

    // === DOORS ===

    /** Використати двері за замовчуванням (2 двері). */
    public TruckBuilder withDefaultDoors() {
        this.doors = new Doors();
        return this;
    }

    /**
     * Використати двері із заданою кількістю.
     * @param count Кількість дверей
     */
    public TruckBuilder withCustomDoors(int count) {
        this.doors = new Doors(count);
        return this;
    }

    // === LIGHTS ===

    /** Використати фари за замовчуванням ("Галогенні"). */
    public TruckBuilder withDefaultLights() {
        this.lights = new Lights();
        return this;
    }

    /**
     * Використати фари із заданим типом.
     * @param type Тип фар (наприклад, LED)
     */
    public TruckBuilder withCustomLights(String type) {
        this.lights = new Lights(type);
        return this;
    }

    // === CAPACITY ===

    /**
     * Встановити максимальну вантажопідйомність.
     * @param capacity Вантажопідйомність у кг
     */
    public TruckBuilder withCapacity(int capacity) {
        if (capacity > 0) this.capacity = capacity;
        return this;
    }

    // === BUILD ===

    /**
     * Створює об’єкт вантажівки з усіма заданими параметрами.
     * Якщо якийсь параметр не вказано — встановлюються дефолтні значення.
     * @return Готовий об’єкт {@link Truck}
     */
    public Truck build() {
        if (engine == null) engine = new Engine();
        if (doors == null) doors = new Doors();
        if (lights == null) lights = new Lights();
        return new Truck(engine, doors, lights, capacity);
    }
}
