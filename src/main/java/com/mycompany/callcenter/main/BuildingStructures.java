/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.main;

import com.mycompany.callcenter.Enum.TypeEmployee;
import com.mycompany.callcenter.Object.ClientCall;
import com.mycompany.callcenter.Object.Employee;
import com.mycompany.callcenter.Useful.Useful;
import com.mycompany.callcenter.constants.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hgutierrez
 */
public class BuildingStructures {
    
  private static List<Employee> listEmployees = new ArrayList<>();
   


  
   public static List<Employee> listEmployees(Integer numberOperators, Integer numberSupervisor, Integer numberDirector)
   {
     
    fillEmployee(numberOperators, TypeEmployee.OPERATOR);
    fillEmployee(numberSupervisor, TypeEmployee.SUPERVISOR);
    fillEmployee(numberDirector, TypeEmployee.DIRECTOR);
     
      return listEmployees;
   }
   
   public static void fillEmployee(Integer number, TypeEmployee type)
   {
      int i=0;
        Employee employee = null;
       while(i< number )
      {
        employee = new Employee();
        employee.setType( TypeEmployee.OPERATOR);
        listEmployees.add(employee);
        i++;
      }
   }
   
   
   public static List<ClientCall> listClientCalls(Integer numberCalls)
   {
     List<ClientCall> listClientCalls = new ArrayList<>();
      int i=0;
        ClientCall clientCall = null;
       while(i< numberCalls )
      {
        clientCall = new ClientCall();
        clientCall.setDurationCall(Useful.returnDuractionCall(Constants.minDurationCalls, Constants.maxDurationCalls));
        clientCall.setDateCall(new Date());
        listClientCalls.add(clientCall);
        i++;
      }
     
      return listClientCalls;
   }

    
}
