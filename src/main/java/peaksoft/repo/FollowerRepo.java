package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Follower;
import peaksoft.entity.User;
@Repository
public interface FollowerRepo extends JpaRepository<Follower,Long> {



}
