package com.lab.FlowerLand.flower;

import com.lab.flowerLand.flower.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlowerRepository extends JpaRepository<com.lab.FlowerLand.flower.Flower, Long> {

    @Query("SELECT f from Flower f WHERE f.name = ?1")
    Optional<com.lab.FlowerLand.flower.Flower> findFlowerByDescription(String name);

}