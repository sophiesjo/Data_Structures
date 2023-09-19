import java.util.Scanner;
/**
 * This main method class uses ArrayStacks to perform multiple functions.
 * First, this class will ask the user for a sentence then will print that 
 * sentence in reverse order, then will print the original order of words with 
 * characters in reverse order.
 * This class will then ask for a parenthesized statement and will check 
 * to make sure all the parentheses are properly placed and report back to 
 * the user on the correctness of the inputted statement.
 * 
 * @author Sophie Sjogren 
 * @version April 19, 2021
 *
 */
public class StackMain {

    /**
     * Read a sentence in from the user and then:
     *
     *  1. Print the words in the sentence in reverse order.
     *      (order. reverse in sentence the in words the Print)
     *      
     *  2. Print the letters in each word in reverse order, 
     *     while keeping the words in the original order.
     *      (tnirP eht srettel ni hcae drow ni esrever ,redro)
     *  
     * @param args
     */
    public static void main (String[] args) {
        //-----Reversing Strings Section------
        String input = ValidatedInputReader.getString("Enter a sentence.", "");

        //Use an arraylist of strings to push each of the words into it
        ArrayStack<String> stack = new ArrayStack<String>();
        String[] splitWords = input.split(" ");    //Create an arraylist of the split up words

        //Print the original line for the user
        System.out.println("The original inputted line is: ");
        //Sort through the words in the array and push them into the arraystack while also printing the words so the user can see the original input
        for (String word : splitWords)
        {
            System.out.print(word + " ");
            stack.push(word + " ");
        }

        //Go through the arraystack and pop each word while also printing it for the user
        System.out.println("\n\nThe line in reverse is:");
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop());
        }

        //Reverse the characters in idividual words using a new arraystack
        System.out.println("\n\nThe reverse of each word for the line: ");
        ArrayStack<Character> characterStack = new ArrayStack<Character>();
        
        //Go through each word and push each character into the stack then pop each character in reverse order
        for (String nextWord: splitWords)
        {
            for(int i = 0; i < nextWord.length(); i++)
            {
                char nextChar = nextWord.charAt(i);
                characterStack.push(nextChar);
            }
            while(!characterStack.isEmpty())
            {
                System.out.print(characterStack.pop());
            }
            System.out.print(" ");
        }

        //-----Nested Parentheses Section------
        //Ask the user for a parenthesized statement
        String testInput = ValidatedInputReader.getString("Enter a phrase using letters, parentheses, braces, and brackets.", "");
        testInput = testInput.replaceAll(" ", "");      //This just saves a little energy while going through characters

        //Create an arraystack that will store all the parentheses, braces, and brackets
        ArrayStack<Character> leftChar = new ArrayStack<Character>();
        boolean check = false;      //This will be used to keep track of the correctness
        char checkChar;             //This will be the popped character
        
        //Go through each character and test for correctness
        for(int i = 0; i < testInput.length(); i++)
        {
            char newChar = testInput.charAt(i);
            //Use if statements to separate the left characters and right characters
            if(newChar == '(' || newChar == '[' || newChar == '{')
            {
                leftChar.push(newChar);
            }
            else if(newChar == ')' || newChar == ']' || newChar == '}')
            {
                //an if statement that checks if the leftChar arraystack is empty because if it is then that means there is a missing opening parenthesis
                if(leftChar.isEmpty())
                {
                    check = false;
                    break;      //ends the for loop because it is already known it is incorrect
                }
                else
                {
                    checkChar = leftChar.pop();
                }
                //with the popper character, check to make sure the two characters line up
                if(newChar == ')' && checkChar == '(')
                {
                    check = true;
                }
                else if(newChar == ']' && checkChar == '[')
                {
                    check = true;
                }
                else if(newChar == '}' && checkChar == '{')
                {
                    check = true;
                }
                else  
                {
                    check = false;
                    break;      //ends the for loop because it is already known it is incorrect
                }
            }
        }

        //Check to see if there are any leftover parenthesis in the character list which would indicate a parenthesis wasn't closed properly
        if(!leftChar.isEmpty())
        {
            check = false;
        }

        //Print the statement that the user inputted for reference
        System.out.println("\n\nThe parenthesized inputted statement is: \n" + testInput); 

        //Print out statement for user depending on the value of check
        if(check == true)
        {
            System.out.println("\nThe statement that was inputted is properly parenthesized. YAY!");
        }
        else if(check == false)
        {
            System.out.println("\nThe statement that was inputted is not properly parenthesized. Sorry :(");
        }
    }    
}
