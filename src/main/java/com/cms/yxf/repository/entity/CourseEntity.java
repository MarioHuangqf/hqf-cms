package com.cms.yxf.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private String score;

    @ManyToMany(mappedBy = "courseEntities")
    private List<UserEntity> userEntities = new ArrayList<>();
}
