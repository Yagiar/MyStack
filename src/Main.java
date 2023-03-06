import Structs.MyStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(Integer.class, 20);
        try {
            /*
            for (int i = 0; i < 19; i++) {
                myStack.push(i);
            }
            myStack.info();
            System.out.println("Stack is empty? ~" + myStack.empty());
            System.out.println(myStack.peek());
            myStack.info();
            int helper = (int)myStack.pop();
            System.out.println("helper = " + helper);
            myStack.info();
            System.out.println("search = " + myStack.search(3));
            */

            /*Упражнение 2 - "про скобки"*/
            System.out.println("\n\nExercise №2\n");
            System.out.print("Enter capacity stack: ");
            Scanner in = new Scanner(System.in);
            myStack = new MyStack(Character.class, in.nextInt());
            System.out.println("Answer is - " + solution1(myStack, in));
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

    }

    static boolean solution1(MyStack stack, Scanner in) throws Exception {
        String inString = in.next();

        for (int i = 0; i < inString.length(); i++) {
            if (inString.charAt(i) == '{' | inString.charAt(i) == '(' | inString.charAt(i) == '[') {
                stack.push(inString.charAt(i));
            }
            else if (inString.charAt(i) == '}' && ((Character)stack.top()).charValue() != '{' || inString.charAt(i) == ')' && ((Character)stack.top()).charValue() != '(' || inString.charAt(i) == ']' && ((Character)stack.top()).charValue() != '[') {
                return false;
            }
            else if (inString.charAt(i) == '}' | inString.charAt(i) == ')' | inString.charAt(i) == ']'){
                stack.pop();
            }
        }
        return true;
    }
}
