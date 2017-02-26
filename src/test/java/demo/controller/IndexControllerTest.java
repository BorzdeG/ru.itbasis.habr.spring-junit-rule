package demo.controller;

import demo.service.CustomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class IndexControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@SpyBean
	@SuppressWarnings("unused")
	private CustomService customService;

	@Test
	public void testMethod() throws Exception {
		mockMvc.perform(get("/")
			                .content("test")
			                .accept(MediaType.APPLICATION_JSON)
		)
		       .andExpect(status().isOk())
		       .andExpect(content().string("custom value: test"))
		;
	}

}