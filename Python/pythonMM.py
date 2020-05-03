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
   # iterate through rows of m1
   for i in range(len(m1)):
      # iterate through columns of m2
      for j in range(len(m2[0])):
          # iterate through rows of m2
          for k in range(len(m2)):
              resultMatrix[i][j] += m1[i][k] * m2[k][j]
   return resultMatrix

def main():
   #change this to increase or decrease matrix size
   matrixSize = 200
    
   #matrix generation with numpy
   X = generateMatrix(matrixSize)
   Y = generateMatrix(matrixSize)

   #starting the timer
   startTimer = time.perf_counter()
   
   #generation of the product
   finalProduct = multArray(X,Y,matrixSize)
   
   #end the timer
   endTimer = time.perf_counter()
   
   #turn seconds to milliseconds
   milliTime = (endTimer-startTimer)*1000
   print(f"multiplied the matrices in { milliTime:0.2f} milli seconds")
 
main()
