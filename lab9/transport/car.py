# transport/car.py
# Базовий клас Машина

class Car:
    def __init__(self, brand=None, model=None, year=None, vin=None):
        self.brand = brand              # публічне поле
        self.model = model
        self.year = year
        self.__vin = vin                # приватне поле
        self._speed = 0                 # захищене поле

    def start(self):
        print(f"{self.brand} {self.model} завелася.")

    def stop(self):
        self._speed = 0
        print(f"{self.brand} {self.model} зупинилася.")

    def accelerate(self, value):
        self._speed += value
        print(f"Швидкість збільшена до {self._speed} км/год.")

    def brake(self, value):
        self._speed = max(0, self._speed - value)
        print(f"Швидкість зменшена до {self._speed} км/год.")

    def get_speed(self):
        return self._speed
