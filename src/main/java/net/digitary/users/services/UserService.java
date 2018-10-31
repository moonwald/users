package net.digitary.users.services;

import net.digitary.users.dtos.UserDto;
import net.digitary.users.entities.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    
   // List<User> findAllEntities();

    UserDto findById(long id);

    void save(UserDto userDto);
    void update(long id, UserDto userDto);

    void delete(long id);

    boolean exists(long id);

    boolean exists(String name);

    void refreshAllCachedUsers();
    
    
}
