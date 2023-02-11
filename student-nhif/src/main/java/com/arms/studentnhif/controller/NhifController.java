package com.arms.studentnhif.controller;

import com.arms.studentnhif.models.Nhif;
import com.arms.studentnhif.responses.NhifResponse;
import com.arms.studentnhif.servces.NhifService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "nhif/")
@Slf4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class NhifController {
    private final NhifService service;

    @GetMapping(path = "all")
    public List<Nhif> findAllNhif() {
        return service.getAllNhif();
    }

    @PostMapping(path = "new-card")
    public NhifResponse saveNhif(@RequestBody Nhif nhif) {
        return new NhifResponse(service.saveNhif(nhif), nhif);
    }
}
