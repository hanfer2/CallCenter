/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.main;

import com.mycompany.callcenter.Enum.FreeEmployee;
import com.mycompany.callcenter.Enum.TypeEmployee;
import com.mycompany.callcenter.Object.ClientCall;
import com.mycompany.callcenter.Object.Employee;
import com.mycompany.callcenter.constants.Constants;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author hgutierrez
 */
public class Dispatcher implements Runnable{

    CopyOnWriteArrayList<Employee> listEmployeeOperatorSyncro = null;
    CopyOnWriteArrayList<Employee> listEmployeeSupervisorSyncro = null;
    CopyOnWriteArrayList<Employee> listEmployeeDirectorSyncro = null;
    
    CopyOnWriteArrayList<ClientCall> listCalls = null;
    private ClientCall clientCall;
     private ExecutorService executorServiceEmployee;
     
    public Dispatcher(List<Employee> listOperadores, List<Employee> listSupervisores, List<Employee> listDirectores )
    {
      listEmployeeOperatorSyncro = new CopyOnWriteArrayList<>(listOperadores);
      listEmployeeSupervisorSyncro = new CopyOnWriteArrayList<>(listSupervisores);
      listEmployeeDirectorSyncro = new CopyOnWriteArrayList<>(listDirectores);
      
      listCalls = new CopyOnWriteArrayList<>();
      this.executorServiceEmployee = Executors.newFixedThreadPool(1);
    }
    
    
    public void dispatchAddCall(List<ClientCall> call) 
    {
      listCalls = new CopyOnWriteArrayList<>(call);
    }
    
    public boolean dispatchCall() 
    {
        Employee itememployee = null;
        boolean free = false;
       
     
        List<Employee> employeeOperatorFree =  listEmployeeOperatorSyncro.stream().filter((x) -> x.getFreeEmployee().equals(FreeEmployee.free) &&  x.getType().equals(TypeEmployee.OPERATOR)).collect(Collectors.toList());
        
        List<Employee> employeeSupervisorFree =  listEmployeeSupervisorSyncro.stream().filter(x -> x.getFreeEmployee().equals(FreeEmployee.free) &&  x.getType().equals(TypeEmployee.SUPERVISOR)).collect(Collectors.toList());
        
        List<Employee> employeeDirectorFree =  listEmployeeDirectorSyncro.stream().filter(x -> x.getFreeEmployee().equals(FreeEmployee.free)  &&  x.getType().equals(TypeEmployee.DIRECTOR)).collect(Collectors.toList());
        
        System.out.println("operador libre::"+employeeOperatorFree.size()+"--supervisor libre:::"+employeeSupervisorFree.size()+"---Hay un director libre:::"+employeeDirectorFree.size());
       
        if(employeeOperatorFree.size()>0)
        {
          itememployee =  listEmployeeOperatorSyncro.stream().filter(x -> x.getFreeEmployee().equals(FreeEmployee.free)).collect(Collectors.toList()).get(0);
            System.out.println("Hay un operador libre::"+employeeOperatorFree.size());
            
            //System.out.println("como hay un empleaod libre, tomo la llamada...."+listCalls.size());
             
            free = true;
        }else if(employeeSupervisorFree.size()>0)
        {
            itememployee =  listEmployeeSupervisorSyncro.stream().filter(x -> x.getFreeEmployee().equals(FreeEmployee.free) &&  x.getType().equals(TypeEmployee.SUPERVISOR)).collect(Collectors.toList()).get(0);
            System.out.println("Hay un supervisor libre:::"+employeeSupervisorFree.size());
             free = true;
        }else if(employeeDirectorFree.size()>0)
        {
            itememployee =  listEmployeeDirectorSyncro.stream().filter(x -> x.getFreeEmployee().equals(FreeEmployee.free)  &&  x.getType().equals(TypeEmployee.DIRECTOR)).collect(Collectors.toList()).get(0);
            System.out.println("Hay un director libre:::"+employeeDirectorFree.size());
             free = true;
        }
       
        if(itememployee!= null )
        {
             itememployee.setFreeEmployee(FreeEmployee.busy);
             ClientCall call = this.listCalls.remove(0);
             esperarXsegundos(call)   ;   
             itememployee.setFreeEmployee(FreeEmployee.free);
        }
        return free;
       
    }
    
    
    private void esperarXsegundos(ClientCall call) {
		try {
                      System.out.println("la llamada dura ::"+call.getDurationCall());
                       Thread.sleep(call.getDurationCall() * 1000);
                        System.out.println("fin dormir durante ::"+call.getDurationCall());
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
    
    @Override
    public void run() {
     
        while(true)
        {
            if(listCalls != null && listCalls.size()>0)
            {
                 System.out.println("TEngo este numero de llamadas ::::"+listCalls.size());
                //Take call and employee attend
                if(dispatchCall())
                {
                   
                }
            }else
            {
            System.out.println("no hay mas llamadas");
            Thread.interrupted();
            break;
            }
            
        }
        
        
    }
    
}
