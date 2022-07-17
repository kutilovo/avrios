package com.gafur.test.avrios.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Value;
import org.springdoc.core.converters.models.Pageable;

@Value
public class SearchRequest {

  @NotBlank
  String district;
  @NotNull
  Pageable pageable;
}
