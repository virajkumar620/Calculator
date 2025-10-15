import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    // The display screen of the calculator
    private JTextField display;

    // The buttons for numbers and operations
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;

    // Panel to hold the buttons
    private JPanel panel;

    // Font for the display and buttons
    private Font myFont = new Font("Arial", Font.BOLD, 24);

    // Variables to store numbers and operator for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        // --- Frame Setup ---
        setTitle("Swing Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null); // Center the window

        // --- Display Field Setup ---
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setFont(myFont);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display);

        // --- Button Initialization ---
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // --- Buttons on Frame ---
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        add(delButton);
        add(clrButton);

        // --- Panel for Number and Operator Buttons ---
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel in order
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the calculator
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        // Handle decimal point
        if (e.getSource() == decButton) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText().concat("."));
            }
        }

        // Handle operator clicks
        if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton || e.getSource() == divButton) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = e.getActionCommand().charAt(0);
                display.setText("");
            }
        }

        // Handle equals button click
        if (e.getSource() == equButton) {
            if (!display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            display.setText("Error");
                            return; // Exit the method to prevent further calculation
                        }
                        result = num1 / num2;
                        break;
                }

                // Display result, avoiding ".0" for whole numbers
                if (result == (long) result) {
                    display.setText(String.format("%d", (long) result));
                } else {
                    display.setText(String.valueOf(result));
                }
                num1 = result; // The result becomes the first number for the next operation
            }
        }

        // Handle clear button
        if (e.getSource() == clrButton) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = '\0';
        }

        // Handle delete button
        if (e.getSource() == delButton) {
            String string = display.getText();
            if (!string.isEmpty()) {
                display.setText(string.substring(0, string.length() - 1));
            }
        }
    }
}