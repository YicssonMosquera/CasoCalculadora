import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { NavigationComponent } from './navigation.component';

describe('NavigationComponent', () => {
  let component: NavigationComponent;
  let fixture: ComponentFixture<NavigationComponent>;
  let de: DebugElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavigationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationComponent);
    component = fixture.componentInstance;
    de = fixture.debugElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // it('renderizar lo que hay en la etique tittle', () =>{
  //   const tittle = de.query(By.css('h1'))


  //   //revisa los cambios del componente
  //   fixture.detectChanges();
  //   //como se prueba el valor esperado | toBe es una comparacion ===
  //   expect(tittle.nativeElement.innerText).toBe('probamos la prueba')

  //   // comparacion de objetos
  //   const objeto = {name: 'Daniel', lastName:'Gomez'};
  //   const objetoN2 = {name: 'Daniel', lastName:'Gomez'};
  //   expect(objeto).toEqual(objetoN2)
  //   //comparacion de booleam
  //   expect(true).toBeTrue()
  //   expect(true).toBeFalse()

  //   //spy para saber si se llamo un metodo desde otro
  //   const spyMethod = spyOn(component, 'cancelar')
  //   expect(spyMethod).toHaveBeenCalled;
  // })
});
