import java.util.ArrayList;
import java.util.List;

/*
    Main file for Binary Tree Lab
    @author Autumn C. Spaulding
    Creation Date: 24 July 2000
    
    More thorough documentation may be found within the BinaryTree class file.
*/
/**
 * This is the main method for the program and it calls upon the binarytree class
 * in order to solve the different traversals. This program will use breadth-first order, 
 * pre-order, post-order, and in-order. This class also tests the other methods in the 
 * binarytree and sumreduction class. 
 *
 * @author Sophie Sjogren
 * @version 5 June 2021
 */

public class BinaryTreeLab
{
    public static void main(String args[])
    {
        
        //construct an empty binary tree
        BinaryTree tree = new BinaryTree();
        
        //create a list of all numbers to be added
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(12);
        numList.add(7);
        numList.add(3);
        numList.add(4);
        numList.add(8);
        numList.add(25);
        numList.add(0);
        numList.add(142);
        numList.add(17);
        numList.add(26);
        
        //cycle through the list adding the Integer objects to the tree
        for(Integer newNum: numList)
        {
            tree.add(newNum);
        }
        

        //traverse the tree in breadth-first order to see what you have done.
        NodeVisitor printer = new PrintAction();
        System.out.println("******Traversing Tree: breadth-first order******");
        tree.breadthFirstTraversal(printer);
            
        //traverse the tree in in-order 
        System.out.println("\n******Traversing Tree: In-order******");
        System.out.println("Should be: 142, 4, 17, 7, 26, 8, 12, 25, 3, 0");
        tree.inOrderTraversal(tree);
        
        //traverse the tree in pre-order 
        System.out.println("\n******Traversing Tree: Pre-order******");
        System.out.println("Should be: 12, 7, 4, 142, 17, 8, 26, 3, 25, 0");
        tree.preOrderTraversal(tree);
        
        //traverse the tree in post-order 
        System.out.println("\n******Traversing Tree: Post-order******");
        System.out.println("Should be: 142, 17, 4, 26, 8, 7, 25, 0, 3, 12");
        tree.postOrderTraversal(tree);
        
        //analyze the tree and print out information about the nodes, leaves, depth, and what it contains
        System.out.println("\n******To Know About The Tree******");
        System.out.println("The number of nodes: \n" + tree.numNodes());
        System.out.println("The number of leaves: \n" + tree.numLeaves());
        System.out.println("The depth of the tree: \n" + tree.depth());
        Integer testInt = new Integer(7);
        Integer otherTestInt = new Integer(13);
        System.out.println("Does it contain 7? \n" + tree.contains(testInt));
        System.out.println("Does it contain 13? \n" + tree.contains(otherTestInt));
        System.out.println("7 occurs " + tree.numOccurrences(testInt) + " time(s)");
    }

}   //end class BinaryTreeLab
