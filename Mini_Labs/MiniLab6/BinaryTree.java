import java.util.Queue;
import java.util.LinkedList;
/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
Modifier: Alyce Brady
Modification Date: November 11, 2002
Modifications Made: Modifications to documentation (e.g., to remove
empty preconditions); added levelOrderTraversal;
also modified to use NodeAction interface.
Modifier: Nathan Sprague
Modification Date: May 10, 2010
Modifications Made: Modified to use Java Queue interface.

Modifications:
Modifier: studentName
Modification Date: currentDate
Modifications Made:

Description:
This file contains some of the implementation of a BinaryTree class. 
It is intended as an outline and starting point for the "Binary Trees"
lab in the Data Structures course.  The implementation is based on the 
recursive definition of a tree rather than on the graph theory definition
of a tree (compare to Bailey, 190).

A binary tree is either:
1.  An empty tree; or
2.  a node, called a root (the node contains the data), and two 
children, left and right, each of which are themselves binary trees.
(Berman, "Data Structures via C++: Objects by Evolution", 1997.)

In this implementation, an empty tree is represented by a node with null
data and null references for the children.  A leaf node is represented by
a node with a data value and two references to empty trees (NOT a data
value and two null references!).  We could represent this as an object
invariant: data, left, right are either all null (representing an empty
tree) or none of them are null (a non-empty tree).

 */

/**
 * This class contains the majority of modifier and accessor methods used for the 
 * program. The data from the binary tree is contained in this class and the traversal
 * methods allow the data to be moved around and analyzed to find information about
 * the binary tree.
 *
 * @author Sophie Sjogren
 * @version 5 June 2021
 */
public class BinaryTree
{
    //instance variables
    protected Object data;      //contains the data of the tree
    protected BinaryTree left;  //contains the node to the left of the current node
    protected BinaryTree right; //contains the node to the right of the current node

