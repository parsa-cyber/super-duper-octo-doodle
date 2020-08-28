text = int (input ("enter how much numbers you want: \t"))
numbers_of_texts = text

if numbers_of_texts == (2):

    num1=int (input ("enter the first number: \t"))
    num2=int (input ("enter the second number: \t"))

    numbers_min=min (num1, num2)

    while (1):
        if numbers_min % num1 == 0 and numbers_min % num2 == 0:
            print ("lcm of two  numbers  is", numbers_min)
            break
        numbers_min+=1


#2
#2
#3



if numbers_of_texts == 3:
    num1=int (input ("enter the first number: \t"))
    num2=int (input ("enter the second number:\t"))
    num3=int (input ("enter the third number: \t"))
    numbers_min2=min(num1, num2,num3)

    while (2):
        if numbers_min2 % num1 == 0 and numbers_min2 % num2 == 0 and numbers_min2 % num3 == 0:
            print ("lcm of three numbers  is", numbers_min2)
            break
        numbers_min2 +=1


