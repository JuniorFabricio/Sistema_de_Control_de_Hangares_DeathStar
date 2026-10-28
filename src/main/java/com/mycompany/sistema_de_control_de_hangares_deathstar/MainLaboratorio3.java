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
            
            
            System.out.println("===Naves del Bando Imperio===");
            List<Nave> navesImperio = hole.obtenerNavesPorBandoPlaneta("Imperio");
             
            if (navesImperio.isEmpty()) {
                System.out.println("No hay ninguna nave en el sector del Imperio."); 
            } else {
                for (Nave nave : navesImperio) {
                    System.out.println(nave.toString()); 
                }
            }
             
           
            System.out.println("===Flota Critica==="); 
            List<Nave> flotaCritica = hole.obtenerFlotaCriticaConPlaneta();
             
            if (flotaCritica.isEmpty()) {
                System.out.println("No hay naves en estado critico."); 
            } else {
                for (Nave nave : flotaCritica) {
                    System.out.println(nave.toString()); 
                }
            }
             
           
            System.out.println("===Reporte de Planetas Asignados==="); 
            List<Object[]> reporte = hole.obtenerReportePlanetasAsignados();
            System.out.printf("%-30s | %-20s%n", "Nave", "Planeta");
            System.out.println("-------------------------------------------------------");
            //Ese formato me lo saco la IA , pero lo que hace es ir comprabando  el nombre y el planeta en caso de que no tenga
            //con un ternario le pones [sin nombre] o [sin planeta] y luego usamos el format del sout y le pasamos las variables y las colque en su sitio
            for (Object[] fila : reporte) {
                String naveNombre = (fila[0] != null) ? (String) fila[0] : "[SIN NOMBRE]";
                String planetaNombre = (fila[1] != null) ? (String) fila[1] : "[SIN PLANETA]";
                System.out.printf("%-30s | %-20s%n", naveNombre, planetaNombre);
            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la ejecucion:");
            
        } finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }
    }
}
