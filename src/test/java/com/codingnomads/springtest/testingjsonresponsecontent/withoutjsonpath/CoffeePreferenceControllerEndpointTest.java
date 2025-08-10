package com.codingnomads.springtest.testingjsonresponsecontent.withoutjsonpath;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

import com.codingnomads.springtest.TestUtil;
import com.codingnomads.springtest.usingtestresttemplate.UsingTestRestTemplateMain;
import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import com.codingnomads.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest(classes = UsingTestRestTemplateMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CoffeePreferenceControllerEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CoffeePreferenceRepo coffeePreferenceRepo;

    @Test
    @Order(1)
    public void testGetCoffeePerferenceByIdSuccessBehavior() throws Exception {
        final long coffeeId = 2;

        byte[] responseContent = mockMvc.perform(get("/coffee/" + coffeeId))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn()
                .getResponse()
                .getContentAsByteArray();

        CoffeePreference returnedCoffee = TestUtil.convertJsonBytesToObject(responseContent, CoffeePreference.class);

        assertThat(returnedCoffee.getId()).isEqualTo(coffeeId);
        assertThat(returnedCoffee.getIntensity()).isEqualTo(4);
        assertThat(returnedCoffee.getType()).isEqualTo("Espresso");
        assertThat(returnedCoffee.getSize()).isEqualTo(CoffeePreference.Size.SMALL);
        assertThat(returnedCoffee.isIced()).isFalse();
        assertThat(returnedCoffee.isSugar()).isTrue();
    }
}
