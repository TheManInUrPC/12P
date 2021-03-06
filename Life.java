//-------------------------------------------------------
/**
 * Life
 * 
 * 
 * 
 * 
 * 
 */


import java.awt.Color;
import wheelsunh.users.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/**
 * Life Class.
 * 
 * 
 * 
 * 
 * @author Darien A. Blow mlb
 * 
 */
public class Life implements  KeyListener
{  
    public static final int SIZE = 10;  // size of cell
    public static final int COLS = 70;  // number of colums 
    public static final int ROWS = 50;  // number of rows 
    
    public static final int X = 10;  // base location
    public static final int Y = 10;  
    
    
    
    private Cell [ ] [ ] field; // the playing field
    
    private Stack<CellRecord> stack;
    private CellRecord cr1, cr2;
    private int r1, c1, rr1, rc1, getReturn;
    private int newRow, newCol;
    private Scanner input;
    private static JFileChooser chooser = null;
    
    //--------------------------- <init> -----------------------------------
    /**
     * Constructor.
     * 
     */
    public Life(  ) 
    {
        
        // Create field to be a ROWSXCOLS array of rectangles
        field = new Cell[ ROWS ][ COLS ];
        
        for( int r = 0; r < ROWS; r++ )
        {
            for( int c = 0; c < COLS; c++ )
            {
                field[ r ][ c ] = new Cell( c * SIZE + X, r * SIZE + Y );
            }
        }
        
        
        
        
        
        
        
        // Create a Stack of CellRecords
        
        stack = new Stack<CellRecord>();
        
        
        
        // create a CellRecord for this cell, set the return to cell to -1,-1
        // and push it into the stack
        
        cr1 = new CellRecord( 10 , 20 );
        cr1.setReturnTo( -1, -1 );
        stack.push( cr1 );
        
        
    }
    
    
    
    
    //--------------------------------------------------------------------
    /**
     *  Command keys.
     * 
     * @param code int
     *  
     */
    public void inputKeys( int code )
    {
        
        
        
        if( code == KeyEvent.VK_UP )
        {
            System.out.println( "LOADING FILE" );
            
            input = getFileScanner( );
            
            int row1 = 0;
            int col1 = 0;
            
            String s = "";
            
            while( input.hasNext( ) )
            {
                
                s = input.nextLine( );
                
                int firstInt = Integer.valueOf(
                                      s.substring( 0 , s.indexOf( " " ) ) );
                int secondInt = Integer.valueOf(
                                      s.substring( s.indexOf( " " ) + 1 ) );
                
                field[ firstInt ][ secondInt ].setLiveOrDead( true );
                
            }
            
            
            
            
            
            
            
            
            
        }  
        else if( code == KeyEvent.VK_DOWN )
        {
            for( int r = 0; r < ROWS; r++ )
            {
                for( int c = 0; c < COLS; c++ )
                {
                    field[ r ][ c ].setColor( Color.BLACK );
                    field[ r ][ c ].setFrameColor( Color.GREEN );
                }
            }
            
            System.out.println( "CLEARING ALL CELLS" );
            
        }
        else if( code == KeyEvent.VK_RIGHT )
        {
            System.out.println( "UPDATING STATE" );
            
            update( );
            //updateDead( );
            
        }
        
        
        
        
        
        
    }
   
    /**
     * 
     * update method.
     * 
     * 
     */
    public void update( )
    {
        for( int j = 0; j < ROWS; j++ )
        {
            for( int k = 0; k < COLS; k++ )
            {
                if( field[ j ][ k ].check( ) == true )
                {
                    int life = lifeCount( j , k );
                    
                    if( life < 2 )
                    {
                        field[ j ][ k ].setLiveOrDead( false );
                    }
                    if( life > 3 )
                    {
                        field[ j ][ k ].setLiveOrDead( false );
                    }
                    else
                    {
                        
                    }
                    
                }
            }
        }
        
        
    }
    
