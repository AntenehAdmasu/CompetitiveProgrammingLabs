

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int answer = getResult();

        System.out.println("Result " + answer);
    }

    public static int getResult(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the operation you want to perform (use spaces): ");
        String input = scanner.nextLine();
        Stack operandStack = new Stack();

        String[] inputsArray = input.split(" ");

        int answer = 0;
        for (int i = inputsArray.length - 1; i >= 0 ; i--) {
            if(inputsArray[i].equals("+") || inputsArray[i].equals("-") || inputsArray[i].equals("*") || inputsArray[i].equals("/")  ){
                switch (inputsArray[i]){
                    case ("+"):
                        answer = Integer.parseInt(operandStack.pop()) + Integer.parseInt(operandStack.pop());
                        operandStack.push(answer + "");
                        break;
                    case ("-"):
                        answer = Integer.parseInt(operandStack.pop()) - Integer.parseInt(operandStack.pop());
                        operandStack.push(answer + "");
                        break;
                    case ("*"):
                        answer = Integer.parseInt(operandStack.pop()) * Integer.parseInt(operandStack.pop());
                        operandStack.push(answer + "");
                        break;
                    case ("/"):
                        answer = Integer.parseInt(operandStack.pop()) / Integer.parseInt(operandStack.pop());
                        operandStack.push(answer + "");
                        break;
                }
            }else {
                operandStack.push(inputsArray[i]);
            }
        }

        return answer;
    }

}
