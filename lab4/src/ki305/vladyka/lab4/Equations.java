package ki305.vladyka.lab4;

/**
 * Клас {@code Equations} реалізує метод для обчислення виразу y = 2x / sin(x).
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Equations {
    /**
     * Метод обчислює значення виразу y = 2x / sin(x).
     * 
     * @param x значення кута у градусах
     * @return результат обчислення виразу
     * @throws ArithmeticException якщо sin(x) = 0
     */
    public double calculate(double x) throws ArithmeticException {
        final double EPSILON = 1e-9;
        double rad = Math.toRadians(x);
        double sin = Math.sin(rad);

        if (Math.abs(sin) < EPSILON)
            throw new ArithmeticException("Ділення на нуль (sin(x) = 0)");

        return (2 * x) / sin;
    }
}