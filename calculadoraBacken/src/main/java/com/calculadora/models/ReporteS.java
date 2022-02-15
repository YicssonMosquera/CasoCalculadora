package com.calculadora.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class ReporteS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String Id_Tecnico;
    @NotNull
    private String Id_Servicio;
    @NotNull
    private Timestamp fecha_hora_inicio;
    @NotNull
    private Timestamp fecha_hora_fin;

    public ReporteS() {
    }

    public ReporteS(String id_Tecnico, String id_Servicio, Timestamp fecha_hora_inicio, Timestamp fecha_hora_fin) {
        Id_Tecnico = id_Tecnico;
        Id_Servicio = id_Servicio;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_Tecnico() {
        return Id_Tecnico;
    }

    public void setId_Tecnico(String id_Tecnico) {
        Id_Tecnico = id_Tecnico;
    }

    public String getId_Servicio() {
        return Id_Servicio;
    }

    public void setId_Servicio(String id_Servicio) {
        Id_Servicio = id_Servicio;
    }

    public Timestamp getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public void setFecha_hora_inicio(Timestamp fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public Timestamp getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public void setFecha_hora_fin(Timestamp fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }
}
