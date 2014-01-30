/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Thomas
 */
public class PlacementGenerator extends Thread
{

    int[] board = new int[]
    {
        0, 1, 2, 3, 4, 5, 6, 7
    };
    boolean[] column = new boolean[]
    {
        true, true, true, true, true, true, true, true
    };

    @Override
    public void run()
    {

    }

    public void createPermutations(int row)
    {
        if (row == 8)
        {

            return;
        }

        for (int col = 0; col < 8; col++)
        {
            if (column[col])
            {
                column[col] = false;
                board[row] = col;
                createPermutations(row + 1);
                column[col] = true;

            }
        }
    }

}
