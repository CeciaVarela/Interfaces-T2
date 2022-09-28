from fibonacci import funcion_fibonacci
from fibonacci2 import funcion_fibonacci2
print("Elige una opcion:")
print("a- funcion_fibonacci")
print("b- funcion_fibonacci2")
resultado = input ("Teclea a o b:  ")
if resultado == "a":
	n=int(input("Enter the value of 'n': "))
	print("Fibonacci Sequence:")
	for n in range(0, n):
		print(funcion_fibonacci(n))
elif resultado == "b":
	n2=int(input("Enter the value of 'n': "))
	for n2 in range(0, 	n2):
		print (funcion_fibonacci2(n2))

