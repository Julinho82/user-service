package com.dh.fullstack.users.service.model.domain;


import javax.persistence.*;

@Entity
@Table(name = "account_table", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Account {
    @Id
    @Column(name = "accountid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", length = 20, nullable = false)
    private AccountState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
