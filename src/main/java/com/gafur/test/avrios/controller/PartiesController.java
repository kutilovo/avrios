package com.gafur.test.avrios.controller;

import com.gafur.test.avrios.model.BlockPartiesResponse;
import com.gafur.test.avrios.model.SearchRequest;
import com.gafur.test.avrios.service.BlockPartiesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("v1/events/parties")
public class PartiesController {

  private final BlockPartiesService blockPartiesService;

  @Operation(summary = "Get list of block parties by query")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Found the list of block parties",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = BlockPartiesResponse.class))}),
      @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
      @ApiResponse(
          responseCode = "404",
          description = "Block parties not found",
          content = @Content)})
  @GetMapping("/blockparties")
  @Cacheable(value = "blockParties")
  public ResponseEntity<BlockPartiesResponse> getBlockParties(
      @RequestParam(value = "district", required = false) String district,
      @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
      @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
  ) {
    log.info(String.format("Processing get block parties request with parameters, "
        + "district: %s, page: %s, size: %s", district, page, size));
    return ResponseEntity.ok(blockPartiesService.getBlockParties(
        new SearchRequest(district, new Pageable(page, size, List.of()))
    ));
  }
}

