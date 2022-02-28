package com.school.entity;

import com.school.domain.RoleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private RoleType type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
