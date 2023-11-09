import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class SortArray {
    int startNum;
    int[] intArr;
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
        System.out.println(Arrays.toString(intArr));
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
    public void selectionSorting(){
        System.out.println("버블");
    }
    public void swap(int i, int j) {
        int temp = intArr[i];
        intArr[i] = intArr[j];
        intArr[j] = temp;
        try {
            Thread.sleep(100);
            mainFrame.view.paintComponent(mainFrame.getGraphics());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
