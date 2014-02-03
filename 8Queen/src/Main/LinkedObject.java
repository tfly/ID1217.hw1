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
public class LinkedObject
{

    private LinkedObject nextData;
    private int[] data;

    public LinkedObject(int[] data)
    {
        this.data = data;
        this.nextData = nextData;
    }

    public LinkedObject getNextData()
    {
        return nextData;
    }

    public int[] getData()
    {
        return data;
    }

    public void setNextData(LinkedObject nextData)
    {
        this.nextData = nextData;
    }
}
