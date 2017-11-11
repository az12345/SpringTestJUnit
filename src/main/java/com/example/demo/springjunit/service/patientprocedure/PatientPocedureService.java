package com.example.demo.springjunit.service.patientprocedure;


import com.example.demo.springjunit.domain.PatientProcedure;

import java.util.Date;
import java.util.List;
/**
 * PatientProcedure service
 */
public interface PatientPocedureService {
    /**
     * Create PatientProcedure due {@link PatientProcedure} entity.
     *
     * @param patientProcedure a {@link PatientProcedure} entity
     * @return created entity
     */
    PatientProcedure create(PatientProcedure patientProcedure);

    /**
     * Fetch {@link PatientProcedure} entity by id.
     *
     * @param id a {@link Integer} unique_id
     * @return {@link PatientProcedure} entity by id
     */
    PatientProcedure fetchById(Integer id);

    /**
     * Fetch all {@link PatientProcedure} entities.
     *
     * @return {@link PatientProcedure} collection
     */
    List<PatientProcedure> fetchAll();

    /**
     * Update {@link PatientProcedure} entity by id.
     *
     * @param id   a {@link Integer} id
     * @param patientProcedure {@link PatientProcedure} patient procedure
     */
    PatientProcedure updateById(Integer id, PatientProcedure patientProcedure);

    /**
     * Delete {@link PatientProcedure} entity by id.
     *
     * @param id a {@link Integer} id
     * @return deleted {@link PatientProcedure} entity
     */
    PatientProcedure deleteById(Integer id);

    /**
     *   List<PatientProcedure> getPatientProcedureByDateAfter(Date date) return List patientProcedure after date
     *
     * @param date a {@link Date} date
     */
    List<PatientProcedure> getPatientProcedureByDateAfter(Date date);


}
