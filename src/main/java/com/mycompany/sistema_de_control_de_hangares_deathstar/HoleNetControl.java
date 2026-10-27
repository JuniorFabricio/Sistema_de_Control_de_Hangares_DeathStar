/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar;

import com.mycompany.sistema_de_control_de_hangares_deathstar.modelos.Nave;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DAM2P
 */
public class HoleNetControl {

    private final Session session;

    public HoleNetControl(Session session) 
    {
        this.session = session;
    }
    
    public List<Nave> obtenerNavesPorBandoPlaneta(String bando)
    {
        return session.createQuery("SELECT n FROM Nave n INNER JOIN n.planeta p " +
                "Where p.afiliacion= :bando AND n.estadoSistema != 'Mantenimiento'",Nave.class)
                .setParameter("bando", bando)
                .getResultList();
        
    
    }
    
    public List<Nave> obtenerFlotaCriticaConPlaneta()
    {
         return session.createQuery("SELECT n FROM Nave n LEFT JOIN FETCH n.planetaOrigen " +
                "WHERE n.estadoSistema = 'Critico'", Nave.class)
                .getResultList();
    
    }
   
    public List<Object[]> obtenerReportePlanetasAsignados()
    {
    
        return session.createQuery("SELECT n.nombre, p.nombre FROM Nave n LEFT JOIN n.planetaOrigen p ",Object[].class).getResultList();
    }

}
