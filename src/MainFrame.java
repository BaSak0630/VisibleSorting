import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public ArrayView view;
    private OperationDialog operationDialog;
    static SortArray _sortArray;
    int frameWidth;
    int frameHeight;


    public MainFrame(int startNum){
        _sortArray = new SortArray(startNum,this);
        setResizable(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        
        frameWidth = 800;
        frameHeight =  450;
        setSize(frameWidth,frameHeight);
        setLocation(screenWidth/2 - frameWidth/2, screenHeight/2 - frameHeight/2);
        view = new ArrayView(_sortArray,this);

        Container container = this.getContentPane();
        container.add(view);

        operationDialog = new OperationDialog(this);
        operationDialog.setVisible(true);


        //닫기 시 종료
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                operationDialog.closeOperationDialog();
            }
        });
    }
    public void closeMainFrame(){
        this.dispose();
    }
}
