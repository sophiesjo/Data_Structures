import java.util.LinkedList;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This main class creates a string array and uses the other classes to edit and 
 * print data from and about the list. 
 * I got this code from the mini-labs teams channel.
 *
 * @author Sophie Sjogren and Dr. Vargas Perez
 * @version 4-26-21
 */
public class MainQueuTest
{
    public static void main(String[] args)
    {
        KQueue<String> queue = new LLQueue<String>();
        
        //Paste this code after declaring your queue object the appropiate way
        
        String[] str = ("the KQueue interface specifies methods for a queue data structure").split(" ");
        System.out.println("> Enqueueing " + str.length + " elements.");
        for(String s : str )
            queue.enqueue(s);
        System.out.println("> The queue's contents: \n\t" + queue.toString());
        System.out.println("> The queue's size is: \n\t" + queue.size());
        System.out.println("> Dequeueing: \n\tValue should be: the \n\t"
            + "Actual value is: " + queue.dequeue());
        System.out.println("> The queue's size: \n\tShould be: 9 \n\t"
            + "Actual is: " + queue.size());
        System.out.println("> Peeking at the value in front of the queue: \n\tValue should be: KQueue \n\t"
            + "Actual value is: " + queue.peekFront());
        System.out.print("> Dequeueing all remaining values: \n\t");
        while ( !queue.isEmpty() )
        {
            String element = queue.dequeue();
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("> Queue should be empty: \n\t" + queue.isEmpty());
        try 
        {
            System.out.println("> Trying to dequeue from an empty queue...");
            String element = queue.dequeue();
        } 
        catch (Exception e) 
        {
            System.out.println("\t" + e.toString());
        }
        try 
        {
            System.out.println("> Trying to peek at an empty queue...");
            String element = queue.peekFront();
        } 
        catch (Exception e) 
        {
            System.out.println("\t" + e.toString());
        }
    }
}
