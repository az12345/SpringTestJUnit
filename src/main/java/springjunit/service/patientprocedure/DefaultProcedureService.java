package springjunit.service.patientprocedure;


import com.instinctools.padlaboris.domain.PatientProcedure;
import com.instinctools.padlaboris.repository.PatientProcedueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultProcedureService implements PatientPocedureService {
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
                Objects.isNull(patientProcedure.getMD()) ? saveProcedure.getMD() : patientProcedure.getMD()
                );
        return patientProcedure ;
    }

    @Override
    public PatientProcedure deleteById(Integer id) {
        PatientProcedure patientProcedure = fetchById(id);
        patientProcedueRepository.delete(id);
        return patientProcedure;

    }
}
