package com.cake.manager.cake.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Oleh Kepsha
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "title", unique = true, nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    private String desc;

    @Column(name = "image", nullable = false, length = 300)
    private String image;

    public Cake(String title, String desc, String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }
}
