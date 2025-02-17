package com.example.junit_calcapp.controller;

import com.example.junit_calcapp.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;  // The controller to be tested

    @Mock
    private CalculatorService calculatorService;  // Mock the CalculatorService

    @Mock
    private Model model;  // Mock the Model object to verify attributes

    @BeforeEach
    public void setUp() {
        // Initialize the mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateSuccess() {
        // Arrange
        String expression = "(-2--8)*(12/4)";
        double expectedResult = 20.0;

        // When the service evaluates the expression, return the expected result
        when(calculatorService.evaluateExpression(expression)).thenReturn(expectedResult);

        // Act
        String viewName = calculatorController.calculate(expression, model);

        // Assert
        assertEquals("calculator", viewName, "The view name should be 'calculator'");
        verify(model).addAttribute("result", expectedResult);  // Verify the result is added to the model
    }

    @Test
    public void testCalculateWithError() {
        // Arrange
        String expression = "(-2--8)*(12/0)";  // This will cause an error due to division by zero

        // When the service throws an exception
        when(calculatorService.evaluateExpression(expression)).thenThrow(new ArithmeticException("Cannot divide by zero"));

        // Act
        String viewName = calculatorController.calculate(expression, model);

        // Assert
        assertEquals("calculator", viewName, "The view name should be 'calculator'");
        verify(model).addAttribute("error", "Cannot divide by zero");  // Verify the error message is added to the model
    }

    @Test
    public void testIndex() {
        // Act
        String viewName = calculatorController.index(model);

        // Assert
        assertEquals("calculator", viewName, "The index page should return 'calculator' view name");
    }
}
