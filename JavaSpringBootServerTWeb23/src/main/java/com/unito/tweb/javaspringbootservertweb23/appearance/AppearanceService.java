package com.unito.tweb.javaspringbootservertweb23.appearance;

import org.springframework.stereotype.Service;

@Service
public class AppearanceService {
    private final AppearanceRepository appearanceRepository;

    public AppearanceService(AppearanceRepository appearanceRepository){
        this.appearanceRepository=appearanceRepository;
    }

    public Appearance saveAppearance(Appearance appearance){
        return appearanceRepository.save(appearance);
    }
}
