/// <reference types="cypress" />

import Chance from "chance";
const chance = new Chance();

describe('CalculadoraFront Consulta de horas trabajadas', () => {

    beforeEach(() => {
        cy.visit('http://localhost:4200/horasT')
    })

    it('has a tittle', () => {
        cy.contains('Consulta de horas trabajadas por semana')
        expect(2).to.equal(2)
    })

    it('parametros', () => {
        cy.get('input[name=id_Tecnico]').type('1028');
        cy.get('input[name=dSemana]').type('1');
        cy.contains('Buscar').click();

    })
})
