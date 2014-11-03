/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;



/**
 *
 * @author usuario
 */
public interface InterfaceDataPoint {
 
    
    public void setDate(Date time);
    public Date getDate();
    public void setValue(double value);
    public double getValue();

    
}