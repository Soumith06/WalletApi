package com.WalletManagement.WalletApi.model;



import com.WalletManagement.WalletApi.utils.enums.WalletStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name= "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String password;
    private String name;
    private String mobileNumber;
    private String email;
    private WalletStatus active;

    public User() {
    }

    public User(Long userId, String userName, String password, String name, String mobileNumber, String email, WalletStatus active) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.active = active;
    }
}
