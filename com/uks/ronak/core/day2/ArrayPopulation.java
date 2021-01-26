package com.uks.ronak.core.day2;

class PopulateArray {
    int[] arr1 = new int[5];
    int[] arr2 = new int[5];
    int length = arr1.length + arr2.length;
    int[] result = new int[length];

    public void print() {
        for (int i = 0; i < length; i++) {
            // printing resultant array
            System.out.print(result[i] + " ");
        }
    }
    public void populateArray(int[] arr1, int[] arr2) {

        for (int i = 0, even = 0, odd = 0; i < length; i++) {
            if (i % 2 == 0) {
                //arr1 will set even indexes
                result[i] = arr1[even];
                even++;
            } else {
                // arr2 will set odd indexes
                result[i] = arr2[odd];
                odd++;
            }
        }
        // printing array
        //System.out.println(Arrays.toString(result));
    }
}

public class ArrayPopulation {
    public static void main(String[] args) {
        PopulateArray populateArray = new PopulateArray();
        populateArray.populateArray(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10});
        populateArray.print();
    }
}