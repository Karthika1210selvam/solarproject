package com.example.solarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.solarsync.entity.solar_panel;

@Repository
public interface SolarPanelrepository extends JpaRepository<solar_panel,Long>{

}
