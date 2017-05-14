package com.jetbrains.intern;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ZodiacRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void zodiacBadRequest() throws Exception {

        mockMvc.perform(get("/zodiac/2/45"))
                //.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("Invalid date!!!")));

    }

    @Test
    public void zodiacPisces() throws Exception {

        GregorianCalendar dateFrom = new GregorianCalendar(2016, 1, 20);
        GregorianCalendar dateTo   = new GregorianCalendar(2016, 2, 21);

        while(!dateFrom.equals(dateTo)) {

            int month = dateFrom.get(GregorianCalendar.MONTH) + 1;
            int day = dateFrom.get(GregorianCalendar.DATE);

            mockMvc.perform(get("/zodiac/" + month + "/" + day))
                    //.andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.month").value(month))
                    .andExpect(jsonPath("$.day").value(day))
                    .andExpect(jsonPath("$.name").value("Рыбы"));

            dateFrom.add(GregorianCalendar.DATE, 1);

        }

    }

    @Test
    public void zodiacAquarius() throws Exception {

        GregorianCalendar dateFrom = new GregorianCalendar(2016, 0, 21);
        GregorianCalendar dateTo   = new GregorianCalendar(2016, 1, 20);

        while(dateFrom.before(dateTo)) {

            int month = dateFrom.get(GregorianCalendar.MONTH) + 1;
            int day = dateFrom.get(GregorianCalendar.DATE);

            mockMvc.perform(get("/zodiac/" + month + "/" + day))
                    //.andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.month").value(month))
                    .andExpect(jsonPath("$.day").value(day))
                    .andExpect(jsonPath("$.name").value("Водолей"));

            dateFrom.add(GregorianCalendar.DATE, 1);

        }

    }

    @Test
    public void zodiacCapricorn() throws Exception {

        GregorianCalendar dateFrom = new GregorianCalendar(2016, 11, 23);
        GregorianCalendar dateTo   = new GregorianCalendar(2017, 0, 21);

        while(dateFrom.before(dateTo)) {

            int month = dateFrom.get(GregorianCalendar.MONTH) + 1;
            int day = dateFrom.get(GregorianCalendar.DATE);

            mockMvc.perform(get("/zodiac/" + month + "/" + day))
                    //.andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.month").value(month))
                    .andExpect(jsonPath("$.day").value(day))
                    .andExpect(jsonPath("$.name").value("Козерог"));

            dateFrom.add(GregorianCalendar.DATE, 1);

        }

    }


}
