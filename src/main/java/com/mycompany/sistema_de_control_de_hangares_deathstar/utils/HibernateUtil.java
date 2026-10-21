/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author jfabr
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("✔ [HibernateUtil] SessionFactory inicializada correctamente en el sector.");
        } catch (Throwable ex) {
            System.err.println("❌ Fallo crítico al inicializar la SessionFactory de Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cierra los flujos y cachés de forma segura al finalizar la aplicación
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            System.out.println("ℹ [HibernateUtil] SessionFactory cerrada de forma segura.");
        }

    }

}
