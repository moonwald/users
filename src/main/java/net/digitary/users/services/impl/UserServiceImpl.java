package net.digitary.users.services.impl;

import net.digitary.users.dtos.UserDto;
import net.digitary.users.entities.User;
import net.digitary.users.repositories.UserRepository;
import net.digitary.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * retrieve all the users
     *
     * @return
     */
    @Override
    @Cacheable("getAllUsers")
    public List<UserDto> findAll() {
        return this.userRepository.findAllDtos();
    }

    /**
     * //This method will remove all 'getAllUsers' from cache, say as a result of flush API.
     */
    @CacheEvict(value = "getAllUsers", allEntries = true)
    @Override
    public void refreshAllCachedUsers() {

    }

    /**
     * find user by id
     *
     * @param id
     * @return
     */
    @Override
    public UserDto findById(long id) {
        UserDto userDto = this.userRepository.findDtoById(id);
        return userDto;
    }


    /**
     * find save the user in db and setting the new id in the dto
     *
     * @param userDto
     */
    @Override
    @Transactional
    public void save(UserDto userDto) {
        User user = new User();
        translateDtoToEntity(userDto, user);
        this.userRepository.save(user);
        userDto.setId(user.getId());
    }


    /**
     * Update the user by id
     *
     * @param id
     * @param userDto
     */
    @Override
    @Transactional
    public void update(long id, UserDto userDto) {
        User user = userRepository.findOne(id);
        translateDtoToEntity(userDto, user);
        userDto.setId(user.getId());

    }

    /**
     * delete user by id
     *
     * @param id
     */
    @Override
    @Transactional
    public void delete(long id) {

        this.userRepository.delete(id);
    }

    @Override
    /**
     * Check user by id
     */
    public boolean exists(long id) {
        return this.userRepository.exists(id);
    }

    @Override
    /**
     * Check user by name
     */
    public boolean exists(String name) {
        return this.userRepository.countByName(name) > 0;
    }


    /**
     * copy the data from userDto to user
     *
     * @param user
     */
    private void translateDtoToEntity(UserDto userDto, User user) {

        user.setName(userDto.getName());
        user.seteMail(userDto.geteMail());
        user.setAddressLine1(userDto.getAddressLine1());
        user.setAddressLine2(userDto.getAddressLine2());

        user.setTownCity(userDto.getTownCity());
        user.setPostalCode(userDto.getPostalCode());
        user.setCountry(userDto.getCountry());
        user.setPhoneNumber1(userDto.getPhoneNumber1());

        user.setPhoneNumber2(userDto.getPhoneNumber2());
         user.setPhoneNumber3(userDto.getPhoneNumber3());
        user.setDateLastView(LocalDateTime.now());

    }


    /**
     * Setting the page order
     *
     * @param sortBy
     * @param sortDirection
     * @return
     */
    private Sort sort(String sortBy, String sortDirection) {
        if (sortDirection.equals("ASC") || sortDirection.equals("asc")) {
            return new Sort(Sort.Direction.ASC, sortBy);
        } else {
            return new Sort(Sort.Direction.DESC, sortBy);
        }

    }
    
    /*
    @Override
    public List<User> findAllEntities() {
        return this.userRepository.findAll();
    }
    */

}




