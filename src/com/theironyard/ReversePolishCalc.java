package com.theironyard;

import java.util.Stack;

/**
 * Created by Vijee on 7/20/17.
 */

public class ReversePolishCalc {
    private String[] tokens;
    double result;
    double number1;
    double number2;

    public double calculate(String input) {

        Stack<String> stack =new Stack<String>(); // Creating an instance of stack

        tokens = input.split(","); // Split the input string with comma

        for (String token : tokens) {

            if(isNumeric( token )){  //if numeric push the number to stack
                stack.push(token);
            }
            else{
                 number1 = Double.valueOf(stack.pop()); // number 1
                 number2 = Double.valueOf(stack.pop()); // number 2

                switch (token) {  // +,-,*,/
                    case "+":
                        stack.push(String.valueOf(number1 + number2));
                        break;
                    case "-":
                        stack.push(String.valueOf(number2 - number1));
                        break;
                    case "*":
                        stack.push(String.valueOf(number1 * number2));
                        break;
                    case "/":
                        stack.push(String.valueOf(number2 / number1));
                        break;
                }
            }
        }
        return Double.valueOf(stack.pop()); //Convert to double and pop out the result
    }


 public static boolean isNumeric(String str) //Method to check if the input string is numeric
    {
        try{
            double strDouble;
            strDouble = Double.parseDouble(str);
        }
        catch(NumberFormatException e){ // catch the number format error
            return false;
        }
        return true;
    }
}
