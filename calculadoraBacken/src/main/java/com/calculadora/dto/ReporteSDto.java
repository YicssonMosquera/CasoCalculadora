package com.calculadora.dto;


import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

public class ReporteSDto {
    @NotBlank
    private String Id_Tecnico;
    @NotBlank
    private String Id_Servicio;
    @NotBlank
    private Timestamp fecha_hora_inicio;
    @NotBlank
    private Timestamp fecha_hora_fin;

    public ReporteSDto() {
    }

    public ReporteSDto(@NotBlank String id_Tecnico, @NotBlank String id_Servicio, @NotBlank Timestamp fecha_hora_inicio, @NotBlank Timestamp fecha_hora_fin) {
        Id_Tecnico = id_Tecnico;
        Id_Servicio = id_Servicio;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
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
