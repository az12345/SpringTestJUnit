package springjunit.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "patient_disease")
public class PatientDisease implements Serializable {
    @Id
    @Column(name = "unique_id", unique = true, nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uniqueId;
    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name="desease_code", length = 32)
    private String deseaseCode;
    @Column(name="desease_description", length = 132)
    private String deseaseDescription;

}
