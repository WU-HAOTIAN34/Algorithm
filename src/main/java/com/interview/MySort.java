package com.interview;

import java.io.*;
import java.util.Arrays;

public class MySort {



    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l>=r) return;
        int p = arr[l];
        int i = l;
        int j = r;
        while (i<j){
            while (i<j && arr[j]>=p) j--;
            while (i<j && arr[i]<=p) i++;

            if (i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[l] = arr[i];
        arr[i] = p;
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }


    public static void mergeSort(int[] arr, int l, int r){
        if (l>=r) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r){
        int p1 = l;
        int p2 = m+1;
        int p = 0;

        int[] tmp = new int[r-l+1];
        while (p1<=m && p2<=r){
            tmp[p++]  = arr[p1]<arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1<=m) tmp[p++] = arr[p1++];
        while (p2<=r) tmp[p++] = arr[p2++];

        System.arraycopy(tmp, 0, arr, l, tmp.length);
    }


    public static void bubbleSort(int[] arr) {

        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-1; j++){
                if (arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
    }



    public static void selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++){
            int p = 0;
            for (int j=0; j<arr.length-i; j++){
                p = arr[i]>arr[p] ? i:p;
            }
            int tmp = arr[p];
            arr[p] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }
    }


    // 3. 插入排序
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 4. 希尔排序
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }



    // 7. 堆排序
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 逐个取出堆顶元素
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    private static void heapify(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 工具方法：交换
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}
