package com.school.web_info.service;

import com.school.web_info.dto.PeerDTO;
import com.school.web_info.entity.Peer;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.PeerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PeerServiceImplementation implements PeerService {


    PeerRepository peerRepository;

    @Override
    public List<Peer> getAllPeers() {
        return peerRepository.findAll();
    }

    @Override
    public Peer getPeer(String nickname) {
        return peerRepository.getReferenceById(nickname);
    }

    @Override
    public void savePeer(PeerDTO peerDTO) {
        Peer peer = convertPeerDTOtoPeerEntity(peerDTO);
        peerRepository.saveAndFlush(peer);
    }

    private Peer convertPeerDTOtoPeerEntity(PeerDTO peerDTO) {
        String nickname = peerDTO.getNickname();
        Optional<Peer> peer = peerRepository.findById(nickname);
        Peer peerEntity = null;
        if (peer.isPresent()) {
            peerEntity = peerRepository.findById(nickname)
                    .orElseThrow(
                            () -> new NotFoundException(String.format("User with nickname %s not found",nickname))
                    );
            peerEntity.setBirthday(peerDTO.getBirthday());
        } else {
            peerEntity = Peer.builder()
                    .nickname(peerDTO.getNickname())
                    .birthday(peerDTO.getBirthday())
                    .build();
        }
        return peerEntity;
    }

    @Override
    public void deletePeer(String nickname) {
        Peer peerFindByNickname = peerRepository.findById(nickname).orElseThrow(
                () -> new NotFoundException(String.format("User with nickname %s not found",nickname))
        );
        peerRepository.delete(peerFindByNickname);
    }


}
