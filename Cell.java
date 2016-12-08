//-------------------------------------------------------
/**
 * Cell
 * 
 * 
 * Darien A. Blow mlb
 * 
 */


import java.awt.Color;
import wheelsunh.users.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/**
 * Cell class.
 * 
 * 
 * @author Darien A. Blow
 * 
 */
public class Cell extends Rectangle
{  
    public static final int SIZE = 10;  // size of cell
    public static final int COLS = 70;  // number of colums 
    public static final int ROWS = 50;  // number of rows 
    
    
    
    
    private Rectangle [ ] [ ] field; // the playing field
    
    private Stack<CellRecord> stack;
    private CellRecord cr1, cr2;
    private int r1, c1, rr1, rc1, getReturn;
    private int newRow, newCol;
    private Scanner input;
    private static JFileChooser chooser = null;
    private boolean life = false;
    //--------------------------- <init> -----------------------------------
    /**
     * Constructor.
     * 
     * @param x int
     * @param y int
     */
    public Cell( int x, int y ) 
    {
        
        
        
        super( x , y );
        super.setColor( Color.BLACK );
        super.setFrameColor( Color.GREEN );
        super.setSize( SIZE, SIZE );
        
        
        
    }
    /**
     * Mouse clicked.
     * 
     * 
     * @param e MouseEvent
     * 
     */ 
    public void mouseClicked( MouseEvent e )
    {
        e.getPoint();
        
        if( check() == true )
        {
            setLiveOrDead( false );
        }
        else if( check() == false )
        {
            setLiveOrDead( true );
        }
        
        
    }
    
    /**
     * Check accessor.
     * 
     * 
     * @return life int
     * 
     */
    public boolean check()
    {
        return life;
    }
    
    /**
     * 
     * setLiveOrDead Method.
     * 
     * @param a boolean
     * 
     */
    public void setLiveOrDead( boolean a )
    {
        if( a == false )
        {
            life = false;
            setFillColor( Color.BLACK );
        }
        else
        {
            life = true;
            setFillColor( Color.WHITE );
        }
    }
    
    
    
    //--------------------------- main -----------------------------------
    /**
     * Run the app.
     * 
     * 
     * @param arg String
     */
    public static void main( String arg[ ] ) 
    {
        Frame frame = new Frame();
        Cell app = new Cell( 10, 10 ); 
        
        
        
        
        
    }
}
