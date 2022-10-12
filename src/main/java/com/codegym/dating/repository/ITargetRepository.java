package com.codegym.dating.repository;

import com.codegym.dating.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITargetRepository extends JpaRepository<Target, Integer> {
}
