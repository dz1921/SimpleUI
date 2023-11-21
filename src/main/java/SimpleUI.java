import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GraphicsConfiguration;
public class SimpleUI {
    static GraphicsConfiguration gc;	// Contains this computer’s graphics configuration
    public static void main(String[] args) {
        JFrame frame= new JFrame(gc);// Create a new JFrame
        frame.setSize(1000,1000);
        Point point= new Point(300, 300);
        Color col=new Color(45,87,34);
        Drawing drawing = new Drawing(100, point, col);
        MainMenu mainMenu = new MainMenu();

        JPanel mainPanel = new JPanel();
        JPanel drawingPanel=new JPanel();
        JPanel buttonPanel=new JPanel();
        JPanel sliderPanel = new JPanel();

        JSlider redSlider = new JSlider(0, 255);
        JSlider blueSlider = new JSlider(0, 255);
        JSlider greenSlider = new JSlider(0, 255);
        JSlider lengthSlider = new JSlider(0, 20);

        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(new GridLayout(2, 2));

        mainPanel.add(drawingPanel);
        drawingPanel.add(drawing);
        drawing.setSize(500, 500);
        drawing.setBackground(Color.WHITE);

        mainPanel.add(buttonPanel);
        buttonPanel.add(new ButtonPanel());

        mainPanel.add(sliderPanel);
        sliderPanel.add(redSlider);
        sliderPanel.add(greenSlider);
        sliderPanel.add(blueSlider);
        sliderPanel.add(lengthSlider);

        String[] shapeOptions = {"Circle", "Square", "Rectangle"};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapeOptions);
        mainPanel.add(shapeComboBox);

        ChangeListener Listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                int green = greenSlider.getValue();
                int blue = blueSlider.getValue();
                int length = lengthSlider.getValue();

                Color selectedColor = new Color(red, green, blue);
                drawing.selectedColor = selectedColor;
                drawing.selectedLength = length;

                // Update a preview panel or do something with the selectedColor
            }
        };
        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
                String selectedShape = (String) comboBox.getSelectedItem();
                drawing.selectedShape = selectedShape;
            }
        });

        redSlider.addChangeListener(Listener);
        greenSlider.addChangeListener(Listener);
        blueSlider.addChangeListener(Listener);
        lengthSlider.addChangeListener(Listener);

        frame.setJMenuBar(mainMenu);

        //frame.getContentPane().add(new ButtonPanel());
        frame.setVisible(true);
        // This next line closes the program when the frame is closed
        frame.addWindowListener(new WindowAdapter() {	// Closes the program if close window clicked
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

    }

}
