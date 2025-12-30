
import struct
import sys
import math

def calculate(x):
    if math.sin(x) == 0:
        raise ValueError("Ділення на нуль: sin(x) не може бути нулем.")
    return 2 * x / math.sin(x)

def write_result_txt(filename, result):
    with open(filename, 'w', encoding='utf-8') as f:
        f.write(str(result))

def read_result_txt(filename):
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            return float(f.read())
    except FileNotFoundError:
        print(f"Файл {filename} не знайдено.")
        return None

def write_result_bin(filename, result):
    with open(filename, 'wb') as f:
        f.write(struct.pack('f', result))

def read_result_bin(filename):
    try:
        with open(filename, 'rb') as f:
            return struct.unpack('f', f.read())[0]
    except FileNotFoundError:
        print(f"Файл {filename} не знайдено.")
        return None

if __name__ == "__main__":
    try:
        x = float(input("Введіть значення x: "))
        y = calculate(x)
        print(f"Результат: y = {y}")

        write_result_txt("result.txt", y)
        write_result_bin("result.bin", y)

        print("Прочитано з текстового файлу:", read_result_txt("result.txt"))
        print("Прочитано з двійкового файлу:", read_result_bin("result.bin"))

    except ValueError as e:
        print("Помилка обчислення:", e)
    except Exception as e:
        print("Невідома помилка:", e)
        sys.exit(1)
