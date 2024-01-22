package com.school.web_info.service;

import com.school.web_info.dao.FriendsDAO;
import com.school.web_info.entity.Friends;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class FriendsServiceImplementation implements FriendsService{

    private final FriendsDAO friendsDAO;
    @Override
    @Transactional
    public List<Friends> getAllFriend() {
        return friendsDAO.getAllFriends();
    }

    @Override
    @Transactional
    public void addNewFriends(Friends friends) {
        friendsDAO.addNewFriends(friends);
    }

    @Override
    @Transactional
    public void deleteCommunication(String sourcePeer,String targetPeer) {
        friendsDAO.deleteCommunication(sourcePeer,targetPeer);
    }

    @Override
    @Transactional
    public List<String> getUniqueSourceFriendsList() {
        return friendsDAO.getUniqueFriendsSourseList();
    }

    @Override
    @Transactional
    public List<String> getUniqueTargetFriendsList() {
        return friendsDAO.getUniqueFriendsTargetList();
    }

    @Override
    @Transactional
    public Friends getOneFriends(String sourcePeer, String targetPeer) {
        return friendsDAO.getOneFriends(sourcePeer,targetPeer);
    }


}
