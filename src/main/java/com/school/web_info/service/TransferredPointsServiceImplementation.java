package com.school.web_info.service;

import com.school.web_info.dao.TransferredPointsDAO;
import com.school.web_info.entity.TransferredPoints;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransferredPointsServiceImplementation implements TransferredPointService{

    private final TransferredPointsDAO transferredPointsDAO;
    @Override
    public List<TransferredPoints> getAllTransferredPoints() {
        return transferredPointsDAO.getAllTransferredPoints();
    }
}
