import { of } from "rxjs";

export class reporteServiceMock {
    save = jasmine.createSpy('reporteService.save').and.returnValue(of())
}