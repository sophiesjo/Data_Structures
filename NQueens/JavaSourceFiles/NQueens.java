package JavaSourceFiles;

// Class: NQueens
//
// Author: Sophie Sjogren
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.display.GridDisplay;
import edu.kzoo.grid.GridObject;

/**
 *  Environment-Based Applications:<br>
 *
 *    The NQueens class implements the N Queens problem. There are modifier and accessor
 *    methods which will sort through each column and row to find an algorithm
 *    that will place n queens in an n x n board. 
 *
 *  @author Sophie Sjogren
 *  @author Worked with Tabitha
 *  @version 3 June 2021
 **/

public class NQueens
{
    // Instance Variables: Encapsulated data for EACH NQueens problem
    private Grid board;
    private GridDisplay display;

    //Constructor for NQueens
    /** Constructs an object that solves the N Queens Problem.
     *    @param n the number of queens to be placed on an
     *              <code>n</code> x <code>n</code> board
     *    @param d an object that knows how to display an 
     *              <code>n</code> x <code>n</code> board and
     *              the queens on it
     **/
    public NQueens(int n, GridDisplay d)
    {
        board = new BoundedGrid(n, n);
        display = d;
        display.setGrid(board);
        display.showGrid();
    }

    //Methods for NQueens
    /** Returns the number of queens to be placed on the board. This is done by 
     * returning the number of rows because there are n queens in an n x n grid 
     *
     *      @return the number of queens, same as the number of rows and cols
     **/
    public int numQueens()
    {
        //return the number of rows because it will be equal to the number of queens
        return board.numRows();  
    }

    /** Solves (or attempts to solve) the N Queens Problem. 
     *
     *      @return a boolean indicating the problem is solved
     **/
    public boolean solve()
    {
        //call upon the placeQueen() method using the first location of the grid at 0
        placeQueen(0); 
        
        //return true indicating it is solved
        return true;   
    }

    /** Attempts to place the <code>q</code>th queen on the board. Sorts through eacch
     * row and col to check for valid locations.
     *  (Precondition: <code>0 <= q < numQueens()</code>)
     *      @param q index of next queen to place
     *      @return the attribute value
     **/
    private boolean placeQueen(int q)
    {
        //check if the given queen is more than the number of queens
        if(q >= numQueens())
            return true;

        //cycle through each row and column in the board
        for(int i = 0; i < board.numRows(); i++)
        {
            for(int x = 0; x < board.numCols(); x++)
            {
                //set the new location to be at the current row and col in the for each loops
                Location loc =  new Location(i,x);

                //use the locationIsOK() method to check if it is valid
                if(locationIsOK(loc))
                {
                    //add the queen to that location
                    addQueen(loc);
                    
                    //display the new grid
                    display.showGrid();
                    
                    //recursively call the method 
                    if(placeQueen(q + 1))
                    {
                        return true;
                    }
                    else
                    {
                        //remove the queen if the next location doesn't work
                        removeQueen(loc);
                        //display the new grid
                        display.showGrid();
                    }
                }
            }
        }
        //return false because location wasn't valid
        return false;
    }

    /** This method determines whether a queen can be placed at the specified location.
     * And returns a boolean indication if the location is where another queen can't attack. 
     *  
     *    @param loc  the location to test
     *    @return a boolean indicating if the location is valid
     **/
    private boolean locationIsOK(Location loc)
    {
        //create an array containing all the objects in the grid
        GridObject  Ary[] = board.allObjects();

        //sort through each object of the array
        for(GridObject a: Ary){
            //return false if the location is equivilant to one that can be attacked by the specified queen object
            if(loc.col() == a.location().col() ||loc.row() == a.location().row() || Math.abs((a.location().row() - loc.row())) == Math.abs((a.location().col()-loc.col()))){
                return false;
            }
        }
        //reurn true because the given location couldn't be attacked by other grid objects
        return true;
    }

    /** Adds a queen to the specified location.
     * 
     *    @param loc  the location where the queen is placed
     **/
    private void addQueen(Location loc)
    {
        //create a new queen object added to the specified location
        new Queen(board, loc);      
    }

    /** Removes a queen from the specified location.
     * 
     *    @param loc  the location where the queen is removed
     **/
    private void removeQueen(Location loc)
    {
        //call on remove() method to remove the object at the specified location
        board.remove(loc);
    }

}
