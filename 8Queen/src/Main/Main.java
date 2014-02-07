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
        int numberOfverifiers = 1;

        Middle mid = new Middle();
        
        
        PlacementGenerator pg = new PlacementGenerator(mid);
    
      
        ArrayList<Thread> verifiers = new ArrayList<>(numberOfverifiers);
        

        for (int i = 0; i < numberOfverifiers; i++)
        {
           Thread t =  new Thread(new PlacementVerifier(mid));
            verifiers.add(t);
            t.setName("verifier"+i);
            t.start();
        }
     
             
        long starttime = System.currentTimeMillis();
        pg.start();
        for (Thread pv : verifiers)
            pv.join();

        System.out.println("Total time to find all " + mid.getSolutions()  + " soloutions was " + (System.currentTimeMillis() - starttime) + " ms");
         
        
        
    }
}
