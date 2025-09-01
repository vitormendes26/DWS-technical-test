package com.dws.isobar.fm.bands.domain.service;

import com.dws.isobar.fm.bands.api.model.BandFilterDTO;
import com.dws.isobar.fm.bands.domain.model.Band;

import java.util.List;
import java.util.UUID;

public interface BandService {

    Band getById(UUID id);

    List<Band> getAll(BandFilterDTO bandFilterDTO);

}
