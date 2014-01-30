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

    public static void main(String args[])
    {
        int numberOfverifiers = 1;

        Middle mid = new Middle();
        PlacementGenerator pg = new PlacementGenerator(mid);
        pg.start();

        ArrayList<PlacementVerifier> verifiers = new ArrayList<>(numberOfverifiers);

        for (int i = 0; i < numberOfverifiers; i++)
            verifiers.add(new PlacementVerifier(mid));

        for (PlacementVerifier pv : verifiers)
            new Thread(pv).start();

    }
}
