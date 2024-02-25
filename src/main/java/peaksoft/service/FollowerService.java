package peaksoft.service;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.User;

public interface FollowerService  {

    void following(Long currentUserId,Long foundUserId) throws Exception;
}
