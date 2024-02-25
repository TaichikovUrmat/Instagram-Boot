package peaksoft.service;

import peaksoft.entity.User;

import java.util.List;

public interface UserService  {
    void saveUser(User user);
    User login (User user) throws Exception;
    User findByUserId(Long userId) throws Exception;
   User  findUserByName(String name);
   List<User> gelAll();


//
//    @Query("SELECT u FROM User u WHERE u.user_name = :username AND u.password = :password")
//    User login(User user);
//
//    @Query("select u from User u where u.user_name = :name")
//    User findUserByName(@Param("name") String name);

}
