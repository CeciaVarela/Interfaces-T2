import random
orden = [0,1,2,3,4,5]

puntuacion = 0
veces = 0
while True: 
	comienza = random.randint(0,len(orden))
	if veces ==2:
		break 
	elif orden[comienza] == 0: 
		orden.pop(0)
		veces = veces + 1
		print("Cuanto es 2 x 3?")
		print("a-2")
		print("b-6")
		print("c-12")
		resultado = input ("Teclea a,b o c")
		if resultado == "a":
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
		elif resultado == "b" :
			print("Respuesta correcta")
			puntuacion = puntuacion + 10
			print("Llevas " + str(puntuacion))
		else:
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
	elif orden[comienza] == 1:
		orden.pop(1)
		veces = veces + 1
		print("Cuanto es 5 x 3?")
		print("a-15")
		print("b-12")
		print("c-4")
		resultado = input ("Teclea a,b o c")
		if resultado == "b":
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
		elif resultado == "a" :
			print("Respuesta correcta")
			puntuacion = puntuacion + 10
			print("Llevas " + str(puntuacion))
		else:
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
	elif orden[comienza] == 2:
		orden.pop(2)
		veces = veces + 1
		print("Cuanto es 5 x 6?")
		print("a-25")
		print("b-12")
		print("c-30")
		resultado = input ("Teclea a,b o c")
		if resultado == "b":
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
		elif resultado == "c" :
			print("Respuesta correcta")
			puntuacion = puntuacion + 10
			print("Llevas " + str(puntuacion))
		else:
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
	elif orden[comienza] == 3:
		orden.pop(3)
		veces = veces + 1
		print("Cuanto es 9 x 10?")
		print("a-80")
		print("b-88")
		print("c-90")
		resultado = input ("Teclea a,b o c")
		if resultado == "b":
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
		elif resultado == "c" :
			print("Respuesta correcta")
			puntuacion = puntuacion + 10
			print("Llevas " + str(puntuacion))
		else:
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
	elif orden[comienza] == 4:
		orden.pop(4)
		veces = veces + 1
		print("Cuanto es 8 x 4?")
		print("a-32")
		print("b-27")
		print("c-30")
		resultado = input ("Teclea a,b o c")
		if resultado == "b":
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
		elif resultado == "a" :
			print("Respuesta correcta")
			puntuacion = puntuacion + 10
			print("Llevas " + str(puntuacion))
		else:
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
	elif orden[comienza] == 5:
		orden.pop(5)
		veces = veces + 1
		print("Cuanto es 3 x 7?")
		print("a-28")
		print("b-21")
		print("c-14")
		resultado = input ("Teclea a,b o c")
		if resultado == "a":
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))
		elif resultado == "b" :
			print("Respuesta correcta")
			puntuacion = puntuacion + 10
			print("Llevas " + str(puntuacion))
		else:
			print("Respuesta incorrecta")
			puntuacion = puntuacion - 5
			print("Llevas " + str(puntuacion))

