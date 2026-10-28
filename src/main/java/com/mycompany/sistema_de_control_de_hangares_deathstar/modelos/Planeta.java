/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_control_de_hangares_deathstar.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jfabr
 */
@Entity
@Table(name="Planetas")
public class Planeta implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="planeta_id")
    private int id;
    
    @Column(name="nombre_planeta")
    private String nombrePlaneta;
    
    @Column(name="sector_galactico")
    private String sectorGalactico;
    
    //Esto sirve para la relaccion entre las dos tablas  para la FK
    // El mappendBy sirve para saber a que atributo tiene que apuntar 
    @OneToMany(mappedBy = "planeta", cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Nave> naves =new ArrayList();

    public Planeta() {
    }

    public Planeta(String nombrePlaneta, String sectorGalactico) {
        this.nombrePlaneta = nombrePlaneta;
        this.sectorGalactico = sectorGalactico;
    }
  
    public void agregarNave(Nave nave)
    {
        this.naves.add(nave);
        nave.setPlaneta(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    public String getSectorGalactico() {
        return sectorGalactico;
    }

    public void setSectorGalactico(String sectorGalactico) {
        this.sectorGalactico = sectorGalactico;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    @Override
    public String toString() {
        return "Planeta{" + "id=" + id + ", nombrePlaneta=" + nombrePlaneta + ", sectorGalactico=" + sectorGalactico + ", naves=" + naves + '}';
    }
    
    
    
    
    
    
    

    
}
