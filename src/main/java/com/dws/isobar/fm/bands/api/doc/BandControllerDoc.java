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
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(example = """
                                        {
                                            "id": "de548477-205e-4802-8908-e71d3ad67be0",
                                            "name": "Coma",
                                            "image": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                                            "genre": "rock",
                                            "biography": "For the french punk band, see C.O.M.A.\\nThere are multiple artists with this name:\\n\\n1) Coma was a Polish alternative rock band, founded in 1998 in Łódź by Dominik Witczak (guitar) and Tomasz Stasiak (drums). They disbanded in 2019.\\n\\nThe first album \\"Pierwsze Wyjście z Mroku\\" was released in 2004. After winning the Rock Festival in Węgorzewo the band became very popular in Poland. The second album, \\"Zaprzepaszczone Siły Wielkiej Armii Świętych Znaków\\" was released in May 2006.  <a href=\\"https://www.last.fm/music/Coma\\">Read more on Last.fm</a>",
                                            "numPlays": 7660252,
                                            "albums": [
                                                "b96e45bf-f2a9-4267-be5c-f53b08293b1d"
                                            ]
                                        }
                                    """))),

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
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(example = """ 
                                    [
                                        {
                                            "id": "2386cd66-e923-4e8e-bf14-2eebe2e9b973",
                                            "name": "3 Doors Down",
                                            "image": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
                                            "genre": "rock",
                                            "biography": "3 Doors Down is a post-Grunge influenced Alternative rock group from Escatawpa, Mississippi, United States that formed in 1996. Consisting of Brad Arnold (vocals), Chet Roberts (guitar, a replacement for Matt Roberts), Todd Harrell (bass), Chris Henderson (guitar), and Greg Upchurch (drums), the band is known for several successful rock singles such as \\"Here Without You\\" and \\"Kryptonite\\". The group signed to Universal Records in 2000.\\n\\nUniversal then released their first album, 'The Better Life', and they garnered a big fan response. <a href=\\"https://www.last.fm/music/3+Doors+Down\\">Read more on Last.fm</a>",
                                            "numPlays": 4471468,
                                            "albums": [
                                                "d2c4953c-08f2-49cb-9050-8f39b6f3803d",
                                                "c457adc4-3640-4d00-9e4c-239aa6a63ea8"
                                            ]
                                        }
                                    ]
                                """))),

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
