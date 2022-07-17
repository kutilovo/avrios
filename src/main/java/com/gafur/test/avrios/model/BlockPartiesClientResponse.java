package com.gafur.test.avrios.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class BlockPartiesClientResponse {

  @JsonProperty("results")
  PageInfo pageInfo;

  @JsonProperty("index")
  List<BlockParty> blockParties;

  @Data
  public class PageInfo {

    Integer count;

    @JsonProperty("items_per_page")
    Integer itemsPerPage;
  }
}
