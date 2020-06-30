package com.mti.domain.service;

import com.mti.domain.entity.VocationSkillEntity;
import com.mti.modeltoentity.VocationSkillModelToEntity;
import com.mti.persistence.model.VocationSkillModel;
import com.mti.persistence.repository.VocationSkillRepository;
import org.springframework.stereotype.Service;
import utils.IterableUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VocationSkillService {

    private VocationSkillRepository vocationSkillRepository;
    public VocationSkillModelToEntity vocationSkillModelToEntity;

    public VocationSkillService(VocationSkillRepository vocationSkillRepository, VocationSkillModelToEntity vocationSkillModelToEntity) {
        this.vocationSkillRepository = vocationSkillRepository;
        this.vocationSkillModelToEntity = vocationSkillModelToEntity;
    }

    public List<VocationSkillEntity> findAllVocationSkills() {
        final var allVocationSkills = IterableUtils.toList(vocationSkillRepository.findAll());
        return allVocationSkills.stream()
                .map(vocationSkillModel -> vocationSkillModelToEntity.convert(vocationSkillModel))
                .collect(Collectors.toList());
    }
}
