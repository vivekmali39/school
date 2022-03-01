package com.school.entity;

import com.school.domain.Gender;
import com.school.domain.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "School_User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private Boolean active;

    private String name;

    private Gender gender;

    private LocalDate dateOfBirth;

    @ElementCollection
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "user_roles")
    private List<Role> roles;

}
