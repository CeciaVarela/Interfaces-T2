def mayor(a,b):
    if(a > b):
        return a
    if(b > a):
        return b
print(mayor(12,6))
def max_de_tres(a,b,c):
    if((a > b) and (a > c)):
        return a
    if((b > a) and (b > c)):
        return b
    if((c > a) and (c > b)):
        return c
print(max_de_tres(16,6,2));
def longitud(cadena):
	contador = 0
	while True:
		try:
			cadena[contador]
			contador += 1
		except IndexError:
			break
	return contador
 
print(longitud("longitud de la cadena del ejercicio 3"))


def es_vocal (c):
    if c == "a" or c == "e" or c == "i" or c == "o" or c== "u":
        return True

    elif c == "A" or c == "E" or c == "I" or c == "O" or c == "U":
        return True

    return False

caracter = input("introduce una letra por favor: ")
print(es_vocal(caracter))