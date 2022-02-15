package com.calculadora.controller;

import com.calculadora.models.ReporteS;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReporteSControllerTest {

    private ObjectMapper objectMapper;

    @Autowired
    private WebTestClient client;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSave() {
        ReporteS reporteS = new ReporteS("12345", "1234567", java.sql.Timestamp.valueOf("2022-10-01 07:30:14.332"), java.sql.Timestamp.valueOf("2022-10-01 15:30:14.332"));

        client.post().uri("api/reporteS/create").contentType(MediaType.APPLICATION_JSON)
                .bodyValue(reporteS).exchange()

                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)

                .expectBody()
                .jsonPath("$.mensaje").isEqualTo("Reporte almacenado con exito");

    }


}