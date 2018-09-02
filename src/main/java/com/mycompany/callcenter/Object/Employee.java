/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.Object;

import com.mycompany.callcenter.Enum.FreeEmployee;
import com.mycompany.callcenter.Enum.TypeEmployee;

/**
 *
 * @author hgutierrez
 */
public class Employee {
    
    
    private TypeEmployee type;
    private FreeEmployee freeEmployee;
    
    public TypeEmployee getType() {
        return type;
    }
    
   

    public void setType(TypeEmployee type) {
        this.type = type;
    }

    public FreeEmployee getFreeEmployee() {
        return freeEmployee;
    }

    public synchronized void setFreeEmployee(FreeEmployee freeEmployee) {
        this.freeEmployee = freeEmployee;
    }
    
    
    
}
