package com.cms.user.domian.converter;

import com.cms.user.domian.dto.CourseDTO;
import com.cms.user.repository.entity.CourseEntity;

public class CourseConverter implements BaseConverter<CourseEntity, CourseDTO> {

    @Override
    public CourseDTO convertToResponse(CourseEntity source) {
        return null;
    }

    @Override
    public CourseEntity convertToEntity(CourseDTO source) {
        return null;
    }
}
