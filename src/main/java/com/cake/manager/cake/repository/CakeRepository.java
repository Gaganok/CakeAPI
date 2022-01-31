package com.cake.manager.cake.repository;

import com.cake.manager.cake.domain.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oleh Kepsha
 */
@Repository
public interface CakeRepository extends JpaRepository<Cake, Integer> { }
