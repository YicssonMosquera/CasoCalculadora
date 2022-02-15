/// <reference types="cypress" />

import Chance from "chance";
const chance = new Chance();

describe('CalculadoraFront creando nuevo servicio', ()=>{
    beforeEach( () =>{
        cy.visit('http://localhost:4200/reporteS')
    })
    
    it('has a tittle', () =>{
    
        cy.contains('Registrar nuevo reporte de servicio')
        expect(2).to.equal(2)
    })
    
    it('Formulario', () =>{
    
        cy.get('input[name=id_Tecnico]').type('12345');
        cy.get('input[name=id_Servicio]').type('12345');
        cy.get('input[name=fecha_hora_inicio]').type('2022-02-12T11:09');
        cy.get('input[name=fecha_hora_fin]').type('2022-02-11T13:09');
        cy.contains('Guardar').click();
        cy.contains('Nuevo').click();
    })
})

