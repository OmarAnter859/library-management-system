package com.project.maids.cc.controllers;

import com.project.maids.cc.entities.Patron;
import com.project.maids.cc.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Optional<Patron> getPatronById(@PathVariable Integer id) {
        return patronService.getPatronById(id);
    }

    @PostMapping
    public Patron addPatron(@RequestBody Patron patron) {
        return patronService.addPatron(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable Integer id, @RequestBody Patron updatedPatron) {
        return patronService.updatePatron(id, updatedPatron);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Integer id) {
        patronService.deletePatron(id);
    }
}