package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.UserInfo;
import peaksoft.repo.UserInfoRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.UserInfoService;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor

public class UserInfoServiceImpl implements UserInfoService {

private final UserInfoRepo userInfoRepo;
private final UserPepo userPepo;

    @Override
    public UserInfo findUserInfoByUserID(Long userID) {
       return userPepo.findById(userID).orElseThrow().getUserInfo();
    }
    @Override
    public void delete(Long userInfoID) {
     userInfoRepo.deleteById(userInfoID);
    }

    @Override
    public void update(Long userId, UserInfo newUserInfo) {
        UserInfo userInfo = userInfoRepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("not"));
        userInfo.setFullName(newUserInfo.getFullName());
        userInfo.setBiography(newUserInfo.getBiography());
        userInfo.setImage(newUserInfo.getImage());
        userInfo.setGender(newUserInfo.getGender());
//        userInfoRepo.save(newUserInfo);

    }

    @Override
    public UserInfo findUserInfoById(Long id) {
        return userInfoRepo.findById(id).orElseThrow();
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoRepo.findById(id).orElse(null);
    }


}
