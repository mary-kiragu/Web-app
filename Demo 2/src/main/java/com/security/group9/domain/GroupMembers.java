package com.security.group9.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_group9")
@NoArgsConstructor
public class GroupMembers {

    public GroupMembers(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;
}
