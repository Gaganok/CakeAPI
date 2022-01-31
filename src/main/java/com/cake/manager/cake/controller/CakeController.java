package com.cake.manager.cake.controller;

import com.cake.manager.cake.domain.Cake;
import com.cake.manager.cake.service.CakeManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Oleh Kepsha
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cake")
public class CakeController {

    private final CakeManagementService cakeService;

    @GetMapping
    public ResponseEntity<Collection<Cake>> getCakes(){
        return ResponseEntity.ok(cakeService.getCakes());
    }

    @PostMapping
    public ResponseEntity<Cake> addCake(@RequestBody Cake cake){
        return ResponseEntity.ok(cakeService.addCake(cake));
    }

}
