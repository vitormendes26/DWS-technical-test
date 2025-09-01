package com.dws.isobar.fm.bands.api.doc;

import com.dws.isobar.fm.bands.api.model.BandFilterDTO;
import com.dws.isobar.fm.bands.domain.model.Band;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Tag(name = "Bands", description = "Operations related to band data retrieval")
public interface BandControllerDoc {

    @Operation(summary = "Service responsible for retrieving all bands information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data returned successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),

            @ApiResponse(responseCode = "400", description = "Wrong parameter value",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(example = """
                                        {
                                            "status": 400,
                                            "error": "Bad Request",
                                            "message": "Invalid parameter value provided.",
                                            "path": "/v1/bands",
                                            "timestamp": "2025-09-01T16:36:30"
                                        }
                                    """))),
    })
    ResponseEntity<Band> getById(@PathVariable UUID id);

    @Operation(summary = "Service responsible for retrieving bands using ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data returned successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),

            @ApiResponse(responseCode = "404", description = "Band not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(example = """
                                        {
                                            "status": 404,
                                            "error": "Not Found",
                                            "message": "Sorry! Band was not found in our database",
                                            "path": "/v1/bands/{id}",
                                            "timestamp": "2025-09-01T16:36:30"
                                        }
                                    """))),
    })
    @GetMapping
    ResponseEntity<List<Band>> getAll(BandFilterDTO bandFilterDTO);

}
