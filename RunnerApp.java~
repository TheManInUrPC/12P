//-------------------------------------------------------
/**
 * RunnerApp
 * Lab 21
 * 
 * mlb
 * 
 */


import java.awt.Color;
import wheelsunh.users.*;
import java.util.*;
import java.awt.event.*;



public class RunnerApp implements   KeyListener
{  
    public static final int SIZE = 12;  // size of cell
    public static final int COLS = 50;  // number of colums 
    public static final int ROWS = 30;  // number of rows 
    
    public static final int X = 10;  // base location
    public static final int Y = 10;  
    
    
    
    private Rectangle [ ] [ ] field; // the playing field
    
    private Stack<CellRecord> stack;
    private CellRecord cr1, cr2;
    private Runner runner;
    private int r1, c1, rr1, rc1, getReturn;
    private int newRow, newCol;
    
    //--------------------------- <init> -----------------------------------
    /*
     * 
     */
    public RunnerApp(  ) 
    {
        
        // Create field to be a ROWSXCOLS array of rectangles
        field = new Rectangle[ ROWS ][ COLS ];
        
        for( int r = 0; r < ROWS; r++ )
        {
            for( int c = 0; c < COLS; c++ )
            {
                field[r][c] = new Rectangle(c*SIZE+X, r*SIZE+Y );
                field[r][c].setColor( Color.GREEN );
                field[r][c].setFrameColor( Color.BLACK );
                field[r][c].setSize( SIZE, SIZE );
            }
        }
        
        
        
        
        
        // Fill the field with squares of size SIZE, green with black frames
        // And lay them out in a grid
       
    
        
        
        // Create a Stack of CellRecords
       
        stack = new Stack<CellRecord>();
        
        // create a new Runner 
       
        runner = new Runner();
        
        // move to the cell  10 20
        
        runner.moveTo( 10 , 20 );
        
        
        // create a CellRecord for this cell, set the return to cell to -1,-1
        // and push it into the stack
     
        CellRecord cr1 = new CellRecord( 10 , 20 );
        cr1.setReturnTo( -1, -1 );
        stack.push( cr1 );
        
        // set the color of this cell to white
        field[10][20].setColor( Color.WHITE );
        
    }
    
    
    
    
    
    //--------------------------------------------------------------------
    /*
     *  popAndMove
     *  
     */
    public void popAndMoveBack()
    {
        System.out.println( "Pop and back up" );
        // if stack is empty just return
        if( stack.empty() == true )
        {
            return;
        }

        
        // pop a CellRecord off the stack
        // get the current row and col and the "return to" row and col from the record
        // set the color of the current cell to cyan
        // move the runner to the "return to" cell
 
            CellRecord cr3 = stack.pop( );
            
            rr1 = runner.getRow();
            rc1 = runner.getCol();
            
            int rr2 = cr3.getReturnRow();
            int rc2 = cr3.getReturnCol();
            
            field[rr1][rc1].setColor( Color.CYAN);
            
            runner.moveTo( rr2 , rc2 );


       



    }
    
    
    //--------------------------------------------------------------------
    /*
     *  move and push
     *  
     */
    public void moveToNextAndPush(int code )
    {
         System.out.println( "Move forward  and Push" );
        
        // get the current row and column from the runner
        r1 = runner.getRow();
        c1 = runner.getCol();
        
        
        // set the new row and column to the current row and column
        
        
        
        // Adjust the new row and column acording to the key code
        
        newRow = r1;
        newCol = c1;
        
        if( code == KeyEvent.VK_UP )
        {
            newRow = r1 -1;
        }
        else if( code == KeyEvent.VK_DOWN )
        {
            newRow = r1 + 1;
        }
        else if( code == KeyEvent.VK_LEFT )
        {
            newCol = c1 - 1;
        }
        else if( code == KeyEvent.VK_RIGHT )
        {
            newCol = c1 + 1;
        }



        
        // Creat a CellRecord for the new row and col
       CellRecord cr2 = new CellRecord( newRow, newCol );
        
        // set the CellRecords "return to" row and column to the 
        //current row and col
        cr2.setReturnTo( r1 , c1  );
        
        //  Push the record onto the stack
       stack.push( cr2 );
        
        // move the runner to the new row and col
        runner.moveTo( newRow, newCol );
        
        //set the color of the new cell to white
        field[newRow][newCol].setColor( Color.WHITE );
        
        
        
    }
    
    
    
    //--------------------------------------------------------------------
    /*
     *  Handle the key pressed event. 
     *   The key codes are  KeyEvent.VK_UP,  KeyEvent.VK_DOWN,  
     *   KeyEvent.VK_RIGHT KeyEvent.VK_LEFT,  KeyEvent.VK_SHIFT.
     *  
     */
    public void keyPressed(KeyEvent e) 
    {
        int code = e.getKeyCode( ); 
        
        System.out.println("KEY PRESSED: " + e.getKeyCode( ) );
        
   


        // if the code is a shift key  then  call popAndMoveBack
        // ( pop the Stack and move back to the previous cell)
        if( code == KeyEvent.VK_SHIFT )
        {
            popAndMoveBack();
        }


        
        // else if the code is an arrow key then call moveToNextAndPush( code)
        // (move to the new cell and push a   CellRecord on the Stack)
   
        else if( code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN || code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT )
        {
            moveToNextAndPush( code );
        }


    }
    
    
    
    
    
    //--------------------------------------------------------------------
    /*
     * Handle the key released event from the text field. 
     *  NOT NEEDED TO GET ARROW VALUES
     */
    public void keyReleased(KeyEvent e) 
    {
        //System.out.println("XXKEY RELEASED: " + e.getKeyCode( ) );
    }
    
    
    //--------------------------------------------------------------------
    /*
     * Handle the key typed event from the text field. 
     *  Used to get regular character input not control keys
     *  NOT NEEDED TO GET ARROW VALUES
     */
    public void keyTyped(KeyEvent e) 
    {
        // System.out.println( "XXKEY TYPED: " + e.getKeyCode( ) );
    }
    
    //--------------------------- main -----------------------------------
    /*
     * Run the app
     */
    public static void main( String arg[ ] ) 
    {
        Frame frame = new Frame();
        RunnerApp app = new RunnerApp( ); 

        // add app as a keyListener to frame
        frame.addKeyListener( app );
        


    
    }
}
