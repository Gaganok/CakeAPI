package com.cake.manager.cake.service;

import com.cake.manager.cake.domain.Cake;
import com.cake.manager.cake.repository.CakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleh Kepsha
 */
@Service
@AllArgsConstructor
public class CakeManagementService {

    private final CakeRepository repository;

    public List<Cake> getCakes() {
        return repository.findAll();
    }

    public Cake addCake(Cake cake) {
        return repository.save(cake);
    }
}
