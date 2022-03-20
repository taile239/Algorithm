import java.util.Random;
import java.util.Scanner;

/**
 * The program get user's choice to execute below function
 *
 * 1/Get number of elements & each element then output text file with name "input.txt"
 * 2/Get array of floats from "input.txt" file then print out to the console
 * 3/Get array of floats from "input.txt" file, sort the array by Bubble Sort Algorithm then print out to the console
 * 4/Get array of floats from "input.txt" file, sort the array by Selection Sort Algorithm then print out to the console
 * 5/Get array of floats from "input.txt" file, sort the array by Insertion Sort Algorithm then print out to the console
 * 6/Get array of floats from "input.txt" file, search for floats which is greater than user input value, print out the index(es) of float(s) to the console and "output4.txt" file
 * 7/Get array of floats from "input.txt" file, search for first matched float with user input, print out index of float to the console and "output5.txt" file
 */
public class Main {
    public static void main(String[] args) {
        //Declare user choice for chosen function
        int choice;
        //Declare and initialize scanner object
        Scanner sc = new Scanner(System.in);

        //Loop to show all program's functions to the console, stop when choice equals 0
        while (true) {
            System.out.println("+-------------------Menu------------------+");
            System.out.println("|      1.Input                            |");
            System.out.println("|      2.Output                           |");
            System.out.println("|      3.Bubble sort                      |");
            System.out.println("|      4.Selection sort                   |");
            System.out.println("|      5.Insertion sort                   |");
            System.out.println("|      6.Search > value                   |");
            System.out.println("|      7.Search = value                   |");
            System.out.println("|      8.Algorithms speed test            |");
            System.out.println("|      0.Exit                             |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Choice: ");
            //Get user input for choice
            choice = getInt(sc);
            //Terminate the program once choice equals 0
            if (choice == 0) {
                System.out.println("Many thanks!!");
                break;
            }

            //Execute function base on user's choice
            switch (choice) {
                //Function 1: get number of elements & each element then output text file with name "input.txt"
                case 1 -> {
                    System.out.print("Input number of elements: ");
                    //Declare and assign user input for number of elements
                    int n = getInt(sc);
                    System.out.print("Input elements: ");
                    //Declare and assign user input for array of elements
                    float[] arr = getFloatArr(sc, n);
                    //Call writeFile function of Algorithm class to output text file with name "input.txt"
                    Algorithm.writeFile(arr, "input.txt");
                }
                //Function 2: get array of floats from "input.txt" file then print out to the console
                case 2 -> {
                    System.out.println("Read from file");
                    //Declare and assign array of floats from "input.txt" text file
                    float[] arr = Algorithm.readFile();
                    //Call printArr function of Algorithm class to print array out to the console
                    Algorithm.printArr(arr);
                }

                //Function 3: get array of floats from "input.txt" file, sort the array by Bubble Sort Algorithm then print out to the console
                case 3 -> {
                    System.out.println("Bubble sort");
                    //Declare and assign array of floats from "input.txt" text file
                    float[] arr = Algorithm.readFile();
                    //Call bubbleSort function of Algorithm class to sort the array
                    Algorithm.bubbleSort(arr);
                    //Call writeFile function of Algorithm class to output text file with name "output1.txt"
                    Algorithm.writeFile(arr, "output1.txt");
                }

                //Function 4: get array of floats from "input.txt" file, sort the array by Selection Sort Algorithm then print out to the console
                case 4 -> {
                    System.out.println("Selection sort");
                    //Declare and assign array of floats from "input.txt" text file
                    float[] arr = Algorithm.readFile();
                    //Call selectionSort function of Algorithm class to sort the array
                    Algorithm.selectionSort(arr);
                    //Call writeFile function of Algorithm class to output text file with name "output2.txt"
                    Algorithm.writeFile(arr, "output2.txt");
                }

                //Function 5: get array of floats from "input.txt" file, sort the array by Insertion Sort Algorithm then print out to the console
                case 5 -> {
                    System.out.println("Insertion sort");
                    //Declare and assign array of floats from "input.txt" text file
                    float[] arr = Algorithm.readFile();
                    //Call insertionSort function of Algorithm class to sort the array
                    Algorithm.insertionSort(arr);
                    //Call writeFile function of Algorithm class to output text file with name "output3.txt"
                    Algorithm.writeFile(arr, "output3.txt");
                }

                //Function 6: get array of floats from "input.txt" file, search for floats which is greater than user input value, print out the index(es) of float(s) to the console and "output4.txt" file
                case 6 -> {
                    System.out.println("Linear Search");
                    //Declare and assign array of floats from "input.txt" text file
                    float[] arr = Algorithm.readFile();
                    System.out.print("Input value: ");
                    //Declare and assign user input for to be searched value
                    float val = getFloat(sc);
                    System.out.print("Index(es) with greater value: ");
                    //Call linearSearch function of Algorithm class to search
                    Algorithm.linearSearch(val, arr);
                }

                //Function 7: get array of floats from "input.txt" file, search for first matched float with user input, print out index of float to the console and "output5.txt" file
                case 7 -> {
                    System.out.println("Binary Search");
                    //Declare and assign array of floats from "input.txt" text file
                    float[] arr = Algorithm.readFile();
                    System.out.print("Input value: ");
                    //Declare and assign user input for to be searched value
                    float val = getFloat(sc);
                    //Call testInsertionSort function of Algorithm class to sort the array
                    Algorithm.testInsertionSort(arr);
                    System.out.print("Sorted array: ");
                    //Call printArr function to print out sorted array to the console
                    Algorithm.printArr(arr);
                    //Declare and assign answer by calling binarySearch function of Algorithm class
                    int ans = Algorithm.binarySearch(arr, val, 0, arr.length - 1);
                    //If answer equals -1, no matched value found, print result out to the console. Otherwise, print matched value's index to the console
                    if (ans == -1) {
                        System.out.println("Index of first match element: None");
                    } else {
                        System.out.println("Index of first match element: " + ans);
                    }
                    //Call writeFile function of Algorithm class to output text file with name "output5.txt"
                    Algorithm.writeFile(ans, "output5.txt");
                }
				
				//Function 8: to test bubble/insertion/selection sort algorithm to sort an array with worst/best/average case array and print out result to the console
                case 8 -> {
                    System.out.println("----------------------------------Algorithms speed test----------------------------------");
                    System.out.println("Test 1: Array is sorted but in reversed order (worst case)");
					//Declare and initialize array for worst case scenario
                    float[] arr1 = getSortedArrReverse(50000);
                    float[] arr2 = getSortedArrReverse(50000);
                    float[] arr3 = getSortedArrReverse(50000);
					//Call testModule function 3 times to test each sorting algorithm
					testModule(arr1, "Bubble", "(worst case)");
					testModule(arr2, "Insertion", "(worst case)");
					testModule(arr3, "Selection", "(worst case)");
					
					System.out.println("-----------------------------------------------------------------------------------------");
					System.out.println("Test 2: Array is sorted (best case)");
					//Declare and initialize array for best case scenario
                    float[] arr4 = getSortedArr(50000);
                    float[] arr5 = getSortedArr(50000);
                    float[] arr6 = getSortedArr(50000);

                    //Call testModule function 3 times to test each sorting algorithm
					testModule(arr4, "Bubble", "(best case)");
					testModule(arr5, "Insertion", "(best case)");
					testModule(arr6, "Selection", "(best case)");
					
					System.out.println("-----------------------------------------------------------------------------------------");
					System.out.println("Test 3: Array is not sorted (average case)");
					//Declare and initialize array for average case scenario
					float[] arr7 = getRandomArr(50000);
                    float[] arr8 = getRandomArr(50000);
                    float[] arr9 = getRandomArr(50000);

                    //Call testModule function 3 times to test each sorting algorithm
					testModule(arr7, "Bubble", "(average case)");
					testModule(arr8, "Insertion", "(average case)");
					testModule(arr9, "Selection", "(average case)");
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
            }
        }
    }




    /**
     * To test bubble/insertion/selection sort algorithm to sort an array
     *
     * @param arr: an array of float
	 * @param algoName: name of algorithm
	 * @param caseName: name of testing case
     */
	public static void testModule(float[] arr, String algoName, String caseName) {
		System.out.println("**" + algoName + " sort**");
		//Get current time in millisecond (before calling algorithm's function
		long start = System.currentTimeMillis();
		switch(algoName) {
			case "Bubble" -> {
				//Call the bubble sort algorithm's function to sort the array
				Algorithm.testBubbleSort(arr);
			}
			case "Insertion" -> {
				//Call the insertion sort algorithm's function to sort the array
				Algorithm.testInsertionSort(arr);
			}
			case "Selection" -> {
				//Call the selection sort algorithm's function to sort the array
				Algorithm.testSelectionSort(arr);
			}
		}
		//Get current time in millisecond (after calling algorithm's function
		long end = System.currentTimeMillis();
		//Print out result to the console
		System.out.println(algoName + " sort " + caseName + " time: " + (end - start) + "ms");
	}

    /**
     * Get user's input for integer variable
     *
     * @param sc: Scanner object
     * @return user's input(integer)
     * @throws NumberFormatException: if user's input is not an integer
     */
    public static int getInt(Scanner sc) {
        //Declare and initialize user's input as zero
        int answer = 0;
        try {
            //Get user's input and assign it to answer
            answer = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return answer;
    }

    /**
     * Get user's input for float variable
     *
     * @param sc: Scanner object
     * @return user's input(float)
     * @throws NumberFormatException: if user's input is not a float
     */
    public static float getFloat(Scanner sc) {
        //Declare and initialize user's input as zero
        float answer = 0;
        try {
            //Get user's input and assign it to answer
            answer = Float.parseFloat(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return answer;
    }

    /**
     * Get user's input for array of float(s)
     *
     * @param sc: Scanner object
     * @param n: total length of the array
     * @return an array of float(s)
     */
    public static float[] getFloatArr(Scanner sc, int n) {
        //Declare an array of float(s) with total length as n
        float[] ans = new float[n];
        for (int i = 0; i < n; i++) {
            //Call getFloat function to assign user input for float
            ans[i] = getFloat(sc);
        }
        return ans;
    }
	
	/**
     * Generate a sorted array of n float(s) with ascending order
     *
     * @param n: total length of the array
     * @return an array of float(s)
     */
	public static float[] getSortedArr(int n) {
		float[] result = new float[n];
		for(int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}
	
	/**
     * Generate a sorted array of n float(s) with descending order
     *
     * @param n: total length of the array
     * @return an array of float(s)
     */
	public static float[] getSortedArrReverse(int n) {
		float[] result = new float[n];
        int index = 0;
		for(int i = n - 1; i >= 0; i--) {
			result[index] = i;
            index++;
		}
		return result;
	}
	
	
	/**
     * Generate a random array of n float(s)
     *
     * @param n: total length of the array
     * @return an array of float(s)
     */
	public static float[] getRandomArr(int n) {
		float[] result = new float[n];
		for(int i = 0; i < n; i++) {
			Random rand = new Random();
			result[i] = rand.nextInt(n);
		}
		return result;
	}
}
