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
