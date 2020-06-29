package com.mti.legend.domain.modeltoentity;

import com.mti.legend.domain.entity.VocationEntity;
import com.mti.legend.utils.scope.ConvertService;
import com.mti.legend.persistence.model.VocationModel;
import com.mti.legend.utils.Converter;

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
