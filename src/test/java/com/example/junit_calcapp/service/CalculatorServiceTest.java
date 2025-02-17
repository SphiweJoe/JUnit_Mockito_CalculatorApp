package com.example.junit_calcapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        // Initialize the calculator service before each test
        calculatorService = new CalculatorService();
    }

    // Test the 'add' method
    @Test
    public void testAdd() {
        double result = calculatorService.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    // Test the 'subtract' method
    @Test
    public void testSubtract() {
        double result = calculatorService.subtract(5, 3);
        assertEquals(2, result, "5 - 3 should equal 2");
    }

    // Test the 'multiply' method
    @Test
    public void testMultiply() {
        double result = calculatorService.multiply(5, 3);
        assertEquals(15, result, "5 * 3 should equal 15");
    }

    // Test the 'divide' method
    @Test
    public void testDivide() {
        double result = calculatorService.divide(6, 3);
        assertEquals(2, result, "6 / 3 should equal 2");
    }

    // Test division by zero
    @Test
    public void testDivideByZero() {
        // Assert that an exception is thrown when dividing by zero
        assertThrows(ArithmeticException.class, () -> calculatorService.divide(5, 0), "Cannot divide by zero");
    }

    // Test the 'evaluateExpression' method with a valid expression
    @Test
    public void testEvaluateExpressionValid() {
        double result = calculatorService.evaluateExpression("(-2--8)*(12/4)");
        assertEquals(20, result, "Expression (-2--8)*(12/4) should equal 20");
    }

    // Test the 'evaluateExpression' method with an invalid expression
    @Test
    public void testEvaluateExpressionInvalid() {
        // Assert that an IllegalArgumentException is thrown for an invalid expression
        assertThrows(IllegalArgumentException.class, () -> calculatorService.evaluateExpression("5 /"), "Invalid expression should throw an exception");
    }
}
