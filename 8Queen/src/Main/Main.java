/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class Main
{

    public static void main(String args[]) throws InterruptedException
    {
        //sets the number of consumer threads to proccess the possible correct solutions
        int numberOfverifiers = 5;

        //creates the
        QueueHandler mid = new QueueHandler();
        //a list with for all the consumer threads
        ArrayList<Thread> verifiers = new ArrayList<>(numberOfverifiers);
          //the producer of all the the possible solutions

        //sets the start Time
        long startTime = System.currentTimeMillis();
        PlacementGenerator pg = new PlacementGenerator(mid);
        pg.start();

        //creates and starts all the verifiers
        for (int i = 0; i < numberOfverifiers; i++)
        {

            Thread thread = new Thread(new PlacementVerifier(mid));
            verifiers.add(thread);
            thread.start();
        }

        for (Thread pv : verifiers)
            pv.join();

        System.out.println("Total time to find all " + mid.getSolutions() + " soloutions was " + (System.currentTimeMillis() - startTime) + " ms");

    }
}
