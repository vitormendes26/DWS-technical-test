package com.dws.isobar.fm.bands.api.model;

import com.dws.isobar.fm.bands.domain.enums.OrderEnum;
import com.dws.isobar.fm.bands.domain.enums.SortEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


@Schema(name = "BandFilterDTO", description = "Band Filters you can apply on service calls")
public class BandFilterDTO {

    @Schema(description = "Band name", example = "Nickelback", nullable = true)
    private final String name;

    @Schema(description = "Sort type", example = "ALPHABETICAL", allowableValues = {"ALPHABETICAL", "POPULARITY"}, nullable = true)
    private final SortEnum sort;

    @Schema(description = "Sort direction", example = "ASC", allowableValues = {"ASC", "DESC"}, nullable = true)
    private final OrderEnum order;

    public BandFilterDTO(String name, SortEnum sort, OrderEnum order) {
        this.name = Objects.nonNull(name) ? name : "";
        this.sort = Objects.nonNull(sort) ? sort : SortEnum.ALPHABETICAL;
        this.order = Objects.nonNull(order) ? order : (this.sort.equals(SortEnum.ALPHABETICAL) ? OrderEnum.ASC : OrderEnum.DESC);
    }

    public String getName() {
        return name;
    }

    public SortEnum getSort() {
        return sort;
    }

    public OrderEnum getOrder() {
        return order;
    }

}
