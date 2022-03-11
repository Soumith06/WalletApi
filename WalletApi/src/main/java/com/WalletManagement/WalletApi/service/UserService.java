package com.WalletManagement.WalletApi.service;

import com.WalletManagement.WalletApi.dao.UserRepository;
import com.WalletManagement.WalletApi.model.User;
import com.WalletManagement.WalletApi.utils.enums.WalletStatus;
import com.WalletManagement.WalletApi.utils.exceptions.AlreadyExistsException;
import com.WalletManagement.WalletApi.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(User user){
        List<User> usersList= userRepository.findAll();
        for (User exisitingUser:usersList){
            if(exisitingUser.getMobileNumber().equals(user.getMobileNumber()) || exisitingUser.getUserName().equals(user.getUserName()) || exisitingUser.getEmail().equals(user.getEmail()))
                return false;
        }
        return true;
    }
    public User addUser(User user) {
        if(validateUser(user)){
            user.setActive(WalletStatus.False);
            return userRepository.save(user);
        }
        else{
            throw new AlreadyExistsException("User Already exists");
        }
    }

    public List<User> getAllUsers()
    {
        List<User> usersList =userRepository.findAll();
        if(usersList.isEmpty()){
            throw new NotFoundException("Users List Empty");
        }
        else{
            return usersList;
        }
    }

    public void deleteUserById(Long id){
        if(userRepository.existsById(id)){
            throw new NotFoundException("User Doesn't Exist");
        }
        else{
            userRepository.deleteById(id);
        }
    }

    public User getUserById(Long id) {
        if(userRepository.existsById(id)){
            throw new NotFoundException("User Doesn't Exist");
        }
        else{
            return userRepository.findById(id).get();
        }

    }
}