    /**
     * 
     * 
     * updateDead method.
     * 
     */
    public void updateDead()
    {
        for( int j = 0; j < ROWS; j++ )
        {
            for( int k = 0; k < COLS; k++ )
            {
                if( field[ j ][ k ].check() == false )
                {
                    int life = lifeCount( j , k );
                    
                    if( life == 3 )
                    {
                        field[ j ][ k ].setLiveOrDead( true );
                    }
                    
                    
                }
            }
        }
        
        
    }
    /**
     * 
     * Count live cells accessor.
     * 
     * 
     * @param i int
     * @param l int
     * 
     * @return count int
     */
    public int lifeCount( int i, int l )
    {
        
        int count = 0;
        
        if ( field[ i - 1 ][ l - 1 ].check( ) == true ) 
        {
            ++count;
        }
        if ( field[ i ][ l - 1 ].check( ) == true ) 
        {
            ++count;
        }
        if ( field[ i + 1 ][ l - 1 ].check( ) == true ) 
        {
            ++count;
        }
        if ( field[ i + 1 ][ l ].check( ) == true ) 
        {
            ++count;
        }
        if ( field[ i + 1 ][ l + 1 ].check( ) == true ) 
        {
            ++count;
        }
        if ( field[i][l + 1].check() == true ) 
        {
            ++count;
        }
        if ( field[i - 1][l + 1].check() == true ) 
        {
            ++count;
        }
        if ( field[i - 1][l].check() == true ) 
        {
            ++count;
        }
        
        return count;       
        
    }
    
    
    
    //---------------------- Scanner getFileScanner() ------------------
    /**
     * Use a JFileChooser dialog to get a valid file name from a user.
     *   Will not return the name unless the file exists.
     * Returns null if no valid file selected.
     * 
     * @return Scanner
     */
    public static Scanner getFileScanner( )
    {
        String fileName = null;
        Scanner reader;
        
        if ( chooser == null )
        {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory( new File( "." ) );
        }
        int returnVal = chooser.showOpenDialog( null );
        while ( fileName == null && returnVal != JFileChooser.CANCEL_OPTION ) 
        {
            if ( returnVal == JFileChooser.APPROVE_OPTION )
            {
                File f = chooser.getSelectedFile();
                if ( f.isFile() )
                    fileName = f.getPath();
            }
        }
        try
        {
            reader = new Scanner( new FileInputStream( fileName ) );
        }
        catch( IOException e )
        {
            System.err.println( e.getMessage() );
            return null;
        }
        return reader;
    }  
    
    //--------------------------------------------------------------------
    /**
     *  Handle the key pressed event. 
     *   The key codes are  KeyEvent.VK_UP,  KeyEvent.VK_DOWN,  
     *   KeyEvent.VK_RIGHT KeyEvent.VK_LEFT,  KeyEvent.VK_SHIFT.
     *  
     * @param e KeyEvent
     */
    public void keyPressed( KeyEvent e ) 
    {
        int code = e.getKeyCode( ); 
        
        System.out.println( "KEY PRESSED: " + e.getKeyCode( ) );
        
        
        
        
        // else if the code is an arrow key then call moveToNextAndPush( code)
        // (move to the new cell and push a   CellRecord on the Stack)
        
        if( code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN
               || code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT )
        {
            inputKeys( code );
        }
        
        
    }
    
    
    
    
    
    //--------------------------------------------------------------------
    /**
     * Handle the key released event from the text field. 
     *  NOT NEEDED TO GET ARROW VALUES
     * 
     *  @param e KeyEvent
     */
    public void keyReleased( KeyEvent e ) 
    {
        //System.out.println("XXKEY RELEASED: " + e.getKeyCode( ) );
    }
    
    
    //--------------------------------------------------------------------
    /**
     * Handle the key typed event from the text field. 
     *  Used to get regular character input not control keys
     *  NOT NEEDED TO GET ARROW VALUES
     * 
     *  @param e KeyEvent
     */
    public void keyTyped( KeyEvent e ) 
    {
        // System.out.println( "XXKEY TYPED: " + e.getKeyCode( ) );
    }
    
    //--------------------------- main -----------------------------------
    /**
     * Run the app.
     * 
     *  @param arg String
     */
    public static void main( String arg[ ] ) 
    {
        Frame frame = new Frame( 800, 700 );
        Life app = new Life( ); 
        
        // add app as a keyListener to frame
        frame.addKeyListener( app );
        
        
        
        
    }
}
