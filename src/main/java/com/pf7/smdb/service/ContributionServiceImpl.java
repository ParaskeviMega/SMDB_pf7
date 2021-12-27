package com.pf7.smdb.service;

import com.pf7.smdb.domain.Contribution;
import com.pf7.smdb.repository.ContributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl extends BaseServiceImpl<Contribution> implements  ContributionService {

    private final ContributionRepository contributionRepository;

    @Override
    public JpaRepository<Contribution, Long> getRepository() {
        return contributionRepository;
    }
}
