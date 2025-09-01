package com.dws.isobar.fm.bands.infrastructure.service;

import com.dws.isobar.fm.bands.adapter.band.BandAdapter;
import com.dws.isobar.fm.bands.api.model.BandFilterDTO;
import com.dws.isobar.fm.bands.domain.enums.OrderEnum;
import com.dws.isobar.fm.bands.domain.enums.SortEnum;
import com.dws.isobar.fm.bands.domain.exception.BandNotFoundException;
import com.dws.isobar.fm.bands.domain.model.Band;
import com.dws.isobar.fm.bands.domain.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BandServiceImpl implements BandService {

    private final BandAdapter bandAdapter;

    @Autowired
    public BandServiceImpl(BandAdapter bandAdapter) {
        this.bandAdapter = bandAdapter;
    }

    public Band getById(UUID id) {
        return bandAdapter.getAllAdapted()
                .stream()
                .filter(band -> band.getId().equals(id))
                .findFirst()
                .orElseThrow(BandNotFoundException::new);
    }

    public List<Band> getAll(BandFilterDTO bandFilterDTO) {
        List<Band> bands = bandAdapter.getAllAdapted();
        bands = filterBands(bands, bandFilterDTO);
        return bands;
    }

    private List<Band> filterBands(List<Band> bands, BandFilterDTO bandFilterDTO) {
        if (Objects.nonNull(bandFilterDTO.getName())) {
            bands = new ArrayList<>(bands.stream()
                    .filter(band ->
                            band.getName().toLowerCase().contains(bandFilterDTO.getName().toLowerCase())
                    ).toList());
        }

        Comparator<Band> bandComparator = Comparator.comparing(Band::getName);
        if (bandFilterDTO.getSort().equals(SortEnum.POPULARITY)) {
            bandComparator = Comparator.comparing(Band::getNumPlays);
        }
        if (bandFilterDTO.getOrder().equals(OrderEnum.DESC)) {
            bandComparator = bandComparator.reversed();
        }

        bands.sort(bandComparator);
        return bands;
    }

}
