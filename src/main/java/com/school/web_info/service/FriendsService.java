package com.school.web_info.service;

import com.school.web_info.entity.Friends;

import java.util.List;

public interface FriendsService {
    List<Friends> getAllFriend();

    void addNewFriends(Friends friends);

    void deleteCommunication(String sourcePeer,String targetPeer);

    List<String> getUniqueSourceFriendsList();
    List<String> getUniqueTargetFriendsList();

    Friends getOneFriends(String sourcePeer,String targetPeer);



}
