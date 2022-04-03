package in.nihilent.demotestingrestendpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc //--this annotation enables injection of MockMvc
public class HelloRestControllerTest {

	@Autowired
	private MockMvc mock;
	
	@Test
	public void helloTest() throws Exception {
		this.mock
		         .perform(get("/hello"))
		         .andExpect(status().isOk())
		         .andExpect(content().string("Hello"))
		         .andDo(print());
		
		
	}
	
	@Test
	public void helloWithParamTest() throws Exception {
		String param="nihilent";
		this.mock
		         .perform(get("/hellowithparam").param("name", param))
		         .andExpect(status().isOk())
		         .andExpect(content().string("Hello"+param))
		         .andDo(print());
		
		
	}
	
	@Test
	public void helloWithParamShouldNotRunSuccesfullyTest() throws Exception {
		//String param="nihilent";
		this.mock
		         .perform(get("/hellowithparam"))//.param("name", param))
		         .andExpect(status().isBadRequest())
		        // .andExpect(MockMvcResultMatchers.content().string("Hello"))
		         .andDo(print());
		
		
	}
	
	@Test
	public void createVisitorTest() throws Exception
	{
		ObjectMapper mapper=new ObjectMapper();
		Visitor visitor=new Visitor();
		visitor.setId(1);
		visitor.setName("ajit");
		String json = mapper.writeValueAsString(visitor);
		this.mock
		         .perform(post("/visitor").contentType(MediaType.APPLICATION_JSON).content(json))
		         
		         .andExpect(status().isCreated())
		          .andDo(print());
	}
	
	@Test
	public void deleteVisitorByIdTest() throws Exception {
		int id=1;
		this.mock
        .perform(delete("/visitor/"+id))
        .andExpect(status().isNoContent())
        .andDo(print());
		
		
	}
	@Test
	public void deleteVisitorByIdShouldThrowExceptionTest() throws Exception {
		int id=7;
		this.mock
        .perform(delete("/visitor/"+id))
        .andExpect(status().isNotFound())
        .andDo(print());
	
	}

	
	@Test
	public void updateVisitorTest() throws Exception
	{
		ObjectMapper mapper=new ObjectMapper();
		Visitor visitor=new Visitor();
		int id=1;
		visitor.setId(3);
		visitor.setName("amit");
		String json = mapper.writeValueAsString(visitor);
		this.mock
		         .perform(put("/visitor/"+id).contentType(MediaType.APPLICATION_JSON).content(json))
		         
		         .andExpect(status().isOk())
		          .andDo(print());
	}
	
	@Test
	public void findVisitorByIdTest() throws Exception
	{
		int id=2;
		this.mock
        .perform(get("/visitor/"+id))
        .andExpect(status().isOk())
        .andDo(print());
	}
	
	
	

	
}
