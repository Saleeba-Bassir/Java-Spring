package com.ner3k.myapp.services;

import com.ner3k.myapp.models.LoginUser;
import com.ner3k.myapp.models.User;
import com.ner3k.myapp.repositories.UserRepository;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User newUser, BindingResult result){
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("confirmPassword","Matches","The Confirm Password must match Password!");
        }
        if(userRepository.existsByEmail(newUser.getEmail())){
            result.rejectValue("email","Matches","Email already in database!");
        }

        if (result.hasErrors()) {
            return null;
        }

        else{
            String hashed = BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }
    public User login(LoginUser newLogin,BindingResult result){
        if (result.hasErrors()) {
            return null;
        }

        else{
            Optional<User> user = userRepository.findByEmail(newLogin.getEmail());
            if (user.isPresent()){
                if(!BCrypt.checkpw(newLogin.getPassword(),user.get().getPassword())){
                    result.rejectValue("password","Matches","Invalid password!");
                    return null;
                }
                else{
                    return user.get();
                }
            }else {
                result.rejectValue("email","Matches","Email not found!");
                return null;
            }
        }

    }
    public User getUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        else return null;
    }
}
