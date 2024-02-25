package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Like;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repo.LikeRepo;
import peaksoft.repo.PostRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.LikeService;
import peaksoft.service.UserService;


@Service
@Transactional
@RequiredArgsConstructor
public class LikeServiceImpl  implements LikeService {


    private  final UserPepo userPepo;
    private final PostRepo postRepo;
    private final LikeRepo likeRepo;

//    Post post = entityManager.find(Post.class, postId);
//    User user = entityManager.find(User.class, userId);
//    boolean islike = true;
//for (Like like1: post.getLikes()){
//        if(like1.getUser().getId().equals(userId)){
//            like1.setIsLike(false);
//            like1.setUser(null);
//            like1.setPost(null);
//            post.getLikes().remove(like1);
//            entityManager.remove(like1);
//            islike = false;
//            break;
//        }
//    }
//    if (islike){like.setUser(user);
//        post.addLike(like);
//        like.setPost(post);
//        entityManager.persist(like);}


    @Override
    public void saveLike(Long userId, Long postId, Like like) {
        Post post = postRepo.findById(postId).orElseThrow();
        User user = userPepo.findById(userId).orElseThrow();

//        Like likes = new Like();
//        likes.setIs_Like(true);


         boolean isLike = true;
        for (Like like1 : post.getLikes()) {
            if (like1.getUsers().getId().equals(userId)){
                like1.setIs_Like(false);
                like1.setUsers(null);
                like1.setPosts(null);
                post.getLikes().remove(like1);
                likeRepo.delete(like1);
                isLike = false;
                break;
            }
        }
    if(isLike){like.setUsers(user);
    post.getLikes().add(like);
    like.setPosts(post);
//        Like likes = new Like();
//        likes.setIs_Like(true);

    likeRepo.save(like);

      }
    }
}
