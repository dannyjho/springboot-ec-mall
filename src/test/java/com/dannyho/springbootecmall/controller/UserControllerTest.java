package com.dannyho.springbootecmall.controller;

import com.dannyho.springbootecmall.dao.UserDao;
import com.dannyho.springbootecmall.dto.UserLoginRequest;
import com.dannyho.springbootecmall.dto.UserRegisterRequest;
import com.dannyho.springbootecmall.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserDao userDao;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void register_success() throws Exception {
        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .email("test1@email.com")
                .password("123")
                .build();

        String json = objectMapper.writeValueAsString(userRegisterRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId", notNullValue()))
                .andExpect(jsonPath("$.email", equalTo("test1@email.com")))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));

        // 檢查資料庫中的密碼不爲明碼
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        assertNotEquals(userRegisterRequest.getPassword(), user.getPassword());
    }

    @Test
    public void register_invalidEmailFormat() throws Exception {
        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .email("InvalidEmailFormat").build();

        String json = objectMapper.writeValueAsString(userRegisterRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void register_emailAlreadyExist() throws Exception {
        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .email("test2@email.com")
                .password("123")
                .build();

        String json = objectMapper.writeValueAsString(userRegisterRequest);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        // 使用同個 Email 再次註冊
        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        // 使用同個 Email 再次註冊
        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void login_success() throws Exception {
        // 註冊一個帳號
        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .email("test3@gmail.com")
                .password("123")
                .build();

        register(userRegisterRequest);

        // 測試登入功能
        UserLoginRequest userLoginRequest = UserLoginRequest.builder()
                .email("test3@gmail.com")
                .password("123")
                .build();
        String json = objectMapper.writeValueAsString(userLoginRequest);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", notNullValue()))
                .andExpect(jsonPath("$.email", equalTo("test3@gmail.com")))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));
    }

    @Test
    public void login_invalidEmailFormat() throws Exception {
        // 註冊一個帳號
        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .email("test4@gmail.com")
                .password("123")
                .build();

        register(userRegisterRequest);

        // 測試登入功能
        UserLoginRequest userLoginRequest = UserLoginRequest.builder()
                .email("test4")
                .password("123")
                .build();
        String json = objectMapper.writeValueAsString(userLoginRequest);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    private void register(UserRegisterRequest userRegisterRequest) throws Exception {
        String json = objectMapper.writeValueAsString(userRegisterRequest);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated());
    }

    @Test
    public void login_wrongPassword() throws Exception {
        // 註冊一個帳號
        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .email("test5@gmail.com")
                .password("123")
                .build();

        register(userRegisterRequest);

        UserLoginRequest userLoginRequest = UserLoginRequest.builder()
                .email("test5@gmail.com")
                .password("wrongPassword")
                .build();

        String json = objectMapper.writeValueAsString(userLoginRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void login_userNotExist() throws Exception {
        UserLoginRequest userLoginRequest = UserLoginRequest.builder()
                .email("notExistUser@gmail.com")
                .password("123")
                .build();

        String json = objectMapper.writeValueAsString(userLoginRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }
}
