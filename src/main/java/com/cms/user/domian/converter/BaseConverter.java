package com.cms.user.domian.converter;

public interface BaseConverter<S, T> {

    /**
     * Convert entity to response
     * @param source
     * @return
     */
    T convertToResponse(S source);

    /**
     * Convert response to entity
     * @param source
     * @return
     */
    S convertToEntity(T source);


}
