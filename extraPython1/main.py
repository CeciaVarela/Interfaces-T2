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

n1 = float(input("Intro número uno: "))
n2 = float(input("Intro numero dos: "))
suma = n1+n2
print("La suma es: ", suma)

n1 = float(input("Intro número uno: "))
n2 = float(input("Intro numero dos: "))
mult = n1*n2
print("La suma es: ", mult)

palabra =input("dime una frase : ")
txt=list(palabra)
txt.reverse()
cadena = " ".join(txt)
print ("Del revés: ",cadena)
word = input("Comprobar si es un palíndromo: ")
if str(word) == str(word)[::-1] :
    print("si es un palíndromo")
else:
    print("no es un palíndromo")

print("-----------------------------8")

def superposicion (lista1, lista2):
    for i in lista1:
        for x in lista2:
            if i == x:
                return True
    return False
print(superposicion("otro","sala"))
print("-----------------------------9")
def generar_n_caracteres(veces,letra):
	letra = letra[0]
	res = ""
	for i in range(0,veces):
		res = res+letra
	print (res)
print(generar_n_caracteres(3,"a"))
print("-----------------------------10")

def procedimiento(dato):
	dato= input("dame una palabra: ")
	longitud = len(dato)
	res = ""
	for i in range(0,longitud):
		res = res+"*"
	print (res)
print(procedimiento("*"))

