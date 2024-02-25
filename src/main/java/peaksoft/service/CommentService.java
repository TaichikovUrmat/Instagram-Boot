package peaksoft.service;

import peaksoft.entity.Comment;

public interface CommentService {

    void saveComment(Long userId, Long postId, Comment comment);
    Comment finByCommentID(Long commentId);
}
