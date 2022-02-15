package com.calculadora.controller;

import com.calculadora.dto.Mensaje;
import com.calculadora.dto.ReportesCalculoHorasDto;
import org.apache.commons.lang3.StringUtils;
import com.calculadora.dto.ReporteSDto;
import com.calculadora.models.ReporteS;
import com.calculadora.service.ReportesSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/api/reporteS")
@CrossOrigin("*")
public class ReporteSController {
    @Autowired
    ReportesSService reportesSService;

    @GetMapping("/lista")
    public ResponseEntity<List<ReporteS>> list(){
        List<ReporteS> list = reportesSService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReporteSDto reporteSDto){
        //validacion para que no mande datos vacio
        if(StringUtils.isAllBlank(reporteSDto.getId_Tecnico()) || StringUtils.isAllBlank(reporteSDto.getId_Servicio()))
            return new ResponseEntity(new Mensaje("Todos los Campos son obligatorio"),HttpStatus.BAD_REQUEST);

        if(reporteSDto.getFecha_hora_inicio().after(reporteSDto.getFecha_hora_fin()))
            return new ResponseEntity(new Mensaje("La fecha de inicio debe ser menor a la fecha fin"),HttpStatus.BAD_REQUEST);

        ReporteS reporte = new ReporteS(reporteSDto.getId_Tecnico(), reporteSDto.getId_Servicio(), reporteSDto.getFecha_hora_inicio(), reporteSDto.getFecha_hora_fin());
        reportesSService.save(reporte);
        return new ResponseEntity(new Mensaje("Reporte almacenado con exito"), HttpStatus.OK);
    }


    @GetMapping("/detail/{id_Tecnico}/{dSemana}")
    public ResponseEntity<List<ReporteS>> horasTrabajo(@PathVariable("id_Tecnico") String id_Tecnico, @PathVariable("dSemana") int dSemana) throws ParseException {
        if(!reportesSService.existsById_Tecnico(id_Tecnico))
            return new ResponseEntity(new Mensaje("El id del tecnico no es valido"),HttpStatus.BAD_REQUEST);

//        if(!reportesSService.existsNumeroSemana(dSemana))
//            return new ResponseEntity(new Mensaje("No tiene registros para esa semana"),HttpStatus.BAD_REQUEST);

       List <ReporteS> reporteS = reportesSService.consultarHoras(id_Tecnico, dSemana);
       List<ReporteS>prueba2 = reporteS;



        int acumHoras = 0;
        int acumMinutos = 0;
        int acumSegundos = 0;
        int acumHorasDominicales = 0;
        int acumHorasDominicalesExtra = 0;
        int acumHorasNormales = 0;
        int acumHorasNocturnas = 0;
        int acumHorasNocturnasExtras = 0;
        int acumHorasNormalesExtras = 0;
        int HorasN = 0;


       for (ReporteS reporteS1 : prueba2){
//            System.out.println(reporteS1.getFecha_hora_inicio().toString());
            Timestamp fechaInicio1 = reporteS1.getFecha_hora_inicio();
            Timestamp fechaFin = reporteS1.getFecha_hora_fin();

            long l=fechaFin.getTime()-fechaInicio1.getTime();
            long day=l/(24*60*60*1000);
            long hour=(l/(60*60*1000)-day*24);
            acumHoras += hour;
            long min=((l/(60*1000))-day*24*60-hour*60);
            acumMinutos += min;
            long s=(l/1000-day*24*60*60-hour*60*60-min*60);
            acumSegundos += s;
//            System.out.println("horas totales" + ' '+ acumHoras  + ' ' + " minutos" +' '+  acumMinutos + ' ' + "segundos" + ' ' + acumSegundos);

            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.setTime(fechaInicio1);
            to.setTime(fechaFin);
            from.setTimeZone(TimeZone.getTimeZone("GMT"));
            to.setTimeZone(TimeZone.getTimeZone("GMT"));
            int hora = from.get(Calendar.HOUR_OF_DAY);
            int horaF = to.get(Calendar.HOUR_OF_DAY);

           if(from.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
               if ((hora >= 7 && horaF <= 20) && (hora<=20 && horaF >=7)  ) {
                   long hour4=(l/(60*60*1000)-day*24);
                   acumHorasNormales += hour4;
               }

               if ((hora >= 7 && horaF <= 20) && (hora<=20 && horaF >=7)  && acumHorasNormales > 48) {
                   long hour4 = (l / (60 * 60 * 1000) - day * 24);
                   acumHorasNormalesExtras = acumHorasNormales - 48;

               }

               if (hora >=20 && horaF <= 7){
                   long hour5=(l/(60*60*1000)-day*24);
                   System.out.println(hour5);
                   acumHorasNocturnas += hour5;
               }

               if (hora >=20 && horaF <= 7 && acumHorasNocturnas > 48){
                   long hour5=(l/(60*60*1000)-day*24);
                   acumHorasNocturnasExtras = acumHorasNocturnas - 48;

               }
           }

           if(from.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY  && acumHoras < 48){
               long hour2=(l/(60*60*1000)-day*24);
               acumHorasDominicales += hour2;

           }

           if(from.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && acumHoras > 48){
               long hour3=(l/(60*60*1000)-day*24);
               acumHorasDominicalesExtra += hour3;
           }
       }

       ReportesCalculoHorasDto reportesCalculoHorasDto = new ReportesCalculoHorasDto();
       reportesCalculoHorasDto.setHorasNormales(acumHorasNormales);
       reportesCalculoHorasDto.setHorasNocturnas(acumHorasNocturnas);
       reportesCalculoHorasDto.setHorasNocturnasExtras(acumHorasNocturnasExtras);
       reportesCalculoHorasDto.setHorasNormalesExtras(acumHorasNormalesExtras);
       reportesCalculoHorasDto.setHorasDominicales(acumHorasDominicales);
       reportesCalculoHorasDto.setHorasDominicalesExtras(acumHorasDominicalesExtra);

       List<ReportesCalculoHorasDto> list = new ArrayList<>();
       list.add(reportesCalculoHorasDto);


        return new ResponseEntity(list,HttpStatus.OK);
    }



}
