package com.adaming.project.alexander_time_manager.service;

import com.adaming.project.alexander_time_manager.exception.NullUserException;
import com.adaming.project.alexander_time_manager.exception.UserAlreadyExistException;
import com.adaming.project.alexander_time_manager.model.User;
import com.adaming.project.alexander_time_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
private UserRepository userRepository;
    @Transactional
    public void register(User user) throws UserAlreadyExistException, NullUserException {
        if(user==null){
            throw new NullUserException();
        }else{
            if(this.userRepository.getByPseudo(user.getPseudo())==null){
                this.userRepository.save(user);
            }else{
                throw new UserAlreadyExistException();
            }
        }
    }

    public Iterable<User> fetchAll(){
        return this.userRepository.findAll();
    }

    public User fetchById(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        this.userRepository.deleteById(id);
    }
}
