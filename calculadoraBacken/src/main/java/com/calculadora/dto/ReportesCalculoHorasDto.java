package com.calculadora.dto;

public class ReportesCalculoHorasDto {
   private Integer horasNormales;
   private Integer horasNocturnas;
   private Integer horasDominicales;
   private Integer horasDominicalesExtras;
   private Integer horasNocturnasExtras;
   private Integer horasNormalesExtras;

    public ReportesCalculoHorasDto() {
    }

    public ReportesCalculoHorasDto(Integer horasNormales, Integer horasNocturnas, Integer horasDominicales, Integer horasDominicalesExtras, Integer horasNocturnasExtras, Integer horasNormalesExtras) {
        this.horasNormales = horasNormales;
        this.horasNocturnas = horasNocturnas;
        this.horasDominicales = horasDominicales;
        this.horasDominicalesExtras = horasDominicalesExtras;
        this.horasNocturnasExtras = horasNocturnasExtras;
        this.horasNormalesExtras = horasNormalesExtras;
    }

    public Integer getHorasNormales() {
        return horasNormales;
    }

    public void setHorasNormales(Integer horasNormales) {
        this.horasNormales = horasNormales;
    }

    public Integer getHorasNocturnas() {
        return horasNocturnas;
    }

    public void setHorasNocturnas(Integer horasNocturnas) {
        this.horasNocturnas = horasNocturnas;
    }

    public Integer getHorasDominicales() {
        return horasDominicales;
    }

    public void setHorasDominicales(Integer horasDominicales) {
        this.horasDominicales = horasDominicales;
    }

    public Integer getHorasDominicalesExtras() {
        return horasDominicalesExtras;
    }

    public void setHorasDominicalesExtras(Integer horasDominicalesExtras) {
        this.horasDominicalesExtras = horasDominicalesExtras;
    }

    public Integer getHorasNocturnasExtras() {
        return horasNocturnasExtras;
    }

    public void setHorasNocturnasExtras(Integer horasNocturnasExtras) {
        this.horasNocturnasExtras = horasNocturnasExtras;
    }

    public Integer getHorasNormalesExtras() {
        return horasNormalesExtras;
    }

    public void setHorasNormalesExtras(Integer horasNormalesExtras) {
        this.horasNormalesExtras = horasNormalesExtras;
    }
}
