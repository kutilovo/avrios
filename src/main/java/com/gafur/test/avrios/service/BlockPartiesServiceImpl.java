package com.gafur.test.avrios.service;

import com.gafur.test.avrios.model.BlockPartiesClientResponse;
import com.gafur.test.avrios.model.BlockPartiesResponse;
import com.gafur.test.avrios.model.BlockPartyDto;
import com.gafur.test.avrios.model.SearchRequest;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlockPartiesServiceImpl implements BlockPartiesService {

  private final BerlinDeClient berlinDeClient;

  @Override
  public BlockPartiesResponse getBlockParties(SearchRequest searchRequest) {
    BlockPartiesClientResponse response = berlinDeClient.getBlockParties(
        searchRequest.getPageable().getSize(),
        searchRequest.getPageable().getPage(),
        searchRequest.getDistrict()
    );
    return convertClientResponse(response, searchRequest.getPageable());
  }

  private BlockPartiesResponse convertClientResponse(
      BlockPartiesClientResponse clientResponse,
      Pageable pageable
  ) {
    return new BlockPartiesResponse(
        pageable.getPage(),
        clientResponse.getPageInfo().getItemsPerPage(),
        clientResponse.getPageInfo().getCount(),
        clientResponse.getBlockParties().stream()
            .map(blockParty -> new BlockPartyDto(
                blockParty.getId(),
                blockParty.getDistrict(),
                blockParty.getDescription(),
                blockParty.getStreet(),
                blockParty.getZipCode(),
                blockParty.getDateFrom(),
                blockParty.getDateTo(),
                blockParty.getTime(),
                blockParty.getTranslater(),
                blockParty.getMail(),
                blockParty.getUrl(),
                blockParty.getRemarks(),
                blockParty.getRssTitle()
            ))
            .collect(Collectors.toList())
    );
  }
}
