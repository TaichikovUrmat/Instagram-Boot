package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.entity.User;
@Repository
public interface UserPepo extends JpaRepository<User,Long> {

//    @Query("SELECT u FROM User u WHERE u.user_name = :username and u.password =:password")
//    User login(String userName, String password);

    @Query("SELECT u FROM User u WHERE u.user_name = :username and u.password = :password")
    User login(@Param("username") String userName, @Param("password") String password);


    @Query("select u from User u where u.user_name = :name")
    User findUserByName(@Param("name") String name);


}
