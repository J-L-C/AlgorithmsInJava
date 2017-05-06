package com.company;

import java.util.Random;

public class Main {

    int[] mArray = new int[10];
    static final int range = 10;

    public void generateRandomData(){

        Random n = new Random();

        for(int i =0; i < mArray.length;i++){

            mArray[i]=n.nextInt(range);

        }

    }
    Main(){
        generateRandomData();

    }

    void printArray(){

        System.out.println("           ARRAY         ");
        for(int i =0; i< mArray.length;i++)
            System.out.println("Value: "+mArray[i]+" at "+i);



    }

    public int getValueAtIndex(int index){
        if(index < mArray.length)
            return mArray[index];
        else
            return -1;



    }

    public boolean containValueinArray(int searchValue){

        boolean found = false;

        for(int i = 0; i<mArray.length;i++){
            if(mArray[i]==searchValue)
                found = true;

        }

        return found;

    }
    public void deleteIndex(int index){

        if(index<mArray.length){

            for(int i = index; i < mArray.length-1; i++){
                mArray[i]=mArray[i+1];
            }
            insertValue(mArray.length-1,-1);

        }


    }
    public void insertValue(int index, int value){

        if(index<=mArray.length-1){
            mArray[index]=value;

        }

    }
    public String linearSearch(int value){
        boolean valueInArray = false;
        String foundAtIndex ="";


        for(int i = 0; i < mArray.length-1;i++){
            if(mArray[i]==value){
                foundAtIndex += " "+Integer.toString(i);
                valueInArray = true;
            }
        }
        if(valueInArray == true)
            System.out.println("The value was found in the following: "+foundAtIndex);
        if(valueInArray == false)
            return "Value not found";

        return foundAtIndex;

    }
    public void bubbleSortStoL(){

        for(int i =mArray.length-1; i>0;i--){
            for(int j = 0; j < i; j++){
                if(mArray[j]>mArray[j+1]){
                    swapVal(j,j+1);
                }
            }

        }

    }
    public void bubbleSortLtoS(){

        for(int i =mArray.length-1; i>0;i--){
            for(int j = 0; j < i; j++){
                if(mArray[j]<mArray[j+1]){
                    swapVal(j,j+1);
                }
            }

        }

    }
    public void swapVal(int cIndex, int nIndex){
        int temp = mArray[cIndex];
        mArray[cIndex]=mArray[nIndex];
        mArray[nIndex]=temp;

    }

    public void binarySearch(int value){
        int lowIndex =0;
        int highIndex = mArray.length-1;

        while(lowIndex<=highIndex){

            int mid = (lowIndex+highIndex)/2;

            //System.out.println(mid+" ::: "+mArray[mid]);

            if(mArray[mid]<value){

                lowIndex = mid +1;
            }
            else if(mArray[mid]>value){
                highIndex = mid -1;

            }
            else{
                System.out.println("Value Found at: "+mid);
                lowIndex = highIndex+1;
            }

        }


    }

    public void selectionSort(){

        for(int x = 0; x < mArray.length; x++){
            int min = x;
            for(int y = x; y < mArray.length; y++){
                if(mArray[min] > mArray[y])
                    min = y;
            }
            swapVal(x,min);
        }

    }

    public void insertionSort(){

        for(int i = 1; i < mArray.length; i++){
            int j = i;
            int toInsert = mArray[i];

            while((j>0) && (mArray[j-1]>toInsert)){

                mArray[j] = mArray[j-1];
                j--;
                //printArray();
            }

            mArray[j] = toInsert;
        }
    }
    public static void main(String[] args) {

        Main test = new Main();
        test.printArray();
        System.out.println(test.getValueAtIndex(5));
        System.out.println(test.containValueinArray(10));
       // test.deleteIndex(10);
        test.printArray();
        test.insertValue(47,1000);
        test.insertValue(10,1000);
        test.insertValue(1,1000);
        test.printArray();
        test.linearSearch(10);
        test.linearSearch(1000);
        //test.bubbleSortStoL();
        test.printArray();
        //test.bubbleSortLtoS();
        //test.printArray();
        test.binarySearch(1000);
        test.binarySearch(0);
        test.binarySearch(5);
        //test.generateRandomData();
        //test.printArray();
        //test.selectionSort();
        test.printArray();
        test.insertionSort();
        test.printArray();







    }
}
