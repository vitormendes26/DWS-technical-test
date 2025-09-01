package com.dws.isobar.fm.bands.adapter.band;

import com.dws.isobar.fm.bands.domain.model.Band;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BandAdapterMapper {

    public static Band toEntity(BandAdapterRecord bandAdapterRecord) {
        return new Band(bandAdapterRecord.id(),
                bandAdapterRecord.name(),
                bandAdapterRecord.image(),
                bandAdapterRecord.genre(),
                bandAdapterRecord.biography(),
                bandAdapterRecord.numPlays(),
                bandAdapterRecord.albums()
        );
    }

}
