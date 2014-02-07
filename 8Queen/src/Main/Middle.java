/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class Middle
{

    
    public Middle() {
        que = new ConcurrentLinkedQueue();
    }

    private int[] endElement = new int[0];
    private final ConcurrentLinkedQueue<int[]> que;
    private AtomicInteger solutions = new AtomicInteger();
    private int submits = 0;
    private AtomicInteger queueSize = new AtomicInteger();
    private int take = 0;

    public void addToQue(int[] board)
    {

        submits++;
        queueSize.incrementAndGet();
        que.add(board);
    }

    public void solutionFound(String comb)
    {
        System.out.println("Solution nr " + solutions.incrementAndGet() + " found, quesize = " + queueSize + ",  " + comb);
    }

    public int[] getFromQue() throws InterruptedException
    {

        while (queueSize.decrementAndGet() < 0)
        {
            queueSize.incrementAndGet();
            waitt();
        }
        
        int[] board = que.poll();
        if(board == endElement)
        {
            addToQue(endElement);
            return null;
        }
        //if (que.size() % 100 == 0)
        //  {

        //System.out.println("Take " + take + "{" + board[0] + "," + board[1] + "," + board[2] + "," + board[3] + "," + board[4] + "," + board[5] + "," + board[6] + "," + board[7] + "}");
        take++;
        //}
        return board;
    }

    public synchronized void waitt()
    {
        try
        {
            wait(10);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Middle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEndElement() {
        addToQue(endElement);
    }
}