    /*tested*/
    /** Creates an empty binary tree with no data and no children. 
     *  
     */
    public BinaryTree()
    {
        //this is the contructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }

    /*tested*/
    /** Tests whether this is an empty tree.
     *      @return true if the tree is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return data == null;
    }

    /*tested*/
    /** Gets the data associated with the root node of this particular tree
     * (recall recursive definition of trees).
     *      @return value associated with tree's root node; 
     *      null if tree is empty
     */
    public Object getElement()
    {
        return data;
    }

    /*tested*/
    /** Gets the left child of the current tree.
     *      @return the left child (a tree)
     */
    public BinaryTree leftTree()
    {
        return left;
    }

    /*tested*/
    /** Gets the right child of the current tree.
     *      @return the right child (a tree)
     */
    public BinaryTree rightTree()
    {
        return right;
    }

    /** Adds elements to a binary tree.  This implementation adds the
     *  elements in breadth-first (top-down, left-to-right) order.
     *      @param value the value to be added to the tree.
     *      @return true when the value has been added; should never return false
     */
    public boolean add(Object value)
    {
        //create a queue for the list of values 
        Queue<Object> queue = new LinkedList<Object>();
        queue.add(this);  
        
        //loop through the values while the list is not empty
        while( ! queue.isEmpty() )
        {
            //remove the current node from the tree
            BinaryTree tree = (BinaryTree)queue.remove();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new 
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            queue.add(tree.left);
            queue.add(tree.right);
        }
        return false;    //this statement should never be executed.
    }

    /** Traverses the tree in breadth-first order.
     *      @param action an object that will act on all the nodes in the tree
     */
    public void breadthFirstTraversal(NodeVisitor action)
    {
        //create a queue to contain the data from the tree
        Queue<Object> queue = new LinkedList<Object>();
        queue.add(this);
        
        //create a sum object to contain the sum of the tree
        SumReduction sum = new SumReduction();
        
        //loop through the queue while is it not empty
        while( ! queue.isEmpty() )
        {
            //remove the current node from the tree
            BinaryTree tree = (BinaryTree)queue.remove();
            
            //if the node if not empty then use the visit method and add nodes to the left and right to the tree
            if ( ! tree.isEmpty() )
            {
                action.visit(tree.getElement());
                sum.visit(tree.getElement());
                queue.add(tree.leftTree());
                queue.add(tree.rightTree());
            }
        }
        
        //print the sum of the tree
        System.out.println("The sum of the data is: " + sum.getSum());
    }   

    /** Traverses the tree in pre-order.
     *      @param node from the binary tree
     */
    public void preOrderTraversal(BinaryTree node)
    {
        //if the node is not empty then execute the pre-order traversal
        if ( ! node.isEmpty() )
        {
            //print the node
            System.out.println(node.getElement());
            //recursively call nodes to the left and right 
            preOrderTraversal(node.leftTree());
            preOrderTraversal(node.rightTree());
        }
    }

    /** Traverses the tree in post-order.
     *      @param node from the binary  tree
     */
    public void postOrderTraversal(BinaryTree node)
    {
        //if the node is not empty then execute the post-order traversal
        if ( ! node.isEmpty() )
        {
            //recursively call the left and right node
            postOrderTraversal(node.leftTree());
            postOrderTraversal(node.rightTree());
            //print out the current node
            System.out.println(node.getElement());
        }
    }

    /** Traverses the tree in in-order.
     *      @param node from the binary tree
     */
    public void inOrderTraversal(BinaryTree node)
    {
        //if the node is not empty then execute the preorder traversal
        if( ! node.isEmpty() ) 
        {
            //recursively call the left node
            inOrderTraversal(node.leftTree());
            //print the current node
            System.out.println(node.getElement());
            //recursively call the right node
            inOrderTraversal(node.rightTree());
        }
    }

    /** This method checks the nodes to the right and left to see if the current node is a leaf
     *      @return true if the node is a leaf and false if not
     */
    public boolean isLeaf()
    {
        //check if the node to the left and right are both null and return true if they are 
        if(leftTree().getElement() == null && rightTree().getElement() == null)
         {
             return true;
         }
         //return false indicating not a leaf
         return false;
    } 
    
    /** This method finds the number of nodes in the tree
     *      @return the int value containing the number of nodes the tree has
     */
    public int numNodes()
    {
        //check if the tree is empty and return 0 if it is
        if(isEmpty())
        {
            return 0;
        }
        
        //recursivley call the left and right nodes and add it to the previous node to get the total of nodes
        return 1 + leftTree().numNodes() + rightTree().numNodes();
    } 
    
    /** This method finds the number of leaves in the tree
     *      @return the int value containing the number of leaves the tree has
     */
    public int numLeaves()
    {
        //check if the tree is empty and return 0 if it is
        if(isEmpty())
        {
            return 0;
        }
        
        //check if the node is a leaf indicating there is only 1 leaf, so return 1
        if(isLeaf())
        {
            return 1;
        }
        
        //recursively call the left and right trees to find leaves and add to the total
        return leftTree().numLeaves() + rightTree().numLeaves();
    }
    
    /** This method finds the depth of the tree by counting the height.
     *      @return the int containing the height of the tree
     */
    public int depth()
    {
        //check if the tree is empty and return 0 indicating it is
        if(isEmpty())
        {
            return 0;
        }
        
        //if the tree is a leaf then the height will return 0
        if(isLeaf())
        {
            return 0;
        }
        
        //find the maximum depth by recursively calling the left and right tree and comparing the count
        int maxCount;
        if(leftTree().depth()>=rightTree().depth())
        {
            maxCount = leftTree().depth();
        }
        else
        {
            maxCount = rightTree().depth();
        }
        
        //return the maximum count of the height
        return 1 + maxCount;
    }
    
    /** This method tests to see if a given item is in the tree
     *      @param an item that will be looked for in the tree
     *      @return true if the item is found and false if the item is not in the tree
     */
    public boolean contains( Object item )
    {
        //if the tree is empty then return false
        if(isEmpty())
        {
            return false;
        }
        
        //check if the item is equal to the element and and return true if it is
        if(getElement().equals(item))
        {
            return true;
        }
        
        //recursively call nodes to the left and right to see if those are equal to the item
        return leftTree().contains(item) || rightTree().contains(item);
    }
    
    /** This method tracks the number of times an item occurs in the list. 
     *      @param the item that will be looked for in the list
     *      @return the int containing the number of times the item is in the list
     */
    public int numOccurrences( Object item )
    {
        //check if the tree is empty and return 0 if it is
        if(isEmpty())
        {
            return 0;
        }
        
        //return 1 if the current node is equal to the item
        if(getElement().equals(item))
        {
            return 1;
        }
        
        //recursively call the nodes to the left and right to check if they have occurrences
        return leftTree().numOccurrences(item) + rightTree().numOccurrences(item);
    }
}

//end class BinaryTree
