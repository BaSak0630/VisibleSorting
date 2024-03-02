import javax.swing.*;
import java.awt.*;

public class ArrayView extends JPanel {
    SortArray sortArray;
    int viewHeight;
    int viewWidht;
    int spaceHeight;
    int spaceWidth;

    public ArrayView(SortArray sortArray,MainFrame mainFrame){
        this.sortArray = sortArray;

        viewHeight = mainFrame.frameHeight;
        viewWidht = mainFrame.frameWidth;
        spaceHeight = (viewHeight /sortArray.startNum);
        spaceWidth = (viewWidht/sortArray.startNum);
        mainFrame.setSize(mainFrame.frameWidth,mainFrame.frameHeight+28);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintView(g);
    }

    public void paintView(Graphics g) {
        repaint();
        g.setColor(Color.black);
        for(int i = 0; i < sortArray.startNum; i++){
            g.fillRect((spaceWidth*i),
                    ((viewHeight) -(spaceHeight)*sortArray.intArr[i]),
                    spaceWidth ,
                    (int) (spaceHeight*sortArray.intArr[i]));
        }
        repaint();
    }
}