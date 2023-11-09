import javax.swing.*;
import java.awt.*;

public class ArrayView extends JPanel {
    SortArray sortArray;
    JComponent viewComponent;
    int viewHeight;
    int viewWidht;
    double spaceHeight;
    double spaceWidth;

    public ArrayView(SortArray sortArray){
        viewComponent = new JPanel();
        add(viewComponent);
        this.sortArray = sortArray;

        viewHeight = 500;
        viewWidht = 1000;
        this.setSize(viewWidht,viewHeight);

        spaceHeight = ((double) viewHeight /(double) sortArray.startNum);
        System.out.println("sh = " + spaceHeight);
        spaceWidth = ((double)viewWidht/(double) sortArray.startNum);
        System.out.println("sw = " + spaceWidth);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(0,0,1000,500);
        g.setColor(Color.black);
        for(int i = 0; i < sortArray.startNum; i++){
            g.fillRect((int) (spaceWidth*i), (int) ((viewHeight) -((spaceHeight)*sortArray.intArr[i])), (int) spaceWidth, (int) (spaceHeight*sortArray.intArr[i]));
        }
    }
}