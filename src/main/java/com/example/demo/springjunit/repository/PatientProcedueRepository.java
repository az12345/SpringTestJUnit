package com.example.demo.springjunit.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.springjunit.domain.PatientProcedure;

import java.util.Date;
import java.util.List;

public interface PatientProcedueRepository extends CrudRepository<PatientProcedure, Integer> {
    @Query("SELECT p from PatientProcedure p where ?1 < date  ORDER BY date DESC")
    List<PatientProcedure> getPatientProcedureByDateAfter(Date date);

    @Modifying
    @Transactional
    @Query(value = "UPDATE patient_procedure SET " +
            "unique_id = COALESCE(?1, unique_id), " +
            "procedure_name = COALESCE(?2, procedure_name), " +
            "date = COALESCE(?3, date), " +
            "md = COALESCE(?4, md) " +
            "WHERE unique_id = ?1", nativeQuery = true)
    void updateOneById(Integer uniqueId, String procedureName, Date date, String md);
}
