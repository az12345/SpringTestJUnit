package com.example.demo.springjunit.service.patientdesiase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.springjunit.domain.PatientDisease;
import com.example.demo.springjunit.repository.PatientDiseaseRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultPatientDiseaseService implements PatientDiseaseService {

    private final PatientDiseaseRepository patientDiseaseRepository;

    @Override
    public PatientDisease create(PatientDisease patientDisease) {
        return patientDiseaseRepository.save(patientDisease);
    }

    @Override
    public PatientDisease fetchById(Integer id) {
        return patientDiseaseRepository.findOne(id);
    }

    @Override
    public List<PatientDisease> fetchAll() {
        return (List<PatientDisease>) patientDiseaseRepository.findAll();
    }

    @Override
    public PatientDisease updateById(Integer id, Date startDate, Date endDate, String deseaseCode, String deseaseDescription) {
        final PatientDisease patientDiseaseUpdate = fetchById(id);
        patientDiseaseRepository.updateOneById(id,
                Objects.isNull(startDate) ? patientDiseaseUpdate.getStartDate() : startDate,
                Objects.isNull(endDate) ? patientDiseaseUpdate.getEndDate() : endDate,
                Objects.isNull(deseaseCode) ? patientDiseaseUpdate.getDeseaseCode() : deseaseCode,
                Objects.isNull(deseaseDescription) ? patientDiseaseUpdate.getDeseaseDescription() : deseaseDescription
        );
        return fetchById(id) ;
    }



    @Override
    public PatientDisease deleteById(Integer id) {
        PatientDisease patientDisease = fetchById(id);
        patientDiseaseRepository.delete(id);
        return patientDisease;
    }

    @Override
    public List<Date> findStartDateBetween(Date start, Date finish) {
        return patientDiseaseRepository.findStartDateBetween(start, finish);
    }

    @Override
    public List<Date> findFinishDateBetween(Date start, Date finish) {
        return patientDiseaseRepository.findEndDateBetween(start,finish);
    }


}
