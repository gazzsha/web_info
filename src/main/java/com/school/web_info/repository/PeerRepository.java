package com.school.web_info.repository;

import com.school.web_info.entity.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerRepository extends JpaRepository<Peer, String> {
}
