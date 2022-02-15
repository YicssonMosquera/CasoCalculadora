import { HttpClientTestingModule, HttpTestingController, TestRequest } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import keys from '../../../keys'


import { ReporteService } from './reporte.service';

describe('ReporteService', () => {
  let service: ReporteService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[]
    });
    service = TestBed.inject(ReporteService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  afterEach(() =>{
    httpMock.verify();
  })

  //simulacion de una prueba unitaria para un metodo get
  describe('[method getAll]', ()=>{
    it('test metodo getAll', ()=> {
      //crear um mock para que nos retorne la lista del objeto en especifico
      const reportesMock = [{id:1, id_Tecnico:'123',id_Servicio:"12345", fecha_hora_inicio:"", fecha_hora_fin:"" },
                            {id:1, id_Tecnico:'12345',id_Servicio:"12345678", fecha_hora_inicio:"", fecha_hora_fin:"" }];

        const API_URI = keys.api.API_URI + '/reporteS/lista';
        const mehtod = 'GET';

        service.getAllreporte().subscribe(resportes=>{
          expect(resportes).toEqual(reportesMock)
        }) 
        
        const req: TestRequest = httpMock.expectOne(API_URI)
        expect(req.request.method).toBe(mehtod);
        req.flush(reportesMock)
        httpMock.verify();
    })
  })

  describe('[method Save]', () => {
    it('test metodo post', () =>{
      const reportesMock = {id:1, id_Tecnico:'123',id_Servicio:"12345", fecha_hora_inicio:"", fecha_hora_fin:"" };
      const API_URI = keys.api.API_URI + '/reporteS/create';
      const mehtod = 'POST';

      service.save(reportesMock).subscribe(res=>{
        expect(res).toEqual(reportesMock);
      })

      const req: TestRequest = httpMock.expectOne(API_URI)
      expect(req.request.method).toBe(mehtod);
      expect(req.request.body).toEqual(reportesMock);
      req.flush(reportesMock)
    })
  })
});
