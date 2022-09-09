/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.jopa.Controller;

import com.utp.jopa.Dto.Variables;
import com.utp.jopa.Interface.ICalculo;

/**
 *
 * @author buitr
 */
public class Calculo implements ICalculo{

    @Override
    public int insertarVariables(String nombreVariable, int valorVariable) {
        
        //Variables variables = new Variables();
        //variables.setNombreVariable(nombreVariable);
        //variables.setValorVariable(valorVariable);      

        return valorVariable;
    }
    
}
