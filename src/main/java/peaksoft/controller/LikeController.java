package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Comment;
import peaksoft.entity.Like;
import peaksoft.repo.LikeRepo;
import peaksoft.service.LikeService;

@Controller
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

  private final LikeService likeService;
//    @PostMapping("/saveComment/{userID}/{postID}")
//    public String saveComment(@ModelAttribute("newComment") Comment comment,
//                              @PathVariable("userID") Long userID,
//                              @PathVariable("postID") Long postID){
////
//        commentService.saveComment(userID,postID,comment);
//        return "instaProfil";
//    }

    @PostMapping("/saveLike/{userID}/{postID}")
    public String saveLike( @PathVariable Long userID,
                           @PathVariable Long postID, Like like){
        likeService.saveLike(userID,postID,like);
       return "instaProfil";
    }
}
