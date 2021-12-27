package com.pf7.smdb.repository;

import com.pf7.smdb.domain.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution,Long> {


}
