/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author jfabr
 */
@Entity
@Table(name="naves")
public class Nave implements Serializable
{
    // 1. Clave Primaria Autonumérica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mapea el tipo 'SERIAL' de Postgres
    @Column(name = "nave_id") // Vincula el atributo con el nombre exacto de la columna
    private int id;

    // 2. Columnas obligatorias (NOT NUL)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "capacidad_pasajeros", nullable = false)
    private int capacidadPasajeros;

    @Column(name = "estado_sistema", nullable = false, length = 20)
    private String estadoSistema;
    
    
    //Esto sirve para la relaccion entre las dos tablas  para la FK
    @ManyToOne
    @JoinColumn(name="planeta_id")
    private Planeta planeta;

    // Nota: Dejamos fuera temporalmente 'planeta_origen_id' para explicar 
    // las relaciones @ManyToOne en la siguiente sesión práctica.

    // === REQUISITO MANDATORIO JPA: Constructor vacío (por defecto) ===
    public Nave() {
    }

    // Constructor parametrizado para facilitar las inserciones en los laboratorios
    public Nave(String nombre, String modelo, int capacidadPasajeros, String estadoSistema) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.estadoSistema = estadoSistema;
    }
       //Ponemos otro constructor en el cual ponemos el planeta
    public Nave(String nombre, String modelo, int capacidadPasajeros, String estadoSistema, Planeta planeta) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.estadoSistema = estadoSistema;
        this.planeta = planeta;
    }
    

    // === Métodos de acceso públicos (Getters y Setters) ===
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }

    public String getEstadoSistema() { return estadoSistema; }
    public void setEstadoSistema(String estadoSistema) { this.estadoSistema = estadoSistema; }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
    
    

    // Sobreescritura útil para las salidas por consola de NetBeans
    @Override
    public String toString() {
        return " [Nave Persistida] ID: " + id + " | " + nombre + " (" + modelo + ") - Estado: " + estadoSistema;
    }
}

    


