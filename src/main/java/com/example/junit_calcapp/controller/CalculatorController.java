package com.example.junit_calcapp.controller;

import com.example.junit_calcapp.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String index(Model model) {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String expression, Model model) {
        double result = 0;
        try {
            result = calculatorService.evaluateExpression(expression);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "calculator";
    }
}
