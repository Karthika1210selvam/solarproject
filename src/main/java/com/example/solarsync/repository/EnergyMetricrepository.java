package com.example.solarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.solarsync.entity.energy_metric;

@Repository
public interface EnergyMetricrepository extends JpaRepository<energy_metric,Long> {

}
