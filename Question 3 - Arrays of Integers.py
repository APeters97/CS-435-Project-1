import random;

def getRandomArray(n):
    aList = []  #create new list
    count = 0;  #used to track how many numbers are added
    while(count < n):   #while tracker does not equal n
        randNum = random.randint(0,100) #generate number
        if(randNum not in aList):   #only add to list if the number is not in there
            aList.append(randNum)
            count+=1
    return aList    #return list

print(getRandomArray(20))
    


def getSortedArray(n):
    aList = []  #created new list
    for i in range(n, 0, -1):   #traverse backwards from n to 0
        aList.append(i)     #add numbers to list
    return aList    #return list

print(getSortedArray(15))
        
