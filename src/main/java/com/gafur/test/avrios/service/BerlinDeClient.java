package com.gafur.test.avrios.service;

import com.gafur.test.avrios.model.BlockPartiesClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "berlin-de-client", url = "${avrios.berlin-de-url}")
public interface BerlinDeClient {

  /**
   * Send request to get block parties
   *
   * @param size
   * @param page
   * @param district
   * @return block parties with total count
   */
  @GetMapping("sen/web/service/maerkte-feste/strassen-volksfeste/index.php/index.json")
  BlockPartiesClientResponse getBlockParties(
      @RequestParam(value = "ipp", required = false) Integer size,
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "bezirk", required = false) String district
  );
}
