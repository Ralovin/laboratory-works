# main.py
# Точка входу в програму

from transport.truck import Truck   # імпорт похідного класу

if __name__ == "__main__":
    # Створюємо вантажівку
    truck = Truck("Volvo", "FH16", 2018, "VIN123456", 25000)

    # Тестуємо методи, успадковані від Car
    truck.start()
    truck.accelerate(40)
    truck.brake(10)
    truck.stop()

    # Робота з вантажем
    truck.load(5000)
    truck.load(21000)  # пробуємо перевантажити
    truck.unload(2000)

    # Вивід поточного вантажу
    print(f"Зараз у вантажівці: {truck.get_cargo()} кг.")
