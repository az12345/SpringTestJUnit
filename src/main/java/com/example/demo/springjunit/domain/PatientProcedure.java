package com.example.demo.springjunit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="patient_procedure")
public class PatientProcedure implements Serializable {
    @Id
    @Column(name= "unique_id", unique = true, nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uniqueId;
    @Column(name="procedure_name")
    private String procedureName;
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name="md")
    private String md;
}
