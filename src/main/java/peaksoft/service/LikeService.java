package peaksoft.service;

import peaksoft.entity.Like;

public interface LikeService {

    void saveLike(Long userId, Long postId, Like like);
}
