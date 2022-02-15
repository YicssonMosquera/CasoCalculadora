import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



import { ToastrModule } from 'ngx-toastr';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { ReporteServicioComponent } from './components/reporte-servicio/reporte-servicio.component';
import { HorasTrabajoComponent } from './components/horas-trabajo/horas-trabajo.component';
import { ReporteService } from './service/reporte/reporte.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    ReporteServicioComponent,
    HorasTrabajoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
  ],
  providers: [ReporteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
