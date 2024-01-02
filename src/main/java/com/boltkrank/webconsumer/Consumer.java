package com.boltkrank.webconsumer;

import java.util.Random;

public class Consumer {
    
    private String iterations;
    private String level;
    private boolean running;

    public Consumer(){
        this.running = false;
    }

    public String getIterations(){
        return iterations;
    }

    public void setIterations(String iterations){
        this.iterations = iterations;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    public boolean getRunning(){
        return running;
    }

    /**
     * 
     */
    public void runConsumption(){

        setRunning(true);
        System.out.println("Running");
        System.out.println("Test getIterations(): " + getIterations());

        //int tmp_iter = Integer.getInteger(getIterations());  Integer.getInteger(getIterations()) is returning null
        int tmp_iter = 88;

        //Create Array and fill will random values
        
        int[] numberList = new int[tmp_iter];
        
        //Create random number generator.
        Random ran = new Random();

        for(int i=0; i<numberList.length; i++){
            numberList[i] = ran.nextInt(1000);
        }

        if (getLevel().equals("low")){

            System.out.println("Array before insertion sort:");
            for(int i=0; i<numberList.length;i++){
                System.out.println(" "+numberList[i]+" ");
            }
            numberList = insertionSort(numberList);
            
            System.out.println("Array after insertion sort:");
            for(int i=0; i<numberList.length;i++){
                System.out.println(" "+numberList[i]+" ");
            }

        }
        else if (getLevel().equals("medium")){

            
            System.out.println("Array before bubble sort:");
            for(int i=0; i<numberList.length;i++){
                System.out.println(" "+numberList[i]+" ");
            }
            numberList = bubbleSort(numberList);

            System.out.println("Array after bubble sort:");
            for(int i=0; i<numberList.length;i++){
                System.out.println(" "+numberList[i]+" ");
            }


        }
        else {

            System.out.println("Array before selection sort:");
            for(int i=0; i<numberList.length;i++){
                System.out.println(" "+numberList[i]+" ");
            }
                        
            numberList = selectionSort(numberList);

            
            System.out.println("Array after selection sort:");
            for(int i=0; i<numberList.length;i++){
                System.out.println(" "+numberList[i]+" ");
            }

        }

        System.out.println("Iterations: " + tmp_iter + "\nLevel: " + getLevel());

        setRunning(false);
        System.out.println("Finished Running");

    }

    int[] insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    int[] bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (arr[j] > arr[j + 1]) { 
                    // swap temp and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                } 

        return arr;
    } 
    
    int[] selectionSort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

}
