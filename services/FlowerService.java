package com.lab.FlowerLand.flower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

import java.util.Optional;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }

    public void addNewFlower(Flower flower) {
        Optional<Flower> flowerOptional = flowerRepository.findFlowerByDescription(flower.getDescription());
        if (flowerOptional.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        flowerRepository.save(flower);
    }

    public void deleteFlower(Long flowerId) {
        boolean exists = flowerRepository.existsById(flowerId);
        if (!exists) {
            throw new IllegalStateException("flower with id" + flowerId + "does not exists");

        }
        flowerRepository.deleteById(flowerId);

    }

    @Transactional
    public void updateFlower(Long id, Flower flower) {
        Flower newFlower = flowerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        newFlower.setName(flower.setName());
        newFlower.setPrice(flower.getPrice());
        newFlower.setImage(flower.getImage());
    }

    public Flower getOne(Long id) {
        return flowerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}