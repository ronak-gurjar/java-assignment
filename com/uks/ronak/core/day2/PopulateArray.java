package com.uks.ronak.core.day2;

class PopulateArray {
    // resultant array
    int[] result = new int[10];

    public void populateArray(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;

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
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            // printing resultant array
            System.out.print(result[i] + " ");
        }
    }
}
