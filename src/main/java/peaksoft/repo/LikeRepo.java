package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Follower;
import peaksoft.entity.Image;
import peaksoft.entity.Like;

@Repository
public interface LikeRepo extends JpaRepository<Like,Long> {
}
