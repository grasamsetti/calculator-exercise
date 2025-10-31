package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {

    private CalculatorModel model;

    @BeforeEach
    void setUp() {
        model = new CalculatorModel();
    }

    @Test
    void testAddition() {
        model.push(3);
        model.push(4);
        double result = model.add();
        assertEquals(7.0, result);
        assertEquals("[7.0]", model.getStack().toString());
    }

    @Test
    void testDivisionByZeroThrowsException() {
        model.push(5);
        model.push(0);
        assertThrows(ArithmeticException.class, () -> model.divide());
    }

    @Test
    void testNotEnoughOperandsThrowsException() {
        model.push(5);
        assertThrows(IllegalStateException.class, () -> model.add());
    }
}