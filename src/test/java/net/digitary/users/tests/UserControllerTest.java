package net.digitary.users.tests;

import net.digitary.users.controllers.UserController;
import net.digitary.users.dtos.UserDto;
import net.digitary.users.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value= UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    /**
     * Mock user dto in json format
     */
    private static final String EXPECTED_JSON="{\"id\":1,\"name\":\"PETER PARKER\",\"eMail\":\"SPIDERMAN@MARVEL.COM\""
            +",\"addressLine1\":\"1, MARVEL STREET\",\"addressLine2\":null,\"townCity\":\"New York\","
            +"\"postalCode\":\"zzzz\",\"country\":\"USA\",\"phoneNumber1\":null,\"phoneNumber2\":null,\"phoneNumber3\":null,\"dateLastView\":null}";

    private static final String EXPECTED_ALREADY_JSON="{\"id\":1,\"name\":\"PETER PARKER\",\"eMail\":\"SPIDERMAN@MARVEL.COM\""
            +",\"addressLine1\":\"1, MARVEL STREET\",\"addressLine2\":null,\"townCity\":\"New York\","
            +"\"postalCode\":\"zzzz\",\"country\":\"USA\",\"phoneNumber1\":null,\"phoneNumber2\":null,\"phoneNumber3\":null,\"dateLastView\":null}";

    /**
     * Mock user dto List in json format
     */
    private static final String  EXPECTED_LIST_JSON="[{\"id\":1,\"name\":\"PETER PARKER\",\"eMail\":\"SPIDERMAN@MARVEL.COM\""
            +",\"addressLine1\":\"1, MARVEL STREET\",\"addressLine2\":null,\"townCity\":\"New York\","
            +"\"postalCode\":\"zzzz\",\"country\":\"USA\",\"phoneNumber1\":null,\"phoneNumber2\":null,\"phoneNumber3\":null,\"dateLastView\":null}]";

    /**
     * User dto for tests
     */
    private static final UserDto userDto=new UserDto(1l, "PETER PARKER", "SPIDERMAN@MARVEL.COM",
            "1, MARVEL STREET", null, "New York","zzzz",
            "USA", null, null, null, null);


    /**
     * Setup the userservice mock beahvior
     */
    @Before
    public void setup(){
        when(userService.findById(1L)).thenReturn(userDto);
        when(userService.exists(1L)).thenReturn(Boolean.TRUE);
        doNothing().when(userService).save(any(UserDto.class));
        doNothing().when(userService).update(anyLong(),any(UserDto.class));
        doNothing().when(userService).delete(anyLong());
        doNothing().when(userService).refreshAllCachedUsers();

    }


    /**
     *  testing if find the user by id
     * @throws Exception
     */
    @Test
    public void findByIdTest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/users/1").accept(
                MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        verify(userService).findById(any(Long.class));
        JSONAssert.assertEquals(EXPECTED_JSON, result.getResponse()
                .getContentAsString(), false);

    }



    /**
     *  testing if not find the user by uncorect id
     * @throws Exception
     */
    @Test
    public void notFoundByIdTest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/users/2").accept(
                MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND.value(), status);


    }



    /**
     *  testing if the user is store on db(the service is mock)
     * @throws Exception
     */

    @Test
    public void saveTest() throws Exception{
      when(userService.exists("PETER PARKER")).thenReturn(Boolean.FALSE);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/users")
                .accept(MediaType.APPLICATION_JSON).content(EXPECTED_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        HttpServletResponse response = result.getResponse();

        assertEquals("Incorrect Response Status",HttpStatus.CREATED.value(), response.getStatus());
        verify(userService).save(any(UserDto.class));
        verify(userService).refreshAllCachedUsers();

    }

    @Test
    public void alreadySavedTest() throws Exception{
        when(userService.exists("PETER PARKER")).thenReturn(Boolean.TRUE);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/users")
                .accept(MediaType.APPLICATION_JSON).content(EXPECTED_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        HttpServletResponse response = result.getResponse();

        assertEquals("Incorrect Response Status",HttpStatus.CONFLICT.value(), response.getStatus());


    }

    @Test
    public void updateTest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/users/1")
                .accept(MediaType.APPLICATION_JSON).content(EXPECTED_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        HttpServletResponse response = result.getResponse();

        assertEquals("Incorrect Response Status",HttpStatus.OK.value(), response.getStatus());
        verify(userService).update(any(Long.class), any(UserDto.class));
        verify(userService).refreshAllCachedUsers();

    }

    @Test
    public void updateNotExistRecordTest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/users/2")
                .accept(MediaType.APPLICATION_JSON).content(EXPECTED_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        HttpServletResponse response = result.getResponse();

        assertEquals("Incorrect Response Status",HttpStatus.NOT_FOUND.value(), response.getStatus());


    }


    @Test
    public void deleteTest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/users/1");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        HttpServletResponse response = result.getResponse();

        assertEquals("Incorrect Response Status",HttpStatus.NO_CONTENT.value(), response.getStatus());
        verify(userService).delete(any(Long.class));
        verify(userService).refreshAllCachedUsers();


    }

    @Test
    public void deleteNotExistRecordTest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/users/2");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        HttpServletResponse response = result.getResponse();

        assertEquals("Incorrect Response Status",HttpStatus.NOT_FOUND.value(), response.getStatus());


    }
}
