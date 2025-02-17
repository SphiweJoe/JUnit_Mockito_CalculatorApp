package com.example.junit_calcapp.service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // New method to evaluate a mathematical expression
    public double evaluateExpression(String expression) {
        try {
            Expression expr = new ExpressionBuilder(expression).build();
            return expr.evaluate();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
    }
}
