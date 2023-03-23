package com.tkeeps.mapper;

import com.tkeeps.entity.Locatie;
import com.tkeeps.dto.LocatieDto;

public interface LocatieMapper {
    Locatie locatieDtoToLocatie(LocatieDto locatieDto);
    LocatieDto locatieToLocatieDto(Locatie locatie);
}
