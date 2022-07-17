package com.gafur.test.avrios.model;

import java.util.List;
import lombok.Value;

@Value
public class BlockPartiesResponse {

  Integer pageNumber;
  Integer pageSize;
  Integer totalCount;
  List<BlockPartyDto> blockParties;
}
