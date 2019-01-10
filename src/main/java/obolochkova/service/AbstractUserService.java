package obolochkova.service;


import obolochkova.model.User;

import java.util.Collection;
import java.util.Optional;


public interface AbstractUserService {

    public User save(User object);

    public void remove(User object);

    public void removeById (String id);

    public Optional<User> getById(String id);

    public  Collection<User> getAll();

    public void removeAll();

    public void removeByEmail(String email);

    User getByEmail(String email);
}
