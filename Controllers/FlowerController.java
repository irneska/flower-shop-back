package com.lab.FlowerLand.flower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flower")
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @CrossOrigin
    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @CrossOrigin
    @PostMapping
    public void addNewFlower(@RequestBody Flower flower) {
        flowerService.addNewFlower(flower);
    }

    @CrossOrigin
    @DeleteMapping(path = "{flowerId}")
    public void deleteFlower(@PathVariable("flowerId") Long flowerId) {
        flowerService.deleteFlower(flowerId);
    }


    @CrossOrigin
    @PutMapping("/update/{id}")
    private void updateFlower(@PathVariable("id") Long id, @RequestBody Flower flower) {
        flowerService.updateFlower(id, flower);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private Flower getOne(@PathVariable("id") Long id) {
        return flowerService.getOne(id);
    }


}