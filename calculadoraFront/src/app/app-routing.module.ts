import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HorasTrabajoComponent } from './components/horas-trabajo/horas-trabajo.component';
import { ReporteServicioComponent } from './components/reporte-servicio/reporte-servicio.component';

const routes: Routes = [
  { path: 'reporteS', pathMatch:'full', component: ReporteServicioComponent},
  { path: 'horasT', component: HorasTrabajoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
