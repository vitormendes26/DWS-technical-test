package com.dws.isobar.fm.bands.adapter.band;

import java.util.List;
import java.util.UUID;

public record BandAdapterRecord(UUID id,
                                String name,
                                String image,
                                String genre,
                                String biography,
                                Long numPlays,
                                List<String> albums) {
}
