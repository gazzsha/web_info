package com.school.web_info.service;

import com.school.web_info.dao.PeerDAO;
import com.school.web_info.entity.Peer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PeerServiceImplementation implements PeerService{
    @Autowired
    PeerDAO peerDAO;
    @Override
    @Transactional
    public List<Peer> getAllPeers() {
        return peerDAO.getAllPeers();
    }

    @Override
    @Transactional
    public Peer getPeer(String nickname) {
        return peerDAO.getPeer(nickname);
    }

    @Override
    @Transactional
    public void savePeer(Peer peer) {
        peerDAO.savePeer(peer);
    }

    @Override
    @Transactional
    public void deletePeer(String nickname) {
        peerDAO.deletePeer(nickname);
    }


}
