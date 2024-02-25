package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Image;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repo.PostRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.PostService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final UserPepo userPepo;
    @Override
    public void savePostByUser(Long userId, Post post) {
        User user = userPepo.findById(userId).orElseThrow(() -> new NoSuchElementException("not"));
        post.setUser(user);
        user.getPosts().add(post);

        String imageUrl = post.getImageUrl();
        Image image = new Image();

        image.setImageURL(imageUrl);
        image.setPost(post);
        post.addImage(image);
        postRepo.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepo.findById(postId).orElseThrow();
    }

    @Override
    public void delete(Long postId) {
        postRepo.deleteById(postId);
    }

    @Override
    public Optional<Post> getAllPostByUserId(Long id) {
        return postRepo.findById(id);
    }
}
