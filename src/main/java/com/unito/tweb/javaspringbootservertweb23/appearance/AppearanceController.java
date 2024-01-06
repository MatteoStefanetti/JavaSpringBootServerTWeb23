package com.unito.tweb.javaspringbootservertweb23.appearance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppearanceController {
    private final AppearanceService appearanceService;

    @Autowired
    public AppearanceController(AppearanceService appearanceService){
        this.appearanceService = appearanceService;
    }

}
