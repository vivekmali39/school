package com.school.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends Staff {

    @ElementCollection
    @CollectionTable(name = "teacher_subjects", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "teacher_subjects")
    private List<String> subjects;

    @ElementCollection
    @CollectionTable(name = "teacher_sections", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "teacher_sections")
    private List<String> sections;

    private String qualification;

}
