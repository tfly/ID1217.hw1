/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class PlacementVerifier implements Runnable
{

    private Middle mid;

    PlacementVerifier(Middle mid)
    {
        this.mid = mid;
    }

    @Override
    public void run()
    {
        boolean keepGoing = true;
        while (keepGoing)
            try
            {

                keepGoing = verify(mid.getFromQue());
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(PlacementVerifier.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private boolean verify(int[] board)
    {
        if (board == null)
            return false;
            
        for (int column = 0; column < 8; column++)
            if (!checkleftDown(column, board) || !checkrightDown(column, board))
                return true;

        mid.solutionFound("{" + board[0] + "," + board[1] + "," + board[2] + "," + board[3] + "," + board[4] + "," + board[5] + "," + board[6] + "," + board[7] + "}");
        return true;
    }

    private boolean checkleftDown(int column, int[] board)
    {
        int counter = 1;
        for (int i = column - 1; i > -1; i--)
        {
            if (board[i] == board[column] + counter)
                return false;
            counter++;
        }
        return true;
    }

    private boolean checkrightDown(int column, int[] board)
    {
        int counter = 1;
        for (int i = column + 1; i < 8; i++)
        {
            if (board[i] == board[column] + counter)
                return false;
            counter++;
        }
        return true;
    }
}
