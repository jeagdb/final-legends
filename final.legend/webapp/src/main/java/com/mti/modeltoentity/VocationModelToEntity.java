package com.mti.modeltoentity;

import com.mti.domain.entity.VocationEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.VocationModel;
import utils.Converter;

@ConvertService
public class VocationModelToEntity implements Converter.Reversible<VocationModel, VocationEntity> {
    @Override
    public VocationEntity convert(VocationModel from) {
        return new VocationEntity(from.getId(), from.getName());
    }

    @Override
    public VocationModel revertConvert(VocationEntity from) {
        return new VocationModel(from.id, from.name);
    }
}
