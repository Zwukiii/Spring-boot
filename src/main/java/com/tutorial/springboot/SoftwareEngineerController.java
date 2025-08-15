package com.tutorial.springboot;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping

    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();


    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    // ex1
    @DeleteMapping("{id}")
    public void removeSoftwareEngineerById(@PathVariable("id") Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);

    }

    //ex2
    @PutMapping("{id}")
    public void updateSoftwareEngineer(@PathVariable("id") Integer id,
                                       @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineer.setId(id);
        softwareEngineerService.updateSoftwareEngineer(softwareEngineer);

    }


}
