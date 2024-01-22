package com.school.web_info.controller;


import com.school.web_info.entity.Friends;
import com.school.web_info.service.FriendsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/school")
@AllArgsConstructor
@Controller
public class ControllerFriends {

    private final FriendsService friendsService;

    @GetMapping("/friends")
    public String showAllFriends(Model model) {
        List<Friends> friendsList = friendsService.getAllFriend();
        model.addAttribute("friends",friendsList);
        return "friends/view";
    }

    @RequestMapping(value = "friends/addNewFriends",method = {RequestMethod.GET,RequestMethod.PUT})
    public String addNewFriends(Friends friends) {
        friendsService.addNewFriends(friends);
        return "redirect:/school/friends";
    }

    @RequestMapping(value = "friends/deleteFriends",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteFriends(@RequestParam("sourcePeer") String sourcePeer,
                                @RequestParam("targetPeer") String targetPeer) {
        friendsService.deleteCommunication(sourcePeer,targetPeer);
        return "redirect:/school/friends";
    }


    @ModelAttribute("sourceUniqueList")
    public  List<String> getSourcePeerUnique() {
        List<String> sourcePeerUnique = friendsService.getUniqueSourceFriendsList();
        return sourcePeerUnique;
    }

    @ModelAttribute("targetUniqueList")
    public  List<String> getTargetPeerUnique() {
        List<String> targetPeerUnique = friendsService.getUniqueTargetFriendsList();
        return targetPeerUnique;
    }


    @GetMapping("/friends/getOneCommunication")
    @ResponseBody
    public Friends getOneCommunication(@RequestParam("sourcePeer") String sourcePeer,
                                       @RequestParam("targetPeer") String targetPeer){
        return friendsService.getOneFriends(sourcePeer,targetPeer);
    }


}
