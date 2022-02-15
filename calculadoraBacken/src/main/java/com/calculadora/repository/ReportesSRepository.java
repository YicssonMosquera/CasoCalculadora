package com.calculadora.repository;

import com.calculadora.models.ReporteS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportesSRepository extends JpaRepository<ReporteS, Long> {
    @Query(value = "select * from ReporteS r where (r.fecha_hora_inicio  BETWEEN :fecha_hora_inicio AND :fecha_hora_fin) and (r.fecha_hora_fin BETWEEN :fecha_hora_inicio AND :fecha_hora_fin) and r.id_Tecnico = :id_Tecnico", nativeQuery = true)
    List<ReporteS> consultarHorasPorsemanas(@Param("id_Tecnico") String id_Tecnico, @Param("fecha_hora_inicio") Timestamp fecha_hora_inicio, @Param("fecha_hora_fin") Timestamp fecha_hora_fin);

    @Query("select case when count(r)> 0 then true else false end from ReporteS r where lower(r.Id_Tecnico) like lower(:Id_Tecnico)")
    boolean existsById_Tecnico(@Param("Id_Tecnico") String Id_Tecnico);

//    @Query(value = "select case when count(*)> 0 then true else false end from ReporteS r where (r.fecha_hora_inicio  BETWEEN :fecha_hora_inicio AND :fecha_hora_fin) and (r.fecha_hora_fin BETWEEN :fecha_hora_inicio AND :fecha_hora_fin)",nativeQuery = true)
//    boolean existsByNumeroSemana(@Param("fecha_hora_inicio") Timestamp fecha_hora_inicio, @Param("fecha_hora_fin") Timestamp fecha_hora_fin);
}
