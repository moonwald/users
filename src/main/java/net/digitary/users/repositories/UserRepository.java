package net.digitary.users.repositories;

import net.digitary.users.dtos.UserDto;
import net.digitary.users.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //Query con DTO
    @Query("select new net.digitary.users.dtos.UserDto(u.id, u.name,u.eMail, u.addressLine1, u.addressLine2,u.townCity, "
            +"u.postalCode, u.country, u.phoneNumber1, u.phoneNumber2, u.phoneNumber3, u.dateLastView ) from User u")
    List<UserDto> findAllDtos();

    //Query con DTO
    @Query("select new net.digitary.users.dtos.UserDto(u.id, u.name,u.eMail, u.addressLine1, u.addressLine2, u.townCity,"
            +"u.postalCode, u.country, u.phoneNumber1, u.phoneNumber2, u.phoneNumber3, u.dateLastView ) from User u where u.id=:id")
    UserDto findDtoById(@Param("id") long id);

    long countByName(String name);
    
  //Query con entity gia' dichiarati nella superclasse
  //  List<User> findAll();
    
  //Query con entity
  //  List<User> findById();


}
