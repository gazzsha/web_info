package com.school.web_info.controller;

import com.school.web_info.dto.PeerDTO;
import com.school.web_info.entity.Peer;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.factory.PeerDTOFactory;
import com.school.web_info.service.PeerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@org.springframework.stereotype.Controller
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(ControllerPeer.API)
@AllArgsConstructor
public class ControllerPeer {
    PeerService peerService;


    static final String API = "/school";

    static final String GET_PEERS = "/peers";
    static final String SAVE_PEER = "/peer";
    static final String UPDATE_PEER = "/peer";

    static final String DELETE_PEER = "/peer/{peerId}";

    static final String GET_PEER = "/peer/{peerId}";

    @GetMapping(GET_PEERS)
    public String showAllPeers(Model model) {
        List<PeerDTO> peers = peerService.getAllPeers().stream()
                .map(peer -> PeerDTO.builder()
                        .nickname(peer.getNickname())
                        .birthday(peer.getBirthday())
                        .build()).toList();
        model.addAttribute("allPeers", peers);
        return "peers/ViewAll";
    }

    @PostMapping(path = SAVE_PEER)
    @ResponseBody
    public ResponseEntity<?> savePeer(@Valid @RequestBody PeerDTO peer) {
        var savedPeer = peerService.savePeer(peer);
        PeerDTO peerDTO = PeerDTO.builder()
                .nickname(savedPeer.getNickname())
                .birthday(savedPeer.getBirthday())
                .build();
        return ResponseEntity.created(URI.create(SAVE_PEER)).body(peerDTO);
    }

    @PutMapping(UPDATE_PEER)
    @ResponseBody
    public ResponseEntity<?> updatePeer(@Valid @RequestBody PeerDTO peer) {
        var updatedPeer = peerService.savePeer(peer);
        PeerDTO peerDTO = PeerDTO.builder()
                .nickname(updatedPeer.getNickname())
                .birthday(updatedPeer.getBirthday())
                .build();
        return new ResponseEntity<>(peerDTO, HttpStatus.OK);
    }

    @DeleteMapping(DELETE_PEER)
    @ResponseBody
    public ResponseEntity<?> deletePeer(@PathVariable(name = "peerId") String nickname) {
        peerService.deletePeer(nickname);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(GET_PEER)
    @ResponseBody
    public ResponseEntity<?> getPeer(@PathVariable(name = "peerId") String nickname) {
        Peer gettingPeer = peerService.getPeer(nickname);
        PeerDTO peerDTO = PeerDTO.builder()
                .nickname(gettingPeer.getNickname())
                .birthday(gettingPeer.getBirthday())
                .build();
        return new ResponseEntity<>(peerDTO, HttpStatus.OK);
    }

}
