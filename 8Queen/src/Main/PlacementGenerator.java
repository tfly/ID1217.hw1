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

    
    private final QueueHandler qh;

    PlacementGenerator(QueueHandler qh)
    {
        this.qh = qh;
    }
    int[] board = new int[]
    {
        0, 0, 0, 0, 0, 0, 0, 0
    };
    boolean[] column = new boolean[]
    {
        true, true, true, true, true, true, true, true
    };

    @Override
    public void run()
    {
//        while(true)
//        {
        createPermutations(0);
//        }
        qh.addEndElement();
    }

    public void createPermutations(int row)
    {

        if (row == 8)
        {
            
            qh.addToQue(board.clone());
            return;
        }

        for (int col = 0; col < 8; col++)
            if (column[col])
            {
                column[col] = false;
                board[row] = col;
                createPermutations(row + 1);
                column[col] = true;

            }
    }
}
