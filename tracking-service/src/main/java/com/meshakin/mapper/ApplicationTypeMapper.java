package com.meshakin.mapper;


import com.meshakin.dto.ApplicationTypeDto;
import com.meshakin.entity.ApplicationTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationTypeMapper {

    ApplicationTypeDto toDto(ApplicationTypeEntity applicationTypeEntity);
    ApplicationTypeEntity toEntity(ApplicationTypeDto applicationTypeDto);

}
