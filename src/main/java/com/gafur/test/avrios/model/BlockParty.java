package com.gafur.test.avrios.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlockParty {

  String id;

  @JsonProperty("bezirk")
  String district;

  @JsonProperty("bezeichnung")
  String description;

  @JsonProperty("strasse")
  String street;

  @JsonProperty("plz")
  String zipCode;

  @JsonProperty("von")
  String dateFrom;

  @JsonProperty("bis")
  String dateTo;

  @JsonProperty("zeit")
  String time;

  @JsonProperty("veranstalter")
  String translater;

  String mail;

  @JsonProperty("www")
  String url;

  @JsonProperty("bemerkungen")
  String remarks;

  @JsonProperty("rss_titel")
  String rssTitle;
}
