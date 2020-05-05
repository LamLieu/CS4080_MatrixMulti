import numpy as np
import time
import os
import psutil
# Program to multiply two matrices using nested loops
#Trying to get performance statistics from array multiplication of two
#randomly generated array matrices


#generate random matrix
def generateMatrix(n):
   randomMatrix = np.random.randint(1,100,size=(n,n))
   return randomMatrix


#function that has an array as a parameter
def multArray(m1,m2,m3):

   # iterate through rows of m1
   for i in range(len(m1)):
      # iterate through columns of m2
      for j in range(len(m2[0])):
          # iterate through rows of m2
          for k in range(len(m2)):
              m3[i][j] += m1[i][k] * m2[k][j]
   return

def main():
	#change this to increase or decrease matrix size
	matrixSize = 100
    
	while(1):
		#matrix generation with numpy
		X = generateMatrix(matrixSize)
		Y = generateMatrix(matrixSize)
		Z = [[0 for x in range(matrixSize)] for y in range(matrixSize)] 
		#starting the timer
		startTimer = time.perf_counter()
   
		#generation of the product
		multArray(X,Y,Z)
   
		#end the timer
		endTimer = time.perf_counter()
   
		#turn seconds to milliseconds
		milliTime = (endTimer-startTimer)*1000
		print(f"multiplied the matrices of size {matrixSize} in { milliTime:0.2f} milli seconds")
		process = psutil.Process(os.getpid())
		print(process.memory_info().rss / 1024)
		matrixSize += 100
main()
