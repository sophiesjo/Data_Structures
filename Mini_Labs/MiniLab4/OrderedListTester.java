import java.util.Random;
/**
 * This class is a tester for the orderlist and creates a list object which will
 * store generic type elements. The class also tests other methods from the orderlist
 * class and prints out the current list. 
 *
 * @author Sophie Sjogren, worked with Tabitha
 * @version 5-7-21
 */
public class OrderedListTester
{
    public static void main(String[] args)
    {
        //initialize the orderlist object
        OrderList list = new OrderList();
        
        // Adds 1,000 random elements between 0 and 1,000 to the ordered list
        // Random r = new Random();
        // for (int i = 0; i < 1000; i++) {
            // list.add(r.nextInt(1001));
        // }
        
        //System.out.println(list.find(50));
        //System.out.println(list.contains(50));

        //add strings to the ordered list
        String[] str = ("This is the tester code for making an ordered list . We will see if it works fingers crossed ! Very exciting").split(" ");
        for(String s : str)
        {
            list.add(s);
        }
        
        //print out the current string
        System.out.println("List before being modified:");
        System.out.println(list.toString()+"\n");
        
        //test methods in the orderlist class and print results
        System.out.println("Check if contains 'for', should be true: ");
        System.out.println(list.contains("for")+"\n");
        System.out.println("Check if contains 'not', should be false: ");
        System.out.println(list.contains("not")+"\n");
        System.out.println("Remove 'an' if exists, should be true: ");
        System.out.println(list.removeIfExists("an")+"\n");
        System.out.println("Remove the element at index 5: ");
        System.out.println(list.remove(5)+"\n");
        System.out.println("Find 'the' in the list: ");
        System.out.println(list.find("the")+"\n");
        System.out.println("Get the element at index 10");
        System.out.println(list.get(10)+"\n");
        
        //print the list after it has been modified
        System.out.println("List after being modified: ");
        System.out.println(list.toString());
    }
}
