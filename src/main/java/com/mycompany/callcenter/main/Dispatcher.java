/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.main;

import com.mycompany.callcenter.Object.ClientCall;
import com.mycompany.callcenter.Object.Employee;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hgutierrez
 */
public class Dispatcher implements Runnable{

    List<String> listEmployees = null;
    
    public Dispatcher(List<Employee> listEmployees)
    {
        Collections.synchronizedList(listEmployees);
    }
    
    
    public synchronized void dispatchCall() 
    {
      
       
    }
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
