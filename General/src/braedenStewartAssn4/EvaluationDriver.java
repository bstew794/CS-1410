package braedenStewartAssn4;

/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author Braeden Stewart <bstewart794@gmail.com>
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {
        demoLinearSearchUnsorted();
        demoLinearSearchSorted();
        demoBinarySearchSelectionSort();
        demoBinarySearchFastSort();
    }
    /**
     * Demonstrates linear searching over an unsorted array
     *
     * @author
     */
    public static void demoLinearSearchUnsorted() {
        System.out.println("--- wLinear Search Timing (unsorted) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i+= ARRAY_INCREMENT){
            int lengthOfArray = i;
            int randomArray[] = generateNumbers(lengthOfArray, MAX_VALUE);
            int numOfOccurrences = 0;
            double startTime = System.currentTimeMillis();
            for (int j = 0; j <= NUMBER_SEARCHES; j++){
                int randomValue = (int)(Math.random() * MAX_VALUE);
                if (linearSearch(randomArray, randomValue)){
                    numOfOccurrences += 1;
                }
            }
            double endTime = System.currentTimeMillis();
            int timeItTook = (int)(endTime - startTime);
            printStanza(lengthOfArray, numOfOccurrences, timeItTook);
        }
    }
    /**
     * Demonstrates linear searching over a sorted array
     *
     * @author
     */
    public static void demoLinearSearchSorted() {
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i+= ARRAY_INCREMENT){
            int lengthOfArray = i;
            int randomArray [] = generateNumbers(lengthOfArray, MAX_VALUE);
            int nubOfOccurrences = 0;
            double startTime = System.currentTimeMillis();
            selectionSort(randomArray);
            for (int j = 0; j <= NUMBER_SEARCHES; j++){
                int randomValue = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(randomArray, randomValue)){
                    nubOfOccurrences += 1;
                }
            }
            double endTime = System.currentTimeMillis();
            int timeItTook = (int)(endTime - startTime);
            printStanza(lengthOfArray, nubOfOccurrences, timeItTook);
        }

    }
    /**
     * Demonstrates binary searching when using a Selection Sort
     *
     * @author
     */
    public static void demoBinarySearchSelectionSort() {
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i+= ARRAY_INCREMENT){
            int lengthOfArray = i;
            int randomArray [] = generateNumbers(lengthOfArray, MAX_VALUE);
            int nubOfOccurrences = 0;
            double startTime = System.currentTimeMillis();
            selectionSort(randomArray);
            for (int j = 0; j <= NUMBER_SEARCHES; j++){
                int randomValue = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(randomArray, 0, lengthOfArray, randomValue)){
                    nubOfOccurrences += 1;
                }
            }
            double endTime = System.currentTimeMillis();
            int timeItTook = (int)(endTime - startTime);
            printStanza(lengthOfArray, nubOfOccurrences, timeItTook);
        }
    }
    /**
     * Demonstrates binary searching when using the build in Arrays.sort
     *
     * @author
     */
    public static void demoBinarySearchFastSort() {
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i+= ARRAY_INCREMENT){
            int lengthOfArray = i;
            int randomArray [] = generateNumbers(lengthOfArray, MAX_VALUE);
            int nubOfOccurrences = 0;
            double startTime = System.currentTimeMillis();
            java.util.Arrays.sort(randomArray);
            for (int j = 0; j <= NUMBER_SEARCHES; j++){
                int randomValue = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(randomArray, 0, lengthOfArray, randomValue)){
                    nubOfOccurrences += 1;
                }
            }
            double endTime = System.currentTimeMillis();
            int timeItTook = (int)(endTime - startTime);
            printStanza(lengthOfArray, nubOfOccurrences, timeItTook);
        }

    }
    /** function to run a binary search on a given array*/

    public static boolean binarySearch (int array[], int begin, int end, int key) {
        while(begin < end) {
            int middle = (begin + end) / 2;

            if (array[middle] == key) {
                return true;
            }
            else if (array[middle] > key) {
                end = middle - 1;
            }
            else {
                begin = middle + 1;
            }
        }
        return false;
    }
    /** function to do linear search*/
    public static boolean linearSearch (int array[], int key){
        for (int i = 0; i < array.length; i ++){
            if (array[i] == key){
                return true;
            }
        }
        return false;
    }
    /** function to generate an array filled with random numbers*/
    public static int[] generateNumbers (int howMany, int maxValue){
        if (howMany > MAX_ARRAY_SIZE){
            return null;
        }
        int count = 0;
        int array[] = new int[howMany];
        for (int i = 0; i < howMany; i++){
            array[i] = (int)(Math.random() * maxValue);
            count ++;
        }
        if (count >= howMany) {
            return array;
        }
        else{
            return null;
        }
    }
    /**function to do a selection sort on a given array.*/
    public static void selectionSort(int array[]){
        for(int i = 0; i < array.length; i++){
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;
                }
            }int smallestNum =  array[index];
            array[index] = array[i];
            array[i] = smallestNum;
        }
    }
    /** prints each paragraph to display information after each 20,000 iteration*/
    public static void printStanza (int numOfItems, int numOfFindings, int timerResult){
        System.out.println("Number of items       : " + numOfItems);
        System.out.println("Times value was found : " + numOfFindings);
        System.out.println("Total search time     : " + timerResult + " ms");
        System.out.println();
    }
}