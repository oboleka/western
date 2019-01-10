package obolochkova.service;


import obolochkova.model.User;
import obolochkova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService implements AbstractUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void remove(User object) {
        userRepository.delete(object);

    }

    @Override
    public void removeById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void removeAll() {
        userRepository.deleteAll();
    }

    @Override
    public void removeByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return  userRepository.findByEmail(email);
    }
}
