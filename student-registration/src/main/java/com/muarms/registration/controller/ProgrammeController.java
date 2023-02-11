package com.muarms.registration.controller;

import com.muarms.registration.models.Programme;

import com.muarms.registration.responses.MessageResponse;
import com.muarms.registration.services.ProgrammeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/programme/")
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProgrammeController {
    private final ProgrammeService service;

    @PostMapping(path = "add-programme")
    public Programme saveProgramme(@RequestBody Programme programme) {
        return service.saveProgramme(programme);
    }

    @GetMapping(path = "all-programme")
    public List<Programme> findAllProgramme() {
        return service.findAllProgramme();
    }

    @DeleteMapping(path = "delete-programme/{programmeId}")
    public MessageResponse deleteProgramme(@PathVariable("programmeId") Integer programmeId) {
        return new MessageResponse(service.deleteProgramme(programmeId));
    }

}
