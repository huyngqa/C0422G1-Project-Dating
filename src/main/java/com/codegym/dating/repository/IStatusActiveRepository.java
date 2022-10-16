package com.codegym.dating.repository;

import com.codegym.dating.model.StatusActive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusActiveRepository extends JpaRepository<StatusActive, Integer> {
}
