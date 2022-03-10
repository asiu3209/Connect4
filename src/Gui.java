import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Gui extends JFrame implements ActionListener{
    private int row; int col;
    private ArrayList<Integer> placingPoint;
    private JButton[][] buttons; // all my buttons
    private JPanel panel; //The grid being opened, variable panel
    private int turn; //which player's turn    Red will always be first, followed by yellow
    public Gui(){
        placingPoint = new ArrayList<>();
        placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6);
        panel = new JPanel(new GridLayout(6,7));
        row = 6;
        col = 7;
        buttons = new JButton[6][7];
        for (int i = 0;i < buttons.length;i++){
            for (int j = 0;j<buttons[0].length;j++){ //2D array of buttons
                buttons[i][j] = new JButton();
            }
        }
        for (int i = 0;i < buttons.length;i++){
            for (int j = 0;j<buttons[0].length;j++){
                panel.add(buttons[i][j]);
            }
        }
        add(panel);
        setTitle("CONNECT 4");
        ActionListener(); // using method to add actionListeners
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when clicking "X";\
        turn = 1;
//        ImageIcon icon = new ImageIcon("download.jpg");
//        setIconImage(icon.getImage());
    }

private void ActionListener(){ //Adds actionListeners for each button
        for (int i = 0;i<row;i++){
            for (int j = 0; j<col;j++){
                buttons[i][j].addActionListener(this);
            }
        }
}
public void actionPerformed(ActionEvent e){ //The action performed when the button with listener is clicked
        for (int i = 0;i < row;i++){
            for (int j = 0;j<col;j++){
                if (e.getSource() == buttons[i][j]){ //runs through all buttons to find the one clicked
                    if (turn == 1) {
                        buttons[i][j].setFont(new Font("Ink Free", Font.BOLD, 100)); //set button to player 1
                        buttons[i][j].setForeground(new Color(255, 0, 0));
                        buttons[i][j].setText("O");
                        turn = 2;
                    }
                    else{
                        buttons[i][j].setFont(new Font("Ink Free", Font.BOLD, 100)); //set button to player 2
                        buttons[i][j].setForeground(new Color(255, 255, 0));
                        buttons[i][j].setText("O");
                        turn = 1;
                    }
                }
            }
        }
}
}
