import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { ReporteService } from 'src/app/service/reporte/reporte.service';
import { reporteServiceMock } from 'src/app/shared/mocks/reporteService.mock';
import { toastrMock } from 'src/app/shared/mocks/toastr.mock';

import { HorasTrabajoComponent } from './horas-trabajo.component';

describe('HorasTrabajoComponent', () => {
  let component: HorasTrabajoComponent;
  let fixture: ComponentFixture<HorasTrabajoComponent>;
  const ReporteServiceMock = new reporteServiceMock();
  const ToastrMock = new toastrMock();

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HorasTrabajoComponent ],
      providers: [{ provide: ReporteService, useValue: ReporteServiceMock },
        { provide:ToastrService, useValue:ToastrMock}
      ],
    imports: [HttpClientModule, ToastrModule.forRoot(),]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HorasTrabajoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
