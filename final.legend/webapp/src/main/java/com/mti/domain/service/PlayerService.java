package com.mti.domain.service;

import com.mti.persistence.repository.PlayerRepository;
import org.springframework.transaction.annotation.Transactional;

public class PlayerService {

    private PlayerRepository playerRepository;
    // DI
    public PlayerService(final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @Transactional
    public void save() {
    }
}
