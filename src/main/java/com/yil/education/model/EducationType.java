package com.yil.education.model;

import com.yil.education.base.IEntity;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Entity
@Data
@Table(name = "EDUCATION_TYPE", schema = "PRS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationType implements IEntity {
    @Id
    @SequenceGenerator(name = "EDUCATION_TYPE_SEQUENCE_GENERATOR",
            schema = "PRS",
            sequenceName = "SEQ_EDUCATION_TYPE_ID")
    @GeneratedValue(generator = "EDUCATION_TYPE_SEQUENCE_GENERATOR")
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
}
