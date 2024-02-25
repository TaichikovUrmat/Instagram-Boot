package peaksoft.service;

import peaksoft.entity.UserInfo;
public interface UserInfoService  {

    UserInfo findUserInfoByUserID(Long userID) throws Exception;
    void delete(Long userInfoID);

    void update(Long userId, UserInfo newUserInfo);

    UserInfo findUserInfoById(Long id);

    UserInfo findById(Long id);

}
