package net.digitary.users.controllers;

import net.digitary.users.dtos.CustomErrorTypeDto;
import net.digitary.users.dtos.UserDto;
import net.digitary.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<List<UserDto>>(this.userService.findAll(), HttpStatus.OK);
    }

    /**
     * Find user by numeric  id
     * @param id
     * @return
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?> findById(@PathVariable("id") long id){
        if (!userService.exists(id))
        return new ResponseEntity(new CustomErrorTypeDto(HttpStatus.NOT_FOUND.value(),"/api/users"+id,
                "Unable to upate. User with id " + id + " not found.", System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<UserDto>(this.userService.findById(id), HttpStatus.OK);
    }

    /**
     * Delete user by numeric  id
     * @param id
     * @return
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){

        if (!userService.exists(id))
            return new ResponseEntity(new CustomErrorTypeDto(HttpStatus.NOT_FOUND.value(),"/api/users"+id,
                    "Unable to delete. User with id " + id + " not found.", System.currentTimeMillis()),
                    HttpStatus.NOT_FOUND);

        this.userService.delete(id);
        this.userService.refreshAllCachedUsers();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /**
     * Insert user in db
     * @param user
     * @return
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UserDto user, UriComponentsBuilder ucBuilder, HttpServletRequest request){
        if (userService.exists(user.getName())) {
            return new ResponseEntity(new CustomErrorTypeDto(HttpStatus.CONFLICT.value(),"/api/users",
                    "Unable to create. A User with name " +
                    user.getName() + " already exist.", System.currentTimeMillis()),HttpStatus.CONFLICT);
        }
            this.userService.save(user);
        this.userService.refreshAllCachedUsers();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("api/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    /**
     * Update user in db by id
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") long id,@RequestBody UserDto user){
        if (!userService.exists(id))
            return new ResponseEntity(new CustomErrorTypeDto(HttpStatus.NOT_FOUND.value(),"/api/users/"+id,
                    "Unable to update. User with id " + id + " not found.", System.currentTimeMillis()),
                    HttpStatus.NOT_FOUND);
        this.userService.update(id,user);
        this.userService.refreshAllCachedUsers();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}

