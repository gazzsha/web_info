package com.school.web_info.service;

import com.school.web_info.dao.ChecksDAO;
import com.school.web_info.entity.Checks;
import com.school.web_info.entity.P2P;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ChecksServiceImplementation implements ChecksService {

    private final ChecksDAO checksDAO;


    @Override
    @Transactional
    public List<Checks> getAllChecks() {
        return checksDAO.getAllChecks();
    }
}
