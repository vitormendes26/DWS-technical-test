package com.dws.isobar.fm.bands.adapter.band;

import com.dws.isobar.fm.bands.domain.model.Band;
import com.dws.isobar.fm.bands.infrastructure.client.BandClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandAdapter {

    private final BandClient bandClient;

    @Autowired
    public BandAdapter(BandClient bandClient) {
        this.bandClient = bandClient;
    }

    @Cacheable("bands")
    public List<Band> getAllAdapted() {
        return bandClient.fetchAll()
                    .stream()
                    .map(BandAdapterMapper::toEntity)
                    .collect(Collectors.toCollection(ArrayList::new));
    }

}
