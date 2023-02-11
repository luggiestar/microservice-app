package com.muarms.registration.services;

import com.muarms.registration.models.Programme;
import com.muarms.registration.repositories.ProgrammeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgrammeService {
    private final ProgrammeRepository repository;

    public Programme saveProgramme(Programme programme) {
        long count = repository.findByName(programme.getName());
        if(count == 0) {
            return repository.save(programme);
        }
        else {
            return programme;
        }
    }

    public String deleteProgramme(Integer programmeId) {
        long countProgramme = repository.findById(programmeId).stream().count();
        if(countProgramme == 1) {
            repository.deleteById(programmeId);
            return "deleted";
        }
        else {
            return "Programme with the given id not found";
        }
    }

    public List<Programme> findAllProgramme() {
        return repository.findAll();
    }
}

