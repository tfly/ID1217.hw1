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
public class boardQueue
{
    
    private LinkedObject nextData = null, lastData = null;
    
    public void addToQueue(int[] data)
    {
        LinkedObject end = new LinkedObject(data);
        if (nextData == null)
            nextData = end;
        lastData.setNextData(end);
        lastData = end;
    }
    
    public synchronized int[] getNext()
    {
        LinkedObject object = nextData;
        nextData = object.getNextData();
        
        return object.getData();
        
    }
}
