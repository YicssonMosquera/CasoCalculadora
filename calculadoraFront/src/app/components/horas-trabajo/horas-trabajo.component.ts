import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ReporteService } from 'src/app/service/reporte/reporte.service';

@Component({
  selector: 'app-horas-trabajo',
  templateUrl: './horas-trabajo.component.html',
  styleUrls: ['./horas-trabajo.component.css']
})
export class HorasTrabajoComponent implements OnInit {

  id_Tecnico = '';
  dSemana = '';
  reporte
  reporte2 = [];

  constructor(private reporteService: ReporteService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  consultarHoras() {
    
    console.log(this.id_Tecnico,  this.dSemana)
    this.reporteService.getCalculoHoras(this.id_Tecnico, this.dSemana).subscribe(res => {
      this.reporte = res;
      this.reporte2.push(this.reporte)
      
    },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000, positionClass: 'toast-top-center'
        })
      })
  }

}
