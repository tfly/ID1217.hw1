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
public class BoardQueue
{

    private LinkedObject nextData = null, lastData = null;

    public void add(int[] data)
    {
        LinkedObject end = new LinkedObject(data);
        if (nextData == null)
            nextData = end;
        if (lastData != null)
            lastData.setNextData(end);
        lastData = end;
    }

    public int[] poll()
    {
        LinkedObject object = nextData;
        if (nextData == null)
            return null;
        nextData = object.getNextData();

        return object.getData();

    }

    public boolean isEmpty()
    {
        return nextData == null;
    }
}
