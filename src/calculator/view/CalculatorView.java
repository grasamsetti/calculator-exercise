package calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private final JFrame frame = new JFrame("Reverse Polish Calculator");
    private final JTextField textField = new JTextField(20);
    private final JTextField currentResult = new JTextField(10);
    private final JButton[] numberButtons = new JButton[10];
    private final JButton plus = new JButton("+");
    private final JButton minus = new JButton("-");
    private final JButton multiply = new JButton("*");
    private final JButton divide = new JButton("/");
    private final JButton enter = new JButton("Enter");
    private final JPanel panel = new JPanel();

    public CalculatorView() {
        frame.setSize(400, 300);
        panel.setLayout(new FlowLayout());

        // Add number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            panel.add(numberButtons[i]);
        }

        // Add operation buttons
        panel.add(plus);
        panel.add(minus);
        panel.add(multiply);
        panel.add(divide);
        panel.add(enter);

        // Add display fields
        panel.add(textField);
        panel.add(currentResult);

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // --- UI interaction methods ---
    public void updateStackDisplay(String text) {
        textField.setText(text);
    }

    public void updateResultDisplay(String result) {
        currentResult.setText(result);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // --- Getters for buttons ---
    public JButton[] getNumberButtons() { return numberButtons; }
    public JButton getPlusButton() { return plus; }
    public JButton getMinusButton() { return minus; }
    public JButton getMultiplyButton() { return multiply; }
    public JButton getDivideButton() { return divide; }
    public JButton getEnterButton() { return enter; }

    // Method to attach listeners
    public void addActionListener(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }
}