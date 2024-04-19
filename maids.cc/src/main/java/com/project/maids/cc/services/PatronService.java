package com.project.maids.cc.services;

import com.project.maids.cc.entities.Patron;
import com.project.maids.cc.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Optional<Patron> getPatronById(Integer id) {
        return patronRepository.findById(id);
    }

    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Integer id, Patron updatedPatron) {
        updatedPatron.setId(id);
        return patronRepository.save(updatedPatron);
    }
    public void deletePatron(Integer id) {
        patronRepository.deleteById(id);
    }
}
