package peaksoft.controller;


import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Comment;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.repo.LikeRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.*;

@Controller
@RequestMapping("/userInfo")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final PostService postService;
    private final UserService userService;
    private final UserPepo userPepo;
    private  final CommentService commentService;
    private final FollowerService followerService;


    ////*****************************  home  *********************************************////
    @GetMapping("/home")
    public String ribbon(@ModelAttribute Model model,Long postID,Long userId) throws Exception {
        User byUserId = userService.findByUserId(userId);
        model.addAttribute("allPost",postService.getAll());
        model.addAttribute("comments");
        model.addAttribute("postID",postService.findPostById(postID));
        model.addAttribute("userId",userService.findByUserId(userId));
        model.addAttribute("user",byUserId);
        model.addAttribute("userIdd",userPepo.findById(userId));
        return "home-page";
    }
    /////***************************************************************************************//
    @GetMapping("/hm")
    public String hom2(Model model){
        return "/home-page";
    }



    ////***************************** instaProfile  *********************************************////

    @GetMapping("/newInstaProfile/{userId}")
    public String instaProfile(@PathVariable Long userId,Model model) throws Exception {
        User user = userService.findByUserId(userId);
//        Comment comment = new Comment();
        model.addAttribute("userId", userId);
        model.addAttribute("user", userService.findByUserId(userId));
        model.addAttribute("userInfo",userInfoService.findUserInfoByUserID(userId));
        model.addAttribute("postInfo", user.getPosts());
        model.addAttribute("commentInfo",user.getPosts());
        model.addAttribute("postIDD", user.getPosts());
        model.addAttribute("com", new Comment());

//        model.addAttribute("subcribers", followerService.Subscribers(user.getFollower().getId()));
//        model.addAttribute("subcribtions", followerService.Subscriptions(user.getFollower().getId()));
        model.addAttribute("post",postService.getAllPostByUserId(user.getId()));
        return "/instaProfil";
    }
 ////***************************** update Info *********************************************////

    @GetMapping("/update/{userInfoId}")
    public String updateUserInfo(@PathVariable("userInfoId") Long userInfoId, Model model){
        UserInfo userInfo = userInfoService.findById(userInfoId);
        model.addAttribute("newUserInfo", userInfo);
        model.addAttribute("userInfoId", userInfoId);
        return "createUserInfo";
    }
    @PostMapping("/edit/{userInfoId}")
    public String editUserInfo(@ModelAttribute("userInfo") UserInfo userInfo,
                               @PathVariable Long userInfoId){
        userInfoService.update(userInfoId,userInfo);
        return "redirect:/instaProfil";
    }
/////*********************** Delete **************************************///

//    @GetMapping("/delete/{userInfoId}")
//    public String deleteUserInfo(@ModelAttribute("newUserInfo")
//            @PathVariable("userInfoId") Long userInfoID) throws Exception {
//        Long userId = userService.findByUserId(userInfoID).getUserInfo().getId();
//        userInfoService.delete(userInfoID);
//        return "redirect:/userInfo/newInstaProfile/" + userId;
//    }
//
  ////******************* Update ***************************************////

    }



