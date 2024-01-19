package com.unito.tweb.javaspringbootservertweb23.appearance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppearanceController {
    private final AppearanceService appearanceService;

    @Autowired
    public AppearanceController(AppearanceService appearanceService) {
        this.appearanceService = appearanceService;
    }

    @PostMapping("/addAppearances")
    public ResponseEntity<String> addAppearances(@RequestBody List<Appearance> appearances){
        appearanceService.saveAppearances(appearances);
        return ResponseEntity.ok("Appearances successfully loaded!");
    }

}
