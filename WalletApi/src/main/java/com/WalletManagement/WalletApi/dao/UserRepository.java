package com.WalletManagement.WalletApi.dao;

import com.WalletManagement.WalletApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
