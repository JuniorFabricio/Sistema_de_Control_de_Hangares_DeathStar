/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar;

import com.mycompany.sistema_de_control_de_hangares_deathstar.controller.HangarControl;
import com.mycompany.sistema_de_control_de_hangares_deathstar.modelos.Nave;
import java.sql.SQLOutput;
import java.util.List;

/**
 *
 * @author jfabr
 */
public class MainHagar 
{
    public static void main(String[] args) {
        HangarControl con= new HangarControl();
        
       Nave naveInterceptor = new Nave("TIE Interceptor", "TI-v2", 1, "Critico");
        
        System.out.println("--Registro de una nueva nave---");
        
        con.resgistrarNuevaNave(naveInterceptor);
        
        int id = naveInterceptor.getId();
        System.out.println("--- Cambio de estado ---");
        
        con.actualizarEstadoNave(id, "Estable");
        
        System.out.println("Listado de las naves por modelo ");
        
        List<Nave> cazasTiv2 = con.obtenerCazasPorModelo("TI-v2");
        
        if(cazasTiv2.isEmpty())
        {
            System.out.println("No se ha encontrado ninguna nave de ese modelo");
        }else{
        
            for (Nave nave : cazasTiv2) 
            {
                System.out.println(nave.toString());
            }
        }

    }

}
