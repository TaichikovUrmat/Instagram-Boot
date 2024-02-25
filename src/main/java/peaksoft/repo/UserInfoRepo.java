package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {



}
