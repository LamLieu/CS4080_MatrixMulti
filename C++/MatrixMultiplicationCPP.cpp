#include <iostream>
#include <cstdlib>
#include <ctime>
#include <windows.h>
#include <psapi.h>
#define size 1200

using namespace std;

struct Matrix {
	int** arr = new int*[size]; 
};

void reference(struct Matrix &a, struct Matrix &b, struct Matrix &c) {
	//Performs matrix multiplication for matrix A and B
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			for (int k = 0; k < size; k++) {
				c.arr[i][j] += a.arr[i][k] * b.arr[k][j];
			}
		}
	}
}

void value(struct Matrix a, struct Matrix b, struct Matrix c) {
	//Performs matrix multiplication for matrix A and B
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			for (int k = 0; k < size; k++) {
				c.arr[i][j] += a.arr[i][k] * b.arr[k][j];
			}
		}
	}
}

int main() {

	int choice = -1;
	
	cout << "0 for value, 1 for reference: ";
	cin >> choice;
	
	struct Matrix a;
	struct Matrix b;
	struct Matrix c;
	
	for(int i = 0; i < size; i++) {
		a.arr[i] = new int[size];
		b.arr[i] = new int[size];
		c.arr[i] = new int[size];
	}
	//Ensures the randomly generated values won't be repeated
	srand(time(NULL));
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				a.arr[i][j] = rand() % 100 + 1;
				b.arr[i][j] = rand() % 100 + 1;
				c.arr[i][j] = 0;
			}
		}
	/*						
	SIZE_T memory;
	auto myHandle = GetCurrentProcess();
	PROCESS_MEMORY_COUNTERS pmc;
	if (GetProcessMemoryInfo(myHandle, &pmc, sizeof(pmc)))
		memory =  pmc.WorkingSetSize;
	else
		cout << "error";
	*/			
		//Starts a timer to measure execution time
		clock_t begin = clock();

		if(choice == 0) {
			value(a,b,c);
		}
		else {
			reference(a,b,c);
		}
		
		//Stops the timer and returns the execution time in milliseconds
		cout << endl;
		clock_t end = clock();
		double clockTicks = double(end - begin);
		double timeTaken_ms = clockTicks / (CLOCKS_PER_SEC / 1000);
		cout << "Starting " << (choice == 0 ? "value ":"reference ") << "Size : " << size << " execution Time: " << timeTaken_ms << " ms";
		cout << endl;
	/*
	myHandle = GetCurrentProcess();
	if (GetProcessMemoryInfo(myHandle, &pmc, sizeof(pmc)))
		cout << pmc.WorkingSetSize - memory;
	else
		cout << "error";
    */

}