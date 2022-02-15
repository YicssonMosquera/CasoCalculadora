import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import keys from '../../../keys'
import { ReporteS } from 'src/app/models/reporte';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {
  API_URI = keys.api.API_URI + '/reporteS';
  constructor(private http: HttpClient) { }

  save(reporteS:ReporteS){
    return this.http.post(`${this.API_URI}/create`, reporteS)
  }

  getAllreporte():Observable<ReporteS[]>{
    return this.http.get<ReporteS[]>(`${this.API_URI}/lista`)
  }

  getCalculoHoras(id_Tecnico, dSemana){
    return this.http.get(`${this.API_URI}/detail/${id_Tecnico}/${dSemana}`)

  }
}
