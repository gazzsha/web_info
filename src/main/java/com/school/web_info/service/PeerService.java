package com.school.web_info.service;

import com.school.web_info.dto.PeerDTO;
import com.school.web_info.entity.Peer;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PeerService {
    @Transactional(readOnly = true)
    List<Peer> getAllPeers();

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    Peer getPeer(String nickname);


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    Peer savePeer(PeerDTO peer);


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    void deletePeer(String nickname);
}
