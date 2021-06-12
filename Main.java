package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        //prompts user for input
        System.out.println("Please enter your string: ");

        //accepts input and calls the validate method
        String lispCode = myScan.nextLine();
        boolean isValid = validate(lispCode);

        //Outputs to user whether their input was valid
        if(isValid){
            System.out.println("All parenthesis were properly open and closed");
        } else System.out.println("Invalid use of parenthesis");

    }

    static boolean validate(String lispCode){

        Stack<Character> parenStack = new Stack<>();

        //runs through the string, adding opening parenthesis to the stack
        //and popping them off when a closing parenthesis is encountered
        //if a closing parenthesis is encountered without an opening on it just returns false
        for(int i = 0; i < lispCode.length(); i++){
            if(lispCode.charAt(i) == '('){
                parenStack.push(lispCode.charAt(i));
            } else if( lispCode.charAt(i) == ')' && parenStack.isEmpty()){
                return false;
            } else if(lispCode.charAt(i) == ')'){
                parenStack.pop();
            }
        }

        //checks if stacks is empty, returns true if it is
        //which means all parenthesis that were opened were properly closed
        return(parenStack.isEmpty());


    }
}
