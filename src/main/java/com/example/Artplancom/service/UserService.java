package com.example.Artplancom.service;


import com.example.Artplancom.entity.User;
import com.example.Artplancom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByName(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        userRepository.save(user);

        return true;
    }

    public Long userLogin(User user) {
        User userFromDB = userRepository.findByName(user.getUsername());

        if (userFromDB.getPassword().equals(user.getPassword())) {
            return userFromDB.getId();
        }
        return null;

    }


    //    @Override
    public User loadUserByUsername(String username) {
        User user = userRepository.findByName(username);
//
//        if (user == null){
//            throw new UsernameNotFoundException("User not found");
//        }

        return user;
    }

}
