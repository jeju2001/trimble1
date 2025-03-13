package com.trimblecars.controller;

import com.trimblecars.entity.Lease;
import com.trimblecars.service.LeaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {

    private final LeaseService leaseService;

    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    @PostMapping
    public Lease createLease(@RequestBody Lease lease) {
        return leaseService.createLease(lease);
    }
}
