import { of } from "rxjs";

export class toastrMock{
    success = jasmine.createSpy('toastr').and.returnValue(of())
}