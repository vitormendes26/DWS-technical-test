package com.dws.isobar.fm.bands.api.controller;

import com.dws.isobar.fm.bands.api.doc.BandControllerDoc;
import com.dws.isobar.fm.bands.api.model.BandFilterDTO;
import com.dws.isobar.fm.bands.domain.model.Band;
import com.dws.isobar.fm.bands.domain.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/bands")
public class BandController implements BandControllerDoc {

    private final BandService bandService;

    @Autowired
    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Band> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(bandService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Band>> getAll(BandFilterDTO bandFilterDTO) {
        return ResponseEntity.ok(bandService.getAll(bandFilterDTO));
    }

}
