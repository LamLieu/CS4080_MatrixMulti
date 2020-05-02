import numpy as np
import time
# Program to multiply two matrices using nested loops
#Trying to get performance statistics from array multiplication of two
#randomly generated array matrices


#generate random matrix
def generateMatrix(n):
   randomMatrix = np.random.randint(1,100,size=(n,n))
   return randomMatrix


#function that has an array as a parameter
def multArray(m1,m2,n):
   col, row = n, n;
   resultMatrix = [[0 for x in range(col)] for y in range(row)] 
   # iterate through rows of X
   for i in range(len(m1)):
      # iterate through columns of Y
      for j in range(len(m2[0])):
          # iterate through rows of Y
          for k in range(len(m2)):
              resultMatrix[i][j] += m1[i][k] * m2[k][j]
   return resultMatrix

def main():
   #change this to increase or decrease matrix size
   matrixSize = 200
    
   X = generateMatrix(matrixSize)
   #print(X)
  
   Y = generateMatrix(matrixSize)
   #print(Y)
   startTimer = time.perf_counter()
   finalProduct = multArray(X,Y,matrixSize)
   endTimer = time.perf_counter()
   milliTime = (endTimer-startTimer)*1000
   print(f"multiplied the matrices in { milliTime:0.2f} milli seconds")
   #for i in finalProduct:
     # print(i)

main()
