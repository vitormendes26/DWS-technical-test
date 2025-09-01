package com.dws.isobar.fm.bands.infrastructure.client;

import com.dws.isobar.fm.bands.adapter.band.BandAdapterRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bandClient", url = "${integration.bands.url}")
public interface BandClient {

    @GetMapping( value = "/api/bands", produces = "application/json")
    List<BandAdapterRecord> fetchAll();

}
