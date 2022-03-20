import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Algorithm class contains simple sorting and searching algorithms
 */
public class Algorithm {

    /**
     * Output file with array of float(s)
     * @param arr: array of float(s)
     * @param fileName: name of file
     */
    public static void writeFile(float[] arr, String fileName) {
        try {
            //Declare FileWriter object with file's name
            FileWriter out = new FileWriter(fileName);

            //Declare and assign array's length to n
            int n = arr.length;
            //Loop through the array and output data to file
            for (int i = 0; i < n - 1; i++) {
                out.write(arr[i] + " ");
            }
            //Output the last float to file
            out.write(arr[n-1]+"");
            //Close file
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Output file with integer n
     * @param n: integer n
     * @param fileName: name of file
     */
    public static void writeFile(int n, String fileName) {
        try {
            //Declare FileWriter object with file's name
            FileWriter out = new FileWriter(fileName);
            //Output n to file
            out.write(n+"");
            //Close file
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Output array list of integer with file's name as "output4.txt"
     * @param arr: array list of integer
     */
    private static void writeFile(ArrayList<Integer> arr) {
        try {
            //Declare and assign FileWriter object with file's name as "output4.txt"
            FileWriter out = new FileWriter("output4.txt");
            //Declare and assign array list's length to n
            int n = arr.size();
            //Loop through the array list and output data to file
            for (int i = 0; i < n - 1; i++) {
                out.write(arr.get(i) + " ");
            }
            //Output the last integer to file
            out.write(arr.get(n-1)+"");
            //Close file
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Read data from file "input.txt" and assign float(s) to an array
     * @return array of float(s) or null
     */
    public static float[] readFile() {
        try {
            //Declare and assign Scanner object of file "input.txt"
            Scanner sc1 = new Scanner(new File("input.txt"));

            //Declare and assign counter as 0
            int counter = 0;
            while (sc1.hasNextFloat()) {
                //Raise counter by 1 whenever there is next float
                counter++;
                //Move cursor to next data
                sc1.next();
            }

            //Declare and assign Scanner object of file "input.txt"
            Scanner sc2 = new Scanner(new File("input.txt"));
            //Declare an array of float with total length as counter
            float[] arr = new float[counter];
            for(int i = 0; i < counter; i++) {
                //Assign each float to the array
                arr[i] = sc2.nextFloat();
            }
            return arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //Return null if no float found
            return null;
        }

    }


    /**
     * Print an array of float to the console
     * @param arr: an array of float
     */
    public static void printArr(float[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    /**
     * Sort an array of float with ascending order by Bubble Sort algorithm and print the array to the console for each iteration
     * @param arr: an array of float
     */
    public static void bubbleSort(float[] arr) {
        float tmp;
        //First loop for each float
        for (int i = 0; i < arr.length - 1; i++) {
			//Declare and assign flag for swapped item equals false (means no item is swapped)
			boolean swapped = false;
            //Second loop for second float
            for (int j = 0; j < arr.length - i - 1; j++) {
                //If left float is greater than right float, swap them
                if (arr[j] > arr[j + 1]) {
					//Swap the values by using value holder
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
					//If there is swapped item, change flag to true
					swapped = true;
                }
            }
            //Call printArr function to print out the array to the console
            printArr(arr);
			//Break the loop if no item is swapped after first iteration
			if(swapped == false) {
				return;
			}
        }
    }

	/**
     * Sort an array of float with ascending order by Bubble Sort algorithm
     * @param arr: an array of float
     */
	
	public static void testBubbleSort(float[] arr) {
        float tmp;
		for (int i = 0; i < arr.length - 1; i++) {
			//Declare and assign flag for swapped item equals false (means no item is swapped)
			boolean swapped = false;
            //Second loop for second float
            for (int j = 0; j < arr.length - i - 1; j++) {
                //If left float is greater than right float, swap them
                if (arr[j] > arr[j + 1]) {
					//Swap the values by using value holder
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
					//If there is swapped item, change flag to true
					swapped = true;
                }
            }
			//Break the loop if no item is swapped after first iteration
			if(swapped == false) {
				return;
			}
		}
	}

	
	/**
     * Sort an array of float with ascending order by Insertion Sort algorithm and print the array to the console for each iteration
     * @param arr: an array of float
     */
    public static void insertionSort(float[] arr) {
        //Loop for each float
        for (int i = 1; i < arr.length; i++) {
            //Declare j and assign with i < total length of the array
            int j = i - 1;
			float key = arr[i];
            //While j > 0 and left float is greater than right float, swap them
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                //Decrease j by 1
                j--;
            }
			arr[j+1] = key;
            //Call printArr function to print out the array to the console
            printArr(arr);
        }
    }


    /**
     * Sort an array of float with ascending order by Insertion Sort algorithm
     * @param arr: an array of float
     */
	public static void testInsertionSort(float[] arr) {
        //Loop for each float
        for (int i = 1; i < arr.length; i++) {
            //Declare j and assign with i < total length of the array
            int j = i - 1;
			float key = arr[i];
            //While j > 0 and left float is greater than right float, swap them
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                //Decrease j by 1
                j--;
            }
			arr[j+1] = key;
		}
    }
	

    /**
     * Sort an array of float with ascending order by Selection Sort algorithm and print the array to the console for each iteration
     * @param arr: an array of float
     */
    public static void selectionSort(float[] arr) {
        float tmp;
        //First loop for each float
        for (int i = 0; i < arr.length - 1; i++) {
            //Declare the index of minimum value, assume it as i
            int min = i;
            //Second loop for second float
            for (int j = i + 1; j < arr.length; j++) {
                //If float at index j < float at index min, reassign min with j
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //At the end of the second loop, if min is not equal i, swap float with index of min and i
            if (min != i) {
				//Swap the values by using value holder
                tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
            //Call printArr function to print out the array to the console
            printArr(arr);
        }
    }

	
	/**
     * Sort an array of float with ascending order by Selection Sort algorithm
     * @param arr: an array of float
     */
    public static void testSelectionSort(float[] arr) {
        float tmp;
        //First loop for each float
        for (int i = 0; i < arr.length - 1; i++) {
            //Declare the index of minimum value, assume it as i
            int min = i;
            //Second loop for second float
            for (int j = i + 1; j < arr.length; j++) {
                //If float at index j < float at index min, reassign min with j
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //At the end of the second loop, if min is not equal i, swap float with index of min and i
            if (min != i) {
				//Swap the values by using value holder
                tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }

	/**
     * Search an array of float(s), print all index(es) of float(s) to the console and output text file with value(s) 
	 * that is greater than given float n\
	 * @param n: a float
     * @param arr: an array of float
     */
    public static void linearSearch(float n, float[] arr) {
		//Declare an array list of integer to hold index of float that is greater than float n
        ArrayList<Integer> greaterNums = new ArrayList<>();
		//Loop through the array
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > n) {
				//Print each index of float in the array that is greater than n to the console
                System.out.print(i + " ");
				//Add index of float to the array list
                greaterNums.add(i);
            }
        }
        System.out.println();
		//Call writeFile function to output array list to text file
        writeFile(greaterNums);
    }

	/**
     * Sort a given array of float, then search for value equals float x and return its index by binary search algorithm
	 * Binary search works by repeatedly dividing in half the portion of the list that could contain the item, until you've 
	 * narrowed down the possible locations to just one
     * @param arr: an array of float
	 * @param x: a float
	 * @param min: first index of array
	 * @param max: last index of array
     */
    public static int binarySearch(float[] arr, float x, int min, int max) {
		//Call testInsertionSort function to sort the array, and print the sorted array to the console
		testInsertionSort(arr);
		//Declare and initialize middle index of the array
        int mid = (min + max)/2;
		//If first index is greater than last index, stop recursion, return -1 since no match value found
        if(max >= min) {
			//If x equals value at index mid, return mid
            if(x == arr[mid]) {
                return mid;
            }
			//If x is smaller than value at index mid, call the function again with new last index as mid - 1
            if(arr[mid] > x) {
                return binarySearch(arr, x, min, mid - 1);
            }
			//If x is greater than value at index mid, call the function again with new first index as mid + 1
            if(arr[mid] < x) {
                return binarySearch(arr, x, mid + 1, max);
            }
        }
        return -1;
    }


}
