package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

import javax.swing.*;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;
    private final StringBuilder currentInput = new StringBuilder();

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        // Number buttons
        for (JButton button : view.getNumberButtons()) {
            button.addActionListener(e -> {
                currentInput.append(button.getText());
                view.updateStackDisplay(currentInput.toString());
            });
        }

        // Enter
        view.getEnterButton().addActionListener(e -> {
            try {
                double value = Double.parseDouble(currentInput.toString());
                model.push(value);
                currentInput.setLength(0);
                view.updateStackDisplay(model.getStack().toString());
            } catch (NumberFormatException ex) {
                view.showError("Invalid number input");
            }
        });

        // Operators
        view.getPlusButton().addActionListener(e -> performOperation("add"));
        view.getMinusButton().addActionListener(e -> performOperation("subtract"));
        view.getMultiplyButton().addActionListener(e -> performOperation("multiply"));
        view.getDivideButton().addActionListener(e -> performOperation("divide"));
    }

    private void performOperation(String op) {
        try {
            double result;
            switch (op) {
                case "add" -> result = model.add();
                case "subtract" -> result = model.subtract();
                case "multiply" -> result = model.multiply();
                case "divide" -> result = model.divide();
                default -> throw new IllegalArgumentException("Unknown operation");
            }
            view.updateResultDisplay(String.valueOf(result));
            view.updateStackDisplay(model.getStack().toString());
        } catch (Exception ex) {
            view.showError(ex.getMessage());
        }
    }
}