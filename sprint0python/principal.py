from fibonacci import funcion_fibonacci
from fibonacci2 import funcion_fibonacci2
import time
print("Elige una opcion:")
print("a- funcion_fibonacci")
print("b- funcion_fibonacci2")
resultado = input ("Teclea a o b:  ")
if resultado == "a":
	n=int(input("Enter the value of 'n': "))
	print("Fibonacci Sequence:")
	start_time = time.time()
	print(funcion_fibonacci(n))
	end_time = time.time()
	elapsed_time = end_time - start_time
	print('El tiempo de ejecución ha sido :' + str(elapsed_time) + ' s')
	
	
elif resultado == "b":
	n2=int(input("Enter the value of 'n': "))
	print("Fibonacci Sequence:")
	start_time = time.time()
	print(funcion_fibonacci2(n2))
	end_time = time.time()
	elapsed_time = end_time - start_time
	print('El tiempo de ejecución ha sido :' + str(elapsed_time) + ' s')

