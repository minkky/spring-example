import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/**/*.xml"})
public class ControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Inject
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMVC;

    @Before
    public void setup(){
        this.mockMVC = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        logger.info("setup...");
    }

    @Test
    public void testDoA() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/doA"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDoB() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/doB"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDoC() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/doC?msg=world"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDoD() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/doD"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("productVO"));
    }

    @Test
    public void testDoE() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/doE"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/doF?msg=this+is+the+message+with+redirected."));
    }

    @Test
    public void testDoJson() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("/doJson"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

}
