package com.school.web_info.factory;

import com.school.web_info.dto.PeerDTO;
import com.school.web_info.entity.Peer;
import org.springframework.stereotype.Component;


@Component
public class PeerDTOFactory {
    public static PeerDTO createPeerDTO(Peer peer) {
        return PeerDTO.builder()
                .nickname(peer.getNickname())
                .birthday(peer.getBirthday())
                .build();
    }
}
