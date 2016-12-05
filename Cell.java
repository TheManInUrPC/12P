//-------------------------------------------------------
/**
 * Cell
 * Lab 21
 * 
 * mlb
 * 
 */


import java.awt.Color;
import wheelsunh.users.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;



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
    /*
     * 
     */
    public Cell( int x, int y ) 
    {
        
        
        
        super( x , y );
        super.setColor( Color.BLACK );
        super.setFrameColor( Color.BLACK );
        super.setSize( SIZE, SIZE );
        
        
        
    }
    
    public void mouseClicked( MouseEvent e )
    {
        e.getPoint();
        
        if( check() == true )
        {
            setLiveOrDead( false );
        }
        
        if( check() == false )
        {
            setLiveOrDead( true );
        }
        
        
    }
    
    public boolean check()
    {
        return life;
    }
    
    public void setLiveOrDead( boolean a )
    {
        if( a == false )
        {
            life = false;
            setFillColor( Color.BLACK );
        }
        if( a == true );
        {
            life = true;
            setFillColor( Color.WHITE );
        }
    }
    
    
    
    //--------------------------- main -----------------------------------
    /*
     * Run the app
     */
    public static void main( String arg[ ] ) 
    {
        Frame frame = new Frame();
        Cell app = new Cell( 10, 10 ); 
        
        
        
        
        
    }
}
