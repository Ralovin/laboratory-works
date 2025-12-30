# transport/truck.py
# Похідний клас Вантажна машина

from transport.car import Car   

class Truck(Car):
    def __init__(self, brand=None, model=None, year=None, vin=None, capacity=None):
        # Викликаємо конструктор базового класу
        super().__init__(brand, model, year, vin)

        # Нові властивості вантажівки
        self.capacity = capacity      # вантажопідйомність (кг)
        self.cargo_weight = 0         # поточна вага вантажу

    def load(self, weight):
        """Завантаження вантажу."""
        if self.cargo_weight + weight > self.capacity:
            print("Помилка: перевищення вантажопідйомності!")
        else:
            self.cargo_weight += weight
            print(f"Завантажено {weight} кг. Поточний вантаж: {self.cargo_weight} кг.")

    def unload(self, weight):
        """Вивантаження вантажу."""
        if weight > self.cargo_weight:
            print("Помилка: немає стільки вантажу!")
        else:
            self.cargo_weight -= weight
            print(f"Вивантажено {weight} кг. Залишилось: {self.cargo_weight} кг.")

    def get_cargo(self):
        """Поточна вага вантажу."""
        return self.cargo_weight
