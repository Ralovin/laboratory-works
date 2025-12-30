try:
    number = int(input("Enter a number: "))
except ValueError:
    print("Error: Invalid number")
    exit()

sym = input("Enter a character: ")

if len(sym) != 1:
    print("Error: Invalid character")
    exit()

figure = []


for i in range((number + 1) // 2):
    row = [sym] * (number - 2 * i)
    figure.append(row)


for i in range((number - 1) // 2 - 1, -1, -1):
    row = [sym] * (number - 2 * i)
    figure.append(row)

try:
    with open("MyFile.txt", "w") as fout:
        for i, row in enumerate(figure):

            if i < (number + 1) // 2:
                offset = i
            else:
                offset = (number - 1) - i

           
            line = " " * offset + "".join(row)

           
            print(line)
            fout.write(line + "\n")

    print("The result has been saved to a file")

except IOError:
    print("Error: Failed to create the file")
