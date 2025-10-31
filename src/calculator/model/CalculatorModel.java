package calculator.model;

import java.util.Stack;

public class CalculatorModel {
    private final Stack<Double> stack = new Stack<>();

    public void push(double value) {
        stack.push(value);
    }

    public double add() throws IllegalStateException {
        requireOperands(2);
        double b = stack.pop();
        double a = stack.pop();
        double result = a + b;
        stack.push(result);
        return result;
    }

    public double subtract() {
        requireOperands(2);
        double b = stack.pop();
        double a = stack.pop();
        double result = a - b;
        stack.push(result);
        return result;
    }

    public double multiply() {
        requireOperands(2);
        double b = stack.pop();
        double a = stack.pop();
        double result = a * b;
        stack.push(result);
        return result;
    }

    public double divide() {
        requireOperands(2);
        double b = stack.pop();
        double a = stack.pop();
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        double result = a / b;
        stack.push(result);
        return result;
    }

    public Stack<Double> getStack() {
        return stack;
    }

    private void requireOperands(int count) {
        if (stack.size() < count)
            throw new IllegalStateException("Not enough operands");
    }
}