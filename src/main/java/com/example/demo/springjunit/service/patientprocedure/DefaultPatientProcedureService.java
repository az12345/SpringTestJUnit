package com.example.demo.springjunit.service.patientprocedure;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.springjunit.domain.PatientProcedure;
import com.example.demo.springjunit.repository.PatientProcedueRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultPatientProcedureService implements PatientPocedureService {
    private final PatientProcedueRepository patientProcedueRepository;
    @Override
    public PatientProcedure create(PatientProcedure patientProcedure) {
        return patientProcedueRepository.save(patientProcedure);
    }

    @Override
    public PatientProcedure fetchById(Integer id) {
        return patientProcedueRepository.findOne(id);
    }

    @Override
    public List<PatientProcedure> fetchAll() {
        return (List<PatientProcedure>) patientProcedueRepository.findAll();
    }

    @Override
    public PatientProcedure updateById(Integer id, PatientProcedure patientProcedure) {
        final PatientProcedure saveProcedure = fetchById(id);
       patientProcedueRepository.updateOneById(id,
                Objects.isNull(patientProcedure.getProcedureName()) ? saveProcedure.getProcedureName() : patientProcedure.getProcedureName(),
                Objects.isNull(patientProcedure.getDate()) ? saveProcedure.getDate() : patientProcedure.getDate(),
                Objects.isNull(patientProcedure.getMd()) ? saveProcedure.getMd() : patientProcedure.getMd()
                );
        return fetchById(id) ;
    }

    @Override
    public PatientProcedure deleteById(Integer id) {
        PatientProcedure patientProcedure = fetchById(id);
        patientProcedueRepository.delete(id);
        return patientProcedure;
    }

    @Override
    public List<PatientProcedure> getPatientProcedureByDateAfter(Date date) {
        return patientProcedueRepository.getPatientProcedureByDateAfter(date);
    }
}
