package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Comment;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repo.CommentRepo;
import peaksoft.repo.PostRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.CommentService;
import peaksoft.service.UserService;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final UserPepo userPepo;
    @Override
    public void saveComment(Long userId, Long postId, Comment comment) {
        User user = userPepo.findById(userId).orElseThrow();
        Post post = postRepo.findById(postId).orElseThrow();
        user.addComment(comment);
        post.addComment(comment);
        comment.setPosts(post);
        comment.getUsers().add(user);
        commentRepo.save(comment);
    }

    @Override
    public Comment finByCommentID(Long commentId) {
        return commentRepo.findById(commentId).orElseThrow();
    }

}
