package com.school.web_info.dao;

import com.school.web_info.entity.Checks;
import com.school.web_info.entity.P2P;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
public class ChecksDAOImplementation implements ChecksDAO {

    private final EntityManager entityManager;

    @Override
    public List<Checks> getAllChecks() {
        Query query = entityManager.createQuery("select c from Checks c  order by c.id", Checks.class);
        List<Checks> checksList = query.getResultList();
        return checksList;
    }
}
