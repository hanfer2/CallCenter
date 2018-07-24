/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.callcenter.Object;

import java.util.Date;

/**
 *
 * @author hgutierrez
 */
public class ClientCall
{
    private Integer durationCall;
    private Date dateCall;

    public Integer getDurationCall() {
        return durationCall;
    }

    public void setDurationCall(Integer durationCall) {
        this.durationCall = durationCall;
    }

    public Date getDateCall() {
        return dateCall;
    }

    public void setDateCall(Date dateCall) {
        this.dateCall = dateCall;
    }
    
    
    
}
