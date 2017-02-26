package demo.controller;

import demo.service.CustomService;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(Parameterized.class)
@WebMvcTest
public class IndexControllerTest {
	private final String value;
	private final String expected;

	@ClassRule public static final SpringClassRule  SPRING_CLASS_RULE = new SpringClassRule();
	@Rule public final             SpringMethodRule springMethodRule  = new SpringMethodRule();

	@Autowired
	private MockMvc mockMvc;

	@SpyBean
	@SuppressWarnings("unused")
	private CustomService customService;

	public IndexControllerTest(String value, String expected) {
		this.value = value;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{"test", "custom value: test"}
			, {"test1", "custom value: test1"}
			, {"test2", "custom value: test2"}
		});
	}

	@Test
	public void testMethod() throws Exception {
		mockMvc.perform(get("/")
			                .content(value)
			                .accept(MediaType.APPLICATION_JSON)
		)
		       .andExpect(status().isOk())
		       .andExpect(content().string(expected))
		;
	}

}