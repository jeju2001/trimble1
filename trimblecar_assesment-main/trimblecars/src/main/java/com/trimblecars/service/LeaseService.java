package com.trimblecars.service;

import com.trimblecars.entity.Lease;
import com.trimblecars.repository.LeaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

    private final LeaseRepository leaseRepository;

    public LeaseService(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    public Lease createLease(Lease lease) {
        return leaseRepository.save(lease);
    }
}
