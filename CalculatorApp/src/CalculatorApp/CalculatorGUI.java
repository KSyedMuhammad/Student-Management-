package CalculatorApp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField textField;
    private double num1, num2, result;
    private String operator = "";
    Calculation calc = new Calculation();

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Buttons
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "√","^","C","CE"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        try {
            if (input.matches("\\d") || input.equals(".")) {
                textField.setText(textField.getText() + input);
            }
            else if (input.equals("C")) {
                textField.setText("");
                operator = "";
            }
            else if (input.equals("CE")) {
                textField.setText("");
            }
            else if (input.equals("√")) {
                num1 = Double.parseDouble(textField.getText());
                result = calc.squareRoot(num1);
                textField.setText(String.valueOf(result));
            }
            else if (input.equals("^")) {
                num1 = Double.parseDouble(textField.getText());
                operator = "^";
                textField.setText("");
            }
            else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                num1 = Double.parseDouble(textField.getText());
                operator = input;
                textField.setText("");
            }
            else if (input.equals("=")) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+": result = calc.add(num1, num2); break;
                    case "-": result = calc.subtract(num1, num2); break;
                    case "*": result = calc.multiply(num1, num2); break;
                    case "/": result = calc.divide(num1, num2); break;
                    case "^": result = calc.power(num1, num2); break;
                }

                textField.setText(String.valueOf(result));
            }
        } catch (Exception ex) {
            textField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
