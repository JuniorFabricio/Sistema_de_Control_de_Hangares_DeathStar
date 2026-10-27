/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar;

import com.mycompany.sistema_de_control_de_hangares_deathstar.modelos.Nave;
import com.mycompany.sistema_de_control_de_hangares_deathstar.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author DAM2P
 */
public class MainLaboratorio3 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            HoleNetControl hole = new HoleNetControl(session);
            

            System.out.println("Naves del Bando Imperio ");
            
             List<Nave> navesImperio = hole.obtenerNavesPorBandoPlaneta("Imperio");
             
             
             if(navesImperio.isEmpty())
             {
                 System.out.println("No hay ninguna nabe del bando Imperio"); 
            
             
             }else{
                    for (Nave nave : navesImperio) 
                    {
                            System.out.println(nave.toString()); 
                   }
             
             }
             
             System.out.println("===Flota critica==="); 
           List<Nave> flotaCritica =hole.obtenerFlotaCriticaConPlaneta();
             
             
             if(flotaCritica.isEmpty())
             {
                 System.out.println("No hay ninguna nabe del bando Imperio"); 
            
             
             }else{
                    for (Nave nave : flotaCritica) 
                    {
                            System.out.println(nave.toString()); 
                   }
             
             }
             
             
             
             List<Object[]> reporte=hole.obtenerReportePlanetasAsignados();
              for (Object[] fila : reporte) {
                String naveNombre = (String) fila[0];
                String planetaNombre = (fila[1] != null) ? (String) fila[1] : "[SIN PLANETA]";
                System.out.printf("%-30s | %-20s%n", naveNombre, planetaNombre);
            }
             
             


        } catch (Exception e) {
        }finally {
            // Cierre seguro de la factoría al terminar el programa
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
            }
    }

    }
}
