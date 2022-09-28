import math
def funcion_fibonacci2(n):
	a = (1+math.sqrt(5))/2
	b = (1-math.sqrt(5))/2
	result =((a**n)-(b**n))/math.sqrt(5)
	return result
