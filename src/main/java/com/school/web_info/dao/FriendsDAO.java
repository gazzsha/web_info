package com.school.web_info.dao;

import com.school.web_info.entity.Friends;

import java.util.List;

public interface FriendsDAO {
     List<Friends> getAllFriends();

     void addNewFriends(Friends friends);

     void deleteCommunication(String sourcePeer,String targetPeer);

     List<String> getUniqueFriendsSourseList();
     List<String> getUniqueFriendsTargetList();

     Friends getOneFriends(String sourcePeer,String targetPeer);
}
