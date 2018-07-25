/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.main;

import com.mycompany.callcenter.Object.ClientCall;

/**
 *
 * @author hgutierrez
 */
public class Dispatcher implements Runnable{

    public Dispatcher(Integer numberEmployee)
    {
        
    }
    
    
    public synchronized void dispatch(ClientCall clientCall) 
    {
       System.out.println("Incoming call duration"+clientCall.getDurationCall());
       
    }
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
