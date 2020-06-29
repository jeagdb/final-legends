package com.mti.domain.service;

import com.mti.domain.entity.VocationEntity;
import com.mti.modeltoentity.VocationModelToEntity;
import com.mti.persistence.model.VocationModel;
import com.mti.persistence.repository.VocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VocationService {

    private VocationRepository vocationRepository;
    public VocationModelToEntity vocationModelToEntity;

    public VocationService(final VocationRepository vocationRepository, final VocationModelToEntity vocationModelToEntity) {
        this.vocationRepository = vocationRepository;
        this.vocationModelToEntity = vocationModelToEntity;
    }

    public VocationEntity getVocationByName(String vocationName) {
        String standard_vocationName = vocationName.toLowerCase().replace('ô', 'o');
        Integer vocationId = 0;
        switch (standard_vocationName) {
            case "mage":
                vocationId = 1;
                break;
            case "guerrier":
                vocationId = 2;
                break;
            case "rodeur":
                vocationId = 3;
                break;
            default: vocationId = -1;
        }
        if (vocationId == -1) {
            return null;
        }
        final Optional<VocationModel> vocationModel = vocationRepository.findById(vocationId);
        if (vocationModel.isPresent()) {
            return vocationModelToEntity.convert(vocationModel.get());
        }
        return null;
    }
}
