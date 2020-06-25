package com.mti.modeltoentity;

import com.mti.domain.entity.ClassEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.ClassModel;
import utils.Converter;

@ConvertService
public class ClassModelToEntity implements Converter.Reversible<ClassModel, ClassEntity> {
    @Override
    public ClassEntity convert(ClassModel from) {
        return new ClassEntity(from.getId(), from.getName());
    }

    @Override
    public ClassModel revertConvert(ClassEntity from) {
        return new ClassModel(from.id, from.name);
    }
}
