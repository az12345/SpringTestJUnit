package springjunit.repository;

import com.instinctools.padlaboris.domain.PatientDisease;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientDiseaseRepository extends CrudRepository<PatientDisease, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM patient_disease WHERE startDate BETWEEN 1? AND 2?", nativeQuery = true)
    List<Date> findStartDateBetween(Date start, Date finish);
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM patient_disease WHERE endDate BETWEEN 1? AND 2?", nativeQuery = true)
    List<Date> findEndDateBetween(Date start, Date finish);
    @Modifying
    @Transactional
    @Query(value = "UPDATE post SET " +
            "startDate = COALESCE(?2, date ), " +
            "endDate = COALESCE(?3, date ), " +
            "deseaseCode = COALESCE(?4, deseaseCode), " +
            "deseaseDescription = COALESCE(CAST(?5 AS TEXT), deseaseDescription) " +
            "WHERE id = ?1", nativeQuery = true)
    void updateOneById(Integer uniqueId, Date startDate, Date endDate, String deseaseCode, String deseaseDescription);

}
