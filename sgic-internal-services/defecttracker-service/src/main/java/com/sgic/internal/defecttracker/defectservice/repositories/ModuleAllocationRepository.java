package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;

public interface ModuleAllocationRepository extends JpaRepository<ModuleAllocation, Long> {

}
