package com.dh.fullstack.users.service.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author Julio Daviu
 */
@Entity
@Table(name = "account_table",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}
)
@ApiModel(description="All details about the account")
public class Account {

    //CTRL+ALT+L
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(notes = "The account id is generated for the Data Base")
    private Long id;

    @Column(name = "email", length = 100, nullable = false)
    @ApiModelProperty(notes = "The account email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", length = 20, nullable = false)
    @ApiModelProperty(notes = "The account state")
    private AccountState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }
}
