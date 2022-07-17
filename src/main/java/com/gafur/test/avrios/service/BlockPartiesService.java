package com.gafur.test.avrios.service;

import com.gafur.test.avrios.model.BlockPartiesResponse;
import com.gafur.test.avrios.model.SearchRequest;
import javax.validation.constraints.NotNull;

public interface BlockPartiesService {

  /**
   * Get block parties by search request
   *
   * @param searchRequest request with search parameters and pagination
   * @return pageable response with block parties
   */
  BlockPartiesResponse getBlockParties(@NotNull SearchRequest searchRequest);
}
