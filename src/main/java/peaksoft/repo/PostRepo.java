package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Post;
import peaksoft.entity.User;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

}
