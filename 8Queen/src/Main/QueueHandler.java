/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Thomas
 */
public class QueueHandler
{

    public int getSolutions()
    {
        return solutions.get();
    }

    public QueueHandler()
    {
        lock = new ReentrantLock();
        que = new BoardQueue();
//        notEmpty = lock.newCondition();
    }

    private final int[] endElement = new int[0];
    private final BoardQueue que;
    private final AtomicInteger solutions = new AtomicInteger();
    private final String sync = "";

    private final Lock lock;
//    final Condition notEmpty;

    public void addToQue(int[] board)
    {

        que.add(board);
        synchronized (sync)
        {
            sync.notify();
        }
    }

    public void solutionFound(String comb)
    {
        System.out.println("Solution nr " + solutions.incrementAndGet() + " found, quesize =  + que.size() +   " + comb);
    }

    public int[] getFromQue() throws InterruptedException
    {
//        if(take%1000 == 0)
//        System.out.println(take + "  " + que.size());
//        take++;

        int[] board;

        lock.tryLock(1, TimeUnit.DAYS);
        try
        {
            if (que.isEmpty())
                synchronized (sync)
                {
                    sync.wait();
                }

            board = que.poll();

        }
        finally
        {

            lock.unlock();
        }

        if (board == endElement)
        {
            addToQue(endElement);
            return endElement;
        }

        return board;
    }

    public void addEndElement()
    {
        addToQue(endElement);
        System.out.println("all produced");
    }
}
