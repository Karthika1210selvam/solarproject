package com.example.solarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.solarsync.entity.maintenance_ticket;

@Repository
public interface MaintenanceTicketrepository extends JpaRepository<maintenance_ticket,Long> {

}
