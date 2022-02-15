import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {ReporteService} from '../../service/reporte/reporte.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-reporte-servicio',
  templateUrl: './reporte-servicio.component.html',
  styleUrls: ['./reporte-servicio.component.css']
})
export class ReporteServicioComponent implements OnInit {
  formReporteS:FormGroup;

  constructor(private reporteService:ReporteService, private toastr:ToastrService) {
    this.formReporteS = new FormGroup({
      id: new FormControl(''),
      id_Tecnico: new FormControl('',[Validators.required]),
      id_Servicio: new FormControl('',[Validators.required]),
      fecha_hora_fin: new FormControl('',[Validators.required]),
      fecha_hora_inicio: new FormControl('',[Validators.required]),
    })
   }

  ngOnInit(): void {
  }

  guardarReporte(){
    console.log(this.formReporteS.value)
    this.reporteService.save(this.formReporteS.value).subscribe(res=>{
      this.toastr.success('Reporte almacenado con exito','Ok',{
        timeOut:3000, positionClass: 'toast-top-center'
      })
    },
      err=>{
        this.toastr.error(err.error.mensaje, 'Fail',{
          timeOut:3000,positionClass: 'toast-top-center'
        })
      })
  }

  cancelar(){
    this.formReporteS.reset();
  }

}
