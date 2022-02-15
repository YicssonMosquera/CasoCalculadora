package com.calculadora.service;

import com.calculadora.models.ReporteS;
import com.calculadora.repository.ReportesSRepository;
import com.calculadora.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportesSService {

    @Autowired
    ReportesSRepository reportesSRepository;

    public List<ReporteS> list(){
        return reportesSRepository.findAll();
    }

    public void save(ReporteS reporteS){
        reportesSRepository.save(reporteS);
    }

    public List<ReporteS> consultarHoras(String Id_Tecnico, int dSemana){
       String diasemana =  DateUtils.obtenerFechaPorNumeroSemana(dSemana);
        Timestamp fechaInicio = Timestamp.valueOf(diasemana.split("/")[0]);
        Timestamp fechafin = Timestamp.valueOf(diasemana.split("/")[1]);

       return reportesSRepository.consultarHorasPorsemanas(Id_Tecnico,fechaInicio,fechafin);
    }

    public boolean existsById_Tecnico(String Id_Tecnico) {
        return reportesSRepository.existsById_Tecnico(Id_Tecnico);
    }


}
