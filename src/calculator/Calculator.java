package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {
        new Calculator().display();
    }
    Stack<Double> stack = new Stack<>();
    StringBuilder currentInput = new StringBuilder();


    private void display() {
        JFrame frame = new JFrame("Reverse Polish Calculator");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        JTextField currentResult = new JTextField(10);
        for (int i = 0; i<10; i++){
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentInput.append(button.getText());
                    textField.setText(String.valueOf(currentInput));
                }
            });
            panel.add(button);
        }
        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a+b;
                    stack.push(result);
                    currentResult.setText(String.valueOf(result));
                    textField.setText(String.valueOf(stack));
                }
                else {
                    textField.setText("not enough operands");
                }
            }
        });
        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a-b;
                    stack.push(result);
                    currentResult.setText(String.valueOf(result));
                    textField.setText(String.valueOf(stack));
                }
                else {
                    textField.setText("not enough operands");
                }
            }
        });
        JButton asterisk = new JButton("*");
        asterisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a*b;
                    stack.push(result);
                    currentResult.setText(String.valueOf(result));
                    textField.setText(String.valueOf(stack));
                }
                else {
                    textField.setText("not enough operands");
                }
            }
        });
        JButton slash = new JButton("/");
        slash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a/b;
                    stack.push(result);
                    currentResult.setText(String.valueOf(result));
                    textField.setText(String.valueOf(stack));
                }
                else {
                    textField.setText("not enough operands");
                }
            }
        });
        JButton enter = new JButton("Enter");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(currentInput.toString());
                stack.push(value);
                currentInput.setLength(0);
                textField.setText(String.valueOf(stack));
            }
        });

        panel.add(plus);
        panel.add(minus);
        panel.add(asterisk);
        panel.add(slash);
        panel.add(enter);
        panel.add(textField);
        panel.add(currentResult);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}
