package com.sda.carrent.mapper;

import com.sda.carrent.dto.DtoHolder;
import org.springframework.stereotype.Component;

@Component
public class DtoHolderMapper {

    public DtoHolder mapSuccessResponse(DtoHolder dtoHolder) {
        return dtoHolder;
    }

}


