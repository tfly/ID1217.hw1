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
        int numberOfverifiers = 3;
        ArrayList<PlacementVerifier> verifiers = new ArrayList<>(numberOfverifiers);

        PlacementGenerator pg = new PlacementGenerator();

        for (int i = 0; i < 3; i++)
        {
            verifiers.add(new PlacementVerifier());
        }

    }
}
