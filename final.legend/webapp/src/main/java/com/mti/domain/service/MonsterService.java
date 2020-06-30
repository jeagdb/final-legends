package com.mti.domain.service;

import com.mti.persistence.repository.MonsterRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MonsterService {

    @Resource
    MonsterRepository monsterRepository;

    public MonsterService() {

    }

    public Integer getDamagesMonsterSkill(Integer monsterId) {
        //Integer damagesMonster = monsterRepository.;
        return 5;
    }
}
