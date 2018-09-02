/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.main;

import com.mycompany.callcenter.Enum.TypeEmployee;
import com.mycompany.callcenter.Object.ClientCall;
import com.mycompany.callcenter.Object.Employee;
import com.mycompany.callcenter.constants.Constants;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author hgutierrez
 */
public class MainExecutor {
    
     public static void main(String[] args) {
     
         System.out.println("Empleados en el sistema");
        // System.out.println(listEmployees);
         long init = System.currentTimeMillis();  
          
         ExecutorService executor = Executors.newFixedThreadPool(Constants.numberThread);
         
         List<ClientCall> listCalls = BuildingStructures.listClientCalls(10);
         System.out.println("Llamadas que se vana procesar");
         //System.out.println(listEmployees);
         Dispatcher dispatcher = new Dispatcher(BuildingStructures.listEmployees(2, TypeEmployee.OPERATOR),BuildingStructures.listEmployees(2, TypeEmployee.SUPERVISOR),BuildingStructures.listEmployees(1, TypeEmployee.DIRECTOR));
         
        
         
        for(ClientCall call: listCalls)
        {
            dispatcher.dispatchAddCall(listCalls);
            executor.execute(dispatcher);
         }
         
        executor.shutdown();	// Cierro el Executor
        while (!executor.isTerminated()) {
        	// Espero a que terminen de ejecutarse todos los procesos 
        	// para pasar a las siguientes instrucciones 
        }
        
        long fin = System.currentTimeMillis();	// Instante final del procesamiento
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
         
     }
    
    
}
