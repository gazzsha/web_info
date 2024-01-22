package com.school.web_info.service;

import com.school.web_info.entity.Peer;

import java.util.List;

public interface PeerService {
    List<Peer> getAllPeers();

    Peer getPeer(String nickname);

    void savePeer(Peer peer);

    void deletePeer(String nickname);
}
