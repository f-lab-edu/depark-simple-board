package com.example.simpleboard.entity;

import com.example.simpleboard.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MEMBER")
@NoArgsConstructor
@Getter
@Setter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Builder
    public Member(Long memberId, String name, String password, String email) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
