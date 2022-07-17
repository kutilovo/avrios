package com.gafur.test.avrios.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.gafur.test.avrios.Application;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class PartiesControllerIntegrationTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private static final String CONTENT_TYPE = "application/json";

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
    final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
            .get("/v1/events/parties/blockparties")
        )
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.pageNumber")
            .value("1")
        )
        .andReturn();
    assertEquals(CONTENT_TYPE, mvcResult.getResponse().getContentType());
  }
}
