package me.dio.services;

import me.dio.domain.model.User;
import me.dio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public User create(User userToCreate){
        if (userToCreate.getId() != null && repository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This user ID already exists");
        }
        return repository.save(userToCreate);
    }
}
