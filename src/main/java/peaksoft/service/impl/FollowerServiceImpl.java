package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.User;
import peaksoft.repo.FollowerRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.FollowerService;
import peaksoft.service.UserService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowerServiceImpl implements FollowerService {

    private final FollowerRepo followerRepo;
    private final UserService userService;
    private final UserPepo userPepo;
    @Override
    public void following(Long currentUserId, Long foundUserId) throws Exception {

        User foundUser = userPepo.findById(currentUserId).orElseThrow();
        User userCurrent = userPepo.findById(foundUserId).orElseThrow();

//        User userCurrent = entityManager.find(User.class, currentUserId);
//        User foundUser = entityManager.find(User.class, foundUserId);

        List<Long> subscribers = foundUser.getFollower().getSubscribers();
        List<Long> subscriptions = userCurrent.getFollower().getSubscriptions();

        boolean foundUs = false;
        for (Long subscriptionId : subscriptions) {
            if( subscriptionId.equals(foundUserId)){
                subscriptions.remove(subscriptionId);
                foundUs = true;
                break;
            }
        }
        if (!foundUs) subscriptions.add(foundUserId);

        for (Long subscriber : subscribers) {
            if (subscriber.equals(currentUserId)) {
                subscribers.remove(subscriber);
                foundUs = true;
                break;
            }

        }
        if (!foundUs) subscribers.add(currentUserId);

    }
}
