import { HttpClientModule } from '@angular/common/http';
import { DebugElement } from '@angular/core';
import { ComponentFixture, fakeAsync, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import {reporteMock } from 'src/app/shared/mocks/reporte.mock';
import { reporteServiceMock } from 'src/app/shared/mocks/reporteService.mock';
import { toastrMock } from 'src/app/shared/mocks/toastr.mock';
import { ReporteService } from '../../service/reporte/reporte.service'

import { ReporteServicioComponent } from './reporte-servicio.component';

fdescribe('ReporteServicioComponent', () => {
  let component: ReporteServicioComponent;
  let fixture: ComponentFixture<ReporteServicioComponent>;
  let de: DebugElement;
  const ReporteServiceMock = new reporteServiceMock();
  const ToastrMock = new toastrMock();

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ReporteServicioComponent],
      providers: [{ provide: ReporteService, useValue: ReporteServiceMock },
                  { provide:ToastrService, useValue:ToastrMock}
      ],
      imports: [HttpClientModule, ToastrModule.forRoot(),]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteServicioComponent);
    component = fixture.componentInstance;
    de = fixture.debugElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //encapsular todo lo que se requiere hacer
  //en este primer describe van las validaciones del formulario
  describe('Form validation', () => {
    //colocar la prueba especifica de cada control
    describe('Control "id_Tecnico"', () => {
      //it lo que viene siendo una prueba unitaria
      it('cuando este control está vacío, debería ser un control no válido - requerido', () => {
        ///Patron AAA
        const id_TecnicoControl = component.formReporteS.get('id_Tecnico');
        const emptyValue = '';

        // como actua el control o asignarle un valor
        id_TecnicoControl.setValue(emptyValue);

        //como ultimo esperar la espectativa de la prueba
        expect(id_TecnicoControl.errors.required).toBeTruthy();
        expect(id_TecnicoControl.valid).toBeFalse();
      })

      it('hacer la prueba con un valor exitoso', () => {
        const id_TecnicoControl = component.formReporteS.get('id_Tecnico');
        const validValue = '12345'

        // como actua el control o asignarle un valor
        id_TecnicoControl.setValue(validValue);

        //como ultimo esperar la espectativa de la prueba
        expect(id_TecnicoControl.errors).toBeNull();
        expect(id_TecnicoControl.valid).toBeTrue();

      })

    })

    describe('Control "id_Servicio"', () => {
      //it lo que viene siendo una prueba unitaria
      it('cuando este control está vacío, debería ser un control no válido - requerido', () => {
        ///Patron AAA
        const id_ServicioControl = component.formReporteS.get('id_Servicio');
        const emptyValue = '';

        // como actua el control o asignarle un valor
        id_ServicioControl.setValue(emptyValue);

        //como ultimo esperar la espectativa de la prueba
        expect(id_ServicioControl.errors.required).toBeTruthy();
        expect(id_ServicioControl.valid).toBeFalse();
      })

      it('hacer la prueba con un valor exitoso', () => {
        const id_ServicioControl = component.formReporteS.get('id_Servicio');
        const validValue = '123465'

        // como actua el control o asignarle un valor
        id_ServicioControl.setValue(validValue);

        //como ultimo esperar la espectativa de la prueba
        expect(id_ServicioControl.errors).toBeNull();
        expect(id_ServicioControl.valid).toBeTrue();

      })

    })

    describe('Control "fecha_hora_fin"', () => {
      //it lo que viene siendo una prueba unitaria
      it('cuando este control está vacío, debería ser un control no válido - requerido', () => {
        ///Patron AAA
        const fecha_hora_finControl = component.formReporteS.get('fecha_hora_fin');
        const emptyValue = '';

        // como actua el control o asignarle un valor
        fecha_hora_finControl.setValue(emptyValue);

        //como ultimo esperar la espectativa de la prueba
        expect(fecha_hora_finControl.errors.required).toBeTruthy();
        expect(fecha_hora_finControl.valid).toBeFalse();
      })
    })

    describe('Control "fecha_hora_inicio"', () => {
      //it lo que viene siendo una prueba unitaria
      it('cuando este control está vacío, debería ser un control no válido - requerido', () => {
        ///Patron AAA
        const fecha_hora_inicioControl = component.formReporteS.get('fecha_hora_inicio');
        const emptyValue = '';

        // como actua el control o asignarle un valor
        fecha_hora_inicioControl.setValue(emptyValue);

        //como ultimo esperar la espectativa de la prueba
        expect(fecha_hora_inicioControl.errors.required).toBeTruthy();
        expect(fecha_hora_inicioControl.valid).toBeFalse();
      })
    })
  })

  describe('[method guardarReporte]', ()=>{
    it('probando cuando guarda exitoso', fakeAsync(()=>{
      //los tres punto son el estructure para tener en cuenta al momento de hacer los test
        const reporteValidMock = {...reporteMock};
        component.formReporteS.setValue(reporteValidMock);

        const spyToasr = ToastrMock.success;
        const spySave = ReporteServiceMock.save
        const textAlert = 'Reporte almacenado con exito'

        component.guardarReporte()

        expect(spyToasr).toHaveBeenCalled
        expect(spySave).toHaveBeenCalledOnceWith(component.formReporteS.value)

    }))

    // it('probando cuando guarda con errores', fakeAsync(()=>{
    //   //los tres punto son el estructure para tener en cuenta al momento de hacer los test
    //     const reporteValidMock = {...reporteMock};
    //     component.formReporteS.setValue(reporteValidMock);

    //     const spyToasr = ToastrMock.success;
    //     ReporteServiceMock.save.and.returnValue(throwError('Fail'))
    //     const textAlert = 'Reporte almacenado con exito'

    //     component.guardarReporte()

    //     expect(spyToasr).toHaveBeenCalled
    //     expect(ReporteServiceMock.save).toHaveBeenCalledOnceWith(component.formReporteS.value)

    // }))

  })

  describe('[method cancelar]', () => {
    it('Validando que el metodo funcione correcto', () => {
      const spyRestestForm = spyOn(component.formReporteS, 'reset');

      component.cancelar();
      expect(spyRestestForm).toHaveBeenCalled();

    })


  })



});
