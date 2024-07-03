package com.dhakad.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,3,8,1,2,7,4};
        sort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end){
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++){
            left[i] = arr[start + i];
        }
        for (int j = 0; j < n2; j++){
            right[j] = arr[mid + 1 + j];
        }

        int i =0, j = 0, k = start;

        while (i < n1 && j < n2){
            if (left[i] < right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while (i < n1){
            arr[k++] = left[i++];
        }
        while (j < n2){
            arr[k++] = right[j++];
        }

    }
}
