package springjunit.service.patientdesiase;

import com.instinctools.padlaboris.domain.PatientDisease;
import com.instinctools.padlaboris.repository.PatientDiseaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultPatientDesiaseService implements PatientDesiaseService{

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
        final PatientDisease patientDisease = fetchById(id);
        patientDiseaseRepository.updateOneById(id,
                Objects.isNull(patientDisease.getStartDate()) ? patientDisease.getStartDate() : patientDisease.getStartDate(),
                Objects.isNull(patientDisease.getEndDate()) ? patientDisease.getEndDate() : patientDisease.getEndDate(),
                Objects.isNull(patientDisease.getDeseaseCode()) ? patientDisease.getDeseaseCode() : patientDisease.getDeseaseCode(),
                Objects.isNull(patientDisease.getDeseaseDescription()) ? patientDisease.getDeseaseDescription() : patientDisease.getDeseaseDescription()
        );
        return patientDisease ;
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
