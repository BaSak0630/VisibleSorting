import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OperationDialog extends JDialog {
    private MainFrame mainFrame;
    private OperationPanel operationPanel;

    public OperationDialog(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenWidth/5, screenHeight /8);
        setLocation(0, screenHeight/2  - (screenHeight/8)/2);
        operationPanel = new OperationPanel(mainFrame);
        this.setResizable(false);
        setTitle("OperationDialog");
        add(operationPanel);

        //닫기 시 종료
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                mainFrame.closeMainFrame();
            }
        });
    }

    public class OperationPanel extends JPanel{
        int width = this.getWidth();
        int height = this.getHeight();
        JButton startBut = new JButton("Start");
        JButton shuffleBut = new JButton("shuffle");
        JButton backBut = new JButton("back");
        String[] sortList = {"Bubble Sort","Selection Sort","Insertion Sort","Quick Sort","Merge Sort","Heap Sort"};
        JComboBox sortListBox = new JComboBox(sortList);
        OperationPanel(MainFrame mainFrame){
            sortListBox.setBounds(width/2 -((width/2)/2) ,height/2 + ((height/2)/2),width/2,height/2);
            add(sortListBox);
            startBut.setSize(width/3,height/3);
            add(startBut);
            shuffleBut.setSize(width/3,height/3);
            add(shuffleBut);
            backBut.setSize(width/3,height/3);
            add(backBut);

            /*셔플 버튼*/
            shuffleBut.addActionListener(e -> {
                mainFrame._sortArray.shuffleArray();
                //mainFrame.view.paintComponent(mainFrame.getGraphics());
                mainFrame.view.repaint();
            });
            /*시작 버튼*/
            startBut.addActionListener(e -> {
                String selectStr = sortListBox.getSelectedItem().toString();

                if(selectStr.equals("Bubble Sort")){
                    visivbleFalse();
                    mainFrame.view.sortArray.bubbleSorting();
                    visivbleTrue();
                } else if(selectStr.equals("Selection Sort")){
                    visivbleFalse();
                    mainFrame.view.sortArray.selectionSorting();
                    visivbleTrue();
                } else if(selectStr.equals("Insertion Sort")){
                    visivbleFalse();
                    mainFrame.view.sortArray.insertionSorting();
                    visivbleTrue();
                } else if(selectStr.equals("Quick Sort")){
                    visivbleFalse();
                    mainFrame.view.sortArray.quickSorting();
                    visivbleTrue();
                } else if(selectStr.equals("Merge Sort")){
                    visivbleFalse();
                    mainFrame.view.sortArray.mergeSorting();
                    visivbleTrue();
                } else if(selectStr.equals("Heap Sort")){
                    visivbleFalse();
                    mainFrame.view.sortArray.heapSorting();
                    visivbleTrue();
                }

            });
            backBut.addActionListener(e -> {
                StartDialog startDialog = new StartDialog();
                startDialog.setVisible(true);
                mainFrame.closeMainFrame();
                closeOperationDialog();

            });
        }
    }

    public void visivbleFalse(){
        this.setVisible(false);
    }
    public void visivbleTrue(){
        this.setVisible(true);
    }
    public void closeOperationDialog(){
        this.dispose();
    }
}
