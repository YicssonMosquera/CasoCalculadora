package com.calculadora;

import com.calculadora.models.ReporteS;
import com.calculadora.repository.ReportesSRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CalculadoraBackenApplicationTests {

	public static final ReporteS inser1 = new ReporteS("1038", "20211", java.sql.Timestamp.valueOf("2021-10-01 07:30:14.332"), java.sql.Timestamp.valueOf("2021-10-01 15:30:14.332"));

	ReportesSRepository reportesSRepository;

	@BeforeEach
	void setUp() {
		reportesSRepository = mock(ReportesSRepository.class);
	}

	@Test
	void testSave() {
		ReporteS reporteS1 = new ReporteS("12345", "1234567", java.sql.Timestamp.valueOf("2022-10-01 07:30:14.332"), java.sql.Timestamp.valueOf("2022-10-01 15:30:14.332"));
		when(reportesSRepository.save(any())).then(invocation -> {
			ReporteS r = invocation.getArgument(0);
			return r;
		});
		ReporteS reporteS  = reportesSRepository.save(reporteS1);
		assertEquals("12345", reporteS.getId_Tecnico());
		assertEquals("1234567",reporteS.getId_Servicio());

	}

	@Test
	void testFindAll(){
		List<ReporteS> datos =  Arrays.asList(inser1);
		when(reportesSRepository.findAll()).thenReturn(datos);

		List<ReporteS> reporteS = reportesSRepository.findAll();
		assertEquals(1, reporteS.size());
		assertTrue(reporteS.contains(inser1));
	}

}
