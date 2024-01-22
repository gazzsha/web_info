package com.school.web_info.dao;

import com.school.web_info.entity.Friends;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FriendsDAOImplementation implements FriendsDAO {

    @Autowired
    private final EntityManager entityManager;

    @Override
    public List<Friends> getAllFriends() {
        Query query = entityManager.createQuery("SELECT f from Friends f", Friends.class);
        List<Friends> friendsList = query.getResultList();
        return friendsList;
    }

    @Override
    public void addNewFriends(Friends friends) {
        entityManager.merge(friends);
    }

    @Override
    public void deleteCommunication(String sourcePeer, String targetPeer) {
        Query query = entityManager.createQuery("delete from Friends where sourcePeer = ?1 and targetPeer = ?2");
        query.setParameter(1, sourcePeer);
        query.setParameter(2, targetPeer);
        query.executeUpdate();
    }

    @Override
    public List<String> getUniqueFriendsSourseList() {
        Query query = entityManager.createQuery("SELECT distinct f.sourcePeer from Friends f group by sourcePeer", Friends.class);
        List<String> friendsList = query.getResultList();
        return friendsList;
    }

    @Override
    public List<String> getUniqueFriendsTargetList() {
        Query query = entityManager.createQuery("SELECT distinct f.targetPeer from Friends f group by targetPeer", Friends.class);
        List<String> friendsList = query.getResultList();
        return friendsList;
    }

    @Override
    public Friends getOneFriends(String sourcePeer, String targetPeer) {
        Query query = entityManager.createQuery("SELECT f from Friends f where sourcePeer=?1 and targetPeer = ?2", Friends.class);
        query.setParameter(1,sourcePeer);
        query.setParameter(2,targetPeer);
        Friends friends =(Friends) query.getSingleResult();
        return friends;
    }

}
