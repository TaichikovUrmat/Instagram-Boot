package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Comment;
import peaksoft.entity.User;
@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {

}
