package com.school.web_info.controller;

import com.school.web_info.entity.Peer;
import com.school.web_info.service.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/school")
public class ControllerPeer {
    @Autowired
    PeerService peerService;

    @GetMapping("/peers")
    public String showAllPeers(Model model) {
        List<Peer> peerList = peerService.getAllPeers();
        model.addAttribute("allPeers",peerList);
        return "peers/ViewAll";
    }

    @PostMapping("/savePeer")
    public String savePeer(@ModelAttribute("peer") Peer peer) {
        peerService.savePeer(peer);
        return "redirect:/school/peers";
    }

    @RequestMapping(value = "/updatePeer",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updatePeer(@ModelAttribute("peer") Peer peer) {
        peerService.savePeer(peer);
        return "redirect:/school/peers";
    }

    @RequestMapping(value = "/deletePeer",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deletePeer(@RequestParam String nickname) {
        peerService.deletePeer(nickname);
        return "redirect:/school/peers";
    }



    @RequestMapping("/getOnePeer")
    @ResponseBody
    public Peer getOnePeer(@RequestParam  String nickname) {
        return peerService.getPeer(nickname);
    }


    @ModelAttribute("peer")
    public Peer getPeer() {
        return new Peer();
    }





}
