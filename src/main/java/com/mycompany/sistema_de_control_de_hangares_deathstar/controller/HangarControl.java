/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar.controller;

import com.mycompany.sistema_de_control_de_hangares_deathstar.modelos.Nave;
import com.mycompany.sistema_de_control_de_hangares_deathstar.utils.HibernateUtil;
import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jfabr
 */
public class HangarControl {

    public void resgistrarNuevaNave(Nave nave) 
    {
        Transaction trans = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            trans = session.beginTransaction();

            session.persist(nave);
            trans.commit();
            System.out.println("Se ha guardado correctametne la Nave ");

        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            System.err.println("Error: No se ha podido guarda la Nave " + e.getMessage());

        }

    }
    
    public void actualizarEstadoNave(int id,String estado)
    {
        Transaction trans=null;
        
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            trans = session.beginTransaction();
            Nave nave =session.get(Nave.class, id);
            if(nave!=null)
            {
             nave.setEstadoSistema(estado);
             trans.commit();
                System.out.println("Se ha ha actualizado correctamente");
            }else
            {
                System.out.println("No se encontro la nave ");
            
            }
                    
            
        }catch(Exception e)
        {
             if(trans!=null)
             {
                 trans.rollback();
             
             }   
            System.err.println("Error: No se ha podido actualizar el estado de la Nave");    
        }
    
    }
    
    public List<Nave> obtenerCazasPorModelo(String modelo)
    {
              try(Session session=HibernateUtil.getSessionFactory().openSession())
              {
                 String hql="FROM Nave WHERE modelo=:model";
                  Query<Nave> query =session.createQuery(hql,Nave.class);
                  query.setParameter("model", modelo);
                  return query.list();
              }
    
    }
    

}
