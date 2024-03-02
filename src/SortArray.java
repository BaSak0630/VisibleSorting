import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class SortArray {
    int startNum;
    int[] intArr;
    int[] sorted;
    MainFrame mainFrame;
    SortArray(int num,MainFrame mainFrame){
        startNum = num;
        this.mainFrame = mainFrame;
        intArr = new int[startNum];
        for(int i = 0; i < startNum; i++) {
            intArr[i] = i + 1;
        }
    }

    public void shuffleArray(){
        Random rand = new Random();

        for (int i = 0; i < intArr.length; i++) {
            int randomIndexToSwap = rand.nextInt(intArr.length);
            int temp = intArr[randomIndexToSwap];
            intArr[randomIndexToSwap] = intArr[i];
            intArr[i] = temp;
        }

    }
   
    public void swap(int i, int j) {
        int temp = intArr[i];
        intArr[i] = intArr[j];
        intArr[j] = temp;
        try {
            mainFrame.view.paintComponent(mainFrame.view.getGraphics());
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.toString();
        }
    }
    public void bubbleSorting(){
        System.out.println("버블");
        for(int i = 1; i < intArr.length; i++) {
            // 각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교함
            for(int j = 0; j < intArr.length - i; j++) {
                if(intArr[j] > intArr [j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
    public void selectionSorting() {
        for(int i = 0; i < intArr.length - 1; i++) {
            int minIndex = i;

            for(int j = i + 1; j < intArr.length ; j++) {
                if(intArr[j] < intArr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(minIndex, i);
        }
    }

    public void insertionSorting() {
        for(int i = 1; i < intArr.length; i++) {
        int target = intArr[i];

        int j = i - 1;

        while(j >= 0 && target < intArr[j]) {
            swap(j + 1,j);
            j--;
        }
            intArr[j + 1] = target;
        }
    }

    public void quickSorting() {
        m_pivot_sort(intArr,0,intArr.length-1);
    }
    private void m_pivot_sort(int[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        m_pivot_sort(a, lo, pivot);
        m_pivot_sort(a, pivot + 1, hi);
    }
    private int partition(int[] a, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];


        while(true) {

            do {
                lo++;
            } while(a[lo] < pivot);

            do {
                hi--;
            } while(a[hi] > pivot && lo <= hi);

            if(lo >= hi) {
                return hi;
            }


            swap( lo, hi);
        }
    }

    public void mergeSorting() {
        sorted = new int[intArr.length];
        merge_sort(intArr, 0, intArr.length - 1);
        sorted = null;
    }
    private void merge_sort(int[] a, int left, int right) {

        if(left == right) return;

        int mid = (left + right) / 2;

        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);

        merge(a, left, mid, right);

    }
    private void merge(int[] a, int left, int mid, int right){
        int l = left;
        int r = mid + 1;
        int idx = left;


        while(l <= mid && r <= right) {

            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        else {
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for(int i = left; i <= right; i++) {
            a[i] = sorted[i];
            try {
                mainFrame.view.paintComponent(mainFrame.view.getGraphics());
                Thread.sleep(200);
            } catch (Exception e) {
                e.toString();
            }

        }
    }

    public void heapSorting() {
        if(intArr.length < 2) {
            return;
        }

        int parentIdx = getParent(intArr.length - 1);

        // max heap
        for(int i = parentIdx; i >= 0; i--) {
            heapify(intArr, i, intArr.length - 1);

        }
        try {
            System.out.println("max heap");
            Thread.sleep(5000);
        } catch (Exception e) {

        }

        for(int i = intArr.length  - 1; i > 0; i--) {

            swap(0, i);
            heapify(intArr, 0, i - 1);
        }

    }
    private int getParent(int child) {
        return (child - 1) / 2;
    }
    private void heapify(int[] a, int parentIdx, int lastIdx) {
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;
        int largestIdx = parentIdx;

        if(leftChildIdx <= lastIdx && a[largestIdx] < a[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }
        if(rightChildIdx <= lastIdx && a[largestIdx] < a[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }
        if(parentIdx != largestIdx) {
            swap(largestIdx, parentIdx);
            heapify(a, largestIdx, lastIdx);
        }
    }
}
