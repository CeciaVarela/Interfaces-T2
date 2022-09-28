def funcion_fibonacci(Number):
    if(Number==0):
        return 0
    elif(Number==1):
        return 1
    else:
        return (funcion_fibonacci(Number-2)+funcion_fibonacci(Number-1))

