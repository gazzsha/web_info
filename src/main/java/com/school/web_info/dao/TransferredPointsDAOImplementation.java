package com.school.web_info.dao;

import com.school.web_info.entity.TransferredPoints;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TransferredPointsDAOImplementation implements TransferredPointsDAO{

    private final EntityManager entityManager;
    @Override
    public List<TransferredPoints> getAllTransferredPoints() {
        Query query = entityManager.createQuery("select t from TransferredPoints t");
        List<TransferredPoints> transferredPointsList = query.getResultList();
        return transferredPointsList;
    }
}
