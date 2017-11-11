package com.example.demo.springjunit.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.springjunit.domain.PatientDisease;

import java.util.Date;
import java.util.List;

public interface PatientDiseaseRepository extends CrudRepository<PatientDisease, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM patient_disease WHERE start_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Date> findStartDateBetween(Date start, Date finish);
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM patient_disease WHERE end_Date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Date> findEndDateBetween(Date start, Date finish);
    @Modifying
    @Transactional
    @Query(value = "UPDATE patient_disease SET " +
            "start_date = ?2, " +
            "end_date = ?3, " +
            "desease_code = COALESCE(?4, desease_code), " +
            "desease_description = COALESCE(?5, desease_description) " +
            "WHERE unique_id = ?1", nativeQuery = true)
    void updateOneById(Integer uniqueId, Date startDate, Date endDate, String deseaseCode, String deseaseDescription);

}
