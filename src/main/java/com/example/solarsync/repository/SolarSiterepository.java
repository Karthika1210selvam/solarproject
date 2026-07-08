package com.example.solarsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.solarsync.entity.solar_site;

@Repository
public interface SolarSiterepository extends JpaRepository<solar_site,Long> {

}
