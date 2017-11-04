package springjunit.repository;

import com.instinctools.padlaboris.domain.PatientProcedure;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PatientProcedueRepository extends CrudRepository<PatientProcedure, Integer> {
    @Query("SELECT p from PatientProcedure p where ?1 < date  ORDER BY  DESC")
    List<PatientProcedure> getPatientProcedureByDateAfter(Date date);

    @Modifying
    @Transactional
    @Query(value = "UPDATE patient_procedure SET " +
            "uniqueId = COALESCE(?1, uniqueId), " +
            "procedureName = COALESCE(?1, procedureName), " +
            "author = COALESCE(?3, author), " +
            "date = COALESCE(?4, date), " +
            "md = COALESCE(CAST(?5 md), " +
            "WHERE id = ?1", nativeQuery = true)
    void updateOneById(Integer id, String procedureName, Date date, String MD);
}
