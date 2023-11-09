import javax.swing.*;
import java.awt.*;

public class StartDialog extends JDialog {
    private StartPanel startPanel = new StartPanel();
    private int startNum;
    public class StartPanel extends JPanel{
        private String[] count = {"10","50","100","200"};
        private JComboBox box = new JComboBox(count);
        private JButton startBut = new JButton("Start");
        private JLabel jLabel1 = new JLabel();
        private JLabel jLabel2 = new JLabel();
        private JLabel jLabel3 = new JLabel();
        private JLabel jLabel4 = new JLabel();
        public StartPanel(){
            GridLayout gu = new GridLayout(3,2);
            setLayout(gu);
            this.add(jLabel1);
            this.add(jLabel2);
            this.add(box);
            this.add(startBut);
            this.add(jLabel3);
            this.add(jLabel4);

            startBut.addActionListener(e -> {
                String selectStr = box.getSelectedItem().toString();
                if(selectStr.equals("10")){
                    startNum =10;
                }else if(selectStr.equals("50")){
                    startNum =50;
                }else if(selectStr.equals("100")){
                    startNum =100;
                }else if(selectStr.equals("200")){
                    startNum =200;
                }
                MainFrame mainFrame = new MainFrame(startNum);
                mainFrame.setVisible(true);
                offStartDialog();
            });
        }
    }
    public StartDialog(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenWidth/4, screenHeight /4);
        setLocation(screenWidth/2 - (screenWidth/4)/2, screenHeight/2  - (screenHeight/4)/2);
        this.setTitle("원하는 숫자를 입력하시요");
        add(startPanel);
        //닫기 시 종료
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    public void offStartDialog(){
        this.dispose();
    }
}
