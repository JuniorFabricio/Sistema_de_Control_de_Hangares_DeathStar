/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar;

import com.mycompany.sistema_de_control_de_hangares_deathstar.modelos.Nave;
import com.mycompany.sistema_de_control_de_hangares_deathstar.modelos.Planeta;
import com.mycompany.sistema_de_control_de_hangares_deathstar.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jfabr
 */
public class MainLaboratorio2 
{
    public static void main(String[] args) 
    {
        
        System.out.println("===Creamos el planeta y las naves===");
        Planeta astillero = new Planeta("Astillero de Corellia", "Mundos del Núcleo");
        
      
       
        Nave nave1 = new Nave("Caza TIE Básico", "TI-v1", 1, "Estable");
        Nave nave2 = new Nave("TIE Bomber", "TB-v1", 2, "Estable");
        
        
        astillero.agregarNave(nave1);
        astillero.agregarNave(nave2);
        
        
        Transaction trans=null;
        
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            trans=session.beginTransaction();
            session.persist(astillero);
            trans.commit();
            System.out.println("Se ha creado correctamente las naves y planetas ");
                    
        }catch(Exception e){
          if(trans!=null)
          {
              trans.rollback();
          }
            System.err.println("Error:"+ e.getMessage());
        }
        
        
        System.out.println("\n--- Manifiesto Completo de Naves Amarradas (Sesión Limpia) ---");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Planeta planetaRecuperado = session.get(Planeta.class, astillero.getId());

            if (planetaRecuperado != null) {
                System.out.println("Planeta Base: " + planetaRecuperado.getNombrePlaneta() + 
                                   " | Sector: " + planetaRecuperado.getSectorGalactico());
                System.out.println("Listado de naves en el inventario:");

                for (Nave caza : planetaRecuperado.getNaves()) {
                    System.out.println("  -> Nave: " + caza.getNombre() + 
                                       " | Modelo: " + caza.getModelo() + 
                                       " | Estado: " + caza.getEstadoSistema());
                }
            } else {
                System.out.println("ahh  No se encontró el planeta en los registros imperiales.");
            }
        }

        System.out.println("\n==================================================");
        HibernateUtil.shutdown();
    }
        
    
    }

