package com.example.demo.springjunit.service.patientdesiase;


import com.example.demo.springjunit.domain.PatientDisease;
import com.example.demo.springjunit.domain.PatientProcedure;

import java.util.Date;
import java.util.List;

/**
 * PatientDesiase service
 */
public interface PatientDiseaseService {

    /**
     * Create PatientDisease due {@link PatientDisease} entity.
     *
     * @param patientDisease a {@link PatientDisease} entity
     * @return created entity
     */
    PatientDisease create(PatientDisease patientDisease);

    /**
     * Fetch {@link PatientDisease} entity by id.
     *
     * @param id a {@link Integer} unique_id
     * @return {@link PatientDisease} entity by id
     */
    PatientDisease fetchById(Integer id);

    /**
     * Fetch all {@link PatientDisease} entities.
     *
     * @return {@link PatientDisease} collection
     */
    List<PatientDisease> fetchAll();

    /**
     * Update {@link PatientDisease} entity by id.
     *
     * @param id   a {@link Integer} id
     * @param startDate a {@link PatientDisease} start date
     * @param endDate {@link PatientDisease} end date
     * @param deseaseCode {@link PatientDisease} desease Description
     * @param deseaseDescription {@link PatientDisease} desease Description
     */
    PatientDisease updateById(Integer id, Date startDate, Date endDate, String deseaseCode, String deseaseDescription);

    /**
     * Delete {@link PatientDisease} entity by id.
     *
     * @param id a {@link Integer} id
     * @return deleted {@link PatientDisease} entity
     */
    PatientDisease deleteById(Integer id);

    /**
     * Fetch List<Date> findStartDateBetween(Date start, Date finish)  start date between two dates
     *
     * @param start a {@link Date} date
     * @return finish {@link Date} date
     */
    List<Date> findStartDateBetween(Date start, Date finish);
    /**
     * Fetch List<Date> findStartDateBetween(Date start, Date finish)  finish date between two dates
     *
     * @param start a {@link Date} date
     * @return finish {@link Date} date
     */
    List<Date> findFinishDateBetween(Date start, Date finish);


}
