def funcion_fibonacci(Number):
    if(Number==0):
        return 0
    elif(Number==1):
        return 1
    else:
        return (funcion_fibonacci(Number-2)+funcion_fibonacci(Number-1)) #return the sum of two prevous terms
n=int(input("Enter the value of 'n': "))
print("Fibonacci Sequence:")
for n in range(0, n):
  print(funcion_fibonacci(n))
