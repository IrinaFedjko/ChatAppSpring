package com.chatappspring.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //bean(s) others include @Controller @Repository @Bean etc
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public void createUser(User user) throws Exception{
        //will use userRepository to save user to db
        this.userRepository.save(user);
    }

    public User verifyUser(String username, String password) throws  Exception{
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        if(user == null)throw new Exception("Username or password is not correct");
        return user;
    }
}
