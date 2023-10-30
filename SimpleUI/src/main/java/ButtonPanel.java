import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.beans.PropertyChangeListener;

public class ButtonPanel extends JPanel {
    public JButton myButton1;
    public JButton MyButton2;
    public ButtonPanel(){
        myButton1 = new JButton("Click me");
        myButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1 pressed");
            }

        });
        MyButton2 = new JButton("NO click me");
        MyButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 pressed");
            }
        });
        this.add(myButton1);
        setLayout(new GridLayout(1, 1));
        this.add(MyButton2);
    }
}