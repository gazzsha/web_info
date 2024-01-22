package com.school.web_info.dao;

import com.school.web_info.entity.Peer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Repository
public class PeerDAOImplementation implements PeerDAO{


    private final EntityManager entityManager;

    public PeerDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Peer> getAllPeers() {
        Query query = entityManager.createQuery("SELECT p from Peer p",Peer.class);
        List<Peer> peerList = query.getResultList();
        return peerList;
    }

    @Override
    public Peer getPeer(String nickname) {
        return entityManager.find(Peer.class,nickname);
    }

    @Override
    public void savePeer(Peer peer) {
        entityManager.merge(peer);
    }

    @Override
    public void deletePeer(String nickname) {
        Query query = entityManager.createQuery("delete from Peer where nickname =:nicknameId");
        query.setParameter("nicknameId",nickname);
        query.executeUpdate();
    }
}
