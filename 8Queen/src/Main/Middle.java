/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class Middle
{
    public int getSolutions()
    {
        return solutions.get();
    }

    
    public Middle() {
        lock = new ReentrantLock();
        que = new LinkedBlockingQueue<>();
        notEmpty = lock.newCondition();
    }

    private final int[] endElement = new int[0];
    private final LinkedBlockingQueue<int[]> que;
    private final AtomicInteger solutions = new AtomicInteger();
    private String a = "";
    



    private final Lock lock;
    final Condition notEmpty;

    public void addToQue(int[] board)
    {

        que.add(board);
        synchronized(a) 
        {
        a.notify();
        }
    }

    public void solutionFound(String comb)
    {
        System.out.println("Solution nr " + solutions.incrementAndGet() + " found, quesize = " + que.size() + ",  " + comb);
    }

    public int[] getFromQue() throws InterruptedException
    {
        int[] board;
       
        
          lock.tryLock(1, TimeUnit.DAYS);
        try {
            if(que.isEmpty())                
                synchronized(a)
               {
               a.wait();
              }
            board = que.poll();
            
        } finally {

            lock.unlock();
        }
        
        if(board == endElement)
        {
            addToQue(endElement);
            return null;
        }
     
        
       
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
        System.out.println("all produced");
    }
}
