package peaksoft.service;

import peaksoft.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService  {

    void savePostByUser(Long userId, Post post);
    List<Post> getAll();
    Post findPostById(Long postId);
    void delete(Long postId);
    Optional<Post> getAllPostByUserId(Long id);
}
