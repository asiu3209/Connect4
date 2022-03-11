import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Gui extends JFrame implements ActionListener{
    private ArrayList<Integer> row2; //keeping track of where circles go

    private int col; int row; int turn;
    private ArrayList<Integer> placingPoint;
    private JButton[][] buttons; // all my buttons
    private JPanel panel; //The grid being opened, variable panel
    public Gui(){
        Color red = new Color(255,0,0);
        Color yellow = new Color(255,255,0);
        placingPoint = new ArrayList<>();
        row = 5;
        col = 7;
        placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6); placingPoint.add(6);
        panel = new JPanel(new GridLayout(6,7));
        row2 = new ArrayList<Integer>();
        row2.add(5);
        row2.add(5);
        row2.add(5);
        row2.add(5);
        row2.add(5);
        row2.add(5);
        row2.add(5);
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
                        buttons[row2.get(j)][j].setFont(new Font("Ink Free", Font.BOLD, 100)); //set button to player 1
                        buttons[row2.get(j)][j].setForeground(Color.RED);
                        buttons[row2.get(j)][j].setText("O");
                        turn = 2;
                        row2.set(j,row2.get(j)-1);
                        winnings();
                    }
                    else{
                        buttons[row2.get(j)][j].setFont(new Font("Ink Free", Font.BOLD, 100)); //set button to player 2
                        buttons[row2.get(j)][j].setForeground(Color.yellow);
                        buttons[row2.get(j)][j].setText("O");
                        turn = 1;
                        row2.set(j,row2.get(j)-1);
                        winnings();
                    }
                }
            }
        }
   }
    //for each row
    //for each 4 in the row
    //check if symbol is all equal
    //if yes return true
    //
   public boolean winnings(){
        for (int i = 0;i<row+1;i++){ //checks each row for win
                for (int k = 0;k<4;k++){
                    if (buttons[i][k].getForeground().equals(Color.red) && buttons[i][k+1].getForeground().equals(Color.red) && buttons[i][k+2].getForeground().equals(Color.red) && buttons[i][k+3].getForeground().equals(Color.red)){
                        return true;
                    }
                    if (buttons[i][k].getForeground().equals(Color.yellow) && buttons[i][k+1].getForeground().equals(Color.yellow) && buttons[i][k+2].getForeground().equals(Color.yellow) && buttons[i][k+3].getForeground().equals(Color.yellow)){
                        return true;
                    }
                }
        }
        //for each column
       //check if 4 in a row
       for (int i = 0;i<col;i++){ //checks each column for a win
           for (int k = 0;k<3;k++){
               if (buttons[k][i].getForeground().equals(Color.red) && buttons[k+1][i].getForeground().equals(Color.red) && buttons[k+2][i].getForeground().equals(Color.red) && buttons[k+3][i].getForeground().equals(Color.red)){
                   return true;
               }
               if (buttons[k][i].getForeground().equals(Color.yellow) && buttons[k+1][i].getForeground().equals(Color.yellow) && buttons[k+2][i].getForeground().equals(Color.yellow) && buttons[k+3][i].getForeground().equals(Color.yellow)){
                   return true;
               }
}
       }
        return false;
   }
}
