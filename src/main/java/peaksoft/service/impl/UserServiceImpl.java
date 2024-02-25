package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.*;
import peaksoft.repo.UserPepo;
import peaksoft.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPepo userPepo;

    @Override
    public void saveUser(User user) {
        UserInfo userInfo = new UserInfo();
        Image image = new Image();
        List<Comment> comments = new ArrayList<>();
        Follower follower = new Follower();

        user.setFollower(follower);
        user.setComments(comments);
        user.setImage(image);
        user.setUserInfo(userInfo);

        userPepo.save(user);
    }

    @Override
    public User login(User user)  {
        User user1 = userPepo.login(user.getUser_name(), user.getPassword());
        if (user1 != null){
            return user1;
        }else {
            return null;
        }
    }

    @Override
    public User findByUserId(Long userId) {
        return userPepo.findById(userId).orElse(null);
    }

    @Override
    public User findUserByName(String name) {
        return userPepo.findUserByName(name);
    }

    @Override
    public List<User> gelAll() {
        return userPepo.findAll();
    }


}
