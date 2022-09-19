package com.yil.education.model;

import com.yil.education.base.IEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@Table(schema = "PRS", name = "EDUCATION")
@NoArgsConstructor
@AllArgsConstructor
public class Education implements IEntity {
    @Id
    @SequenceGenerator(name = "EDUCATION_SEQUENCE_GENERATOR",
            schema = "PRS",
            sequenceName = "SEQ_EDUCATION_ID",
            allocationSize = 1)
    @GeneratedValue(generator = "EDUCATION_SEQUENCE_GENERATOR")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 1000)
    private String name;
    @Column(name = "INSTITUTION_CODE")
    private Integer institutionCode;
    @ColumnDefault(value = "true")
    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;
    @Column(name = "EDUCATION_TYPE_ID")
    private Integer educationTypeId;
    @Column(name = "EDUCATION_ID")
    private Long educationId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_USER_ID")
    private Long createdUserId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFY_DATE")
    private Date lastModifyDate;
    @Column(name = "LAST_MODIFY_USER_ID")
    private Long lastModifyUserId;
}
