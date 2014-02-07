/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;


import java.util.ArrayList;
import java.util.List;
;

/**
 *
 * @author Thomas
 */
public class arrayQueue {
 private final ArrayList<int[]> l;
 private final int size;
 private int head = 0;
 private int tail = 0;
    public arrayQueue(int size) {
        
       this.size = size;
        l = new ArrayList<>(size);
       
    
        
    }
    public void add(int[] data)
    {
        l.add(tail, data);
        tail = (tail+ 1) %size;
    }
    public int[] poll()
    {
        int[] data = l.remove(head);
        head = head + 1 % size;
        return data;
    }
    
    public int getSize()
    {
        return l.size();
    }
    
    
    
}
