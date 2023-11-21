import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MainMenu is a JMenuBar that also implements the ActionListener interface by
// having a concrete actionPerformed method
public class MainMenu extends JMenuBar implements ActionListener {
    JMenu menu;         // One menu
    JMenuItem item;     // Which has one item
    public MainMenu(){  // MainMenu constructor
        menu=new JMenu("Actions");
        item=new JMenuItem("Clear all");
        // This MainMenu object is also acting as the ActionListener object
        item.addActionListener(this);
        add(menu);                          // Add the JMenu to the JMenuBar
        menu.add(item);                     // Add the JMenuItem to the JMenu
    }

    // If 'this' is set as the ActionListener to all menu items as above, the method
    // below will be called whenever ANY menu item is selected, but the ActionEvent’s
    // ’command’ will be the text of the menu item selected
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
