//package com.decagon.decablogjavabe.infrastructure.controllers;
//
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.when;
//
//import com.decagon.decablogjavabe.domain.entities.AdminEntity;
//import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
//import com.decagon.decablogjavabe.domain.entities.AskQuestionEntity;
//import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
//import com.decagon.decablogjavabe.usercase.payload.request.AskQuestionRequest;
//import com.decagon.decablogjavabe.usercase.services.AskQuestionService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@ContextConfiguration(classes = {AskQuestionController.class})
//@ExtendWith(SpringExtension.class)
//class AskQuestionControllerTest {
//    @Autowired
//    private AskQuestionController askQuestionController;
//
//    @MockBean
//    private AskQuestionService askQuestionService;
//
//    /**
//     * Method under test: {@link AskQuestionController#createQuestion(AskQuestionRequest, Long)}
//     */
//    @Test
//    void testCreateQuestion() throws Exception {
//        AppUserEntity appUserEntity = new AppUserEntity();
//        appUserEntity.setAdminEntities(new ArrayList<>());
//        appUserEntity.setConfirmPassword("iloveyou");
//        appUserEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//        appUserEntity.setDecadevsEntityList(new ArrayList<>());
//        appUserEntity.setEmail("jane.doe@example.org");
//        appUserEntity.setId(123L);
//        appUserEntity.setPassword("iloveyou");
//        appUserEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//
//        AdminEntity adminEntity = new AdminEntity();
//        adminEntity.setAbout("About");
//        adminEntity.setAppUserEntity(appUserEntity);
//        adminEntity.setArticleEntityList(new ArrayList<>());
//        adminEntity.setAskQuestionEntityList(new ArrayList<>());
//        adminEntity.setCommentEntityList(new ArrayList<>());
//        adminEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//        adminEntity.setDisplayPicture("Display Picture");
//        adminEntity.setId(123L);
//        adminEntity.setLikeEntityList(new ArrayList<>());
//        adminEntity.setName("Name");
//        adminEntity.setPhoneNumber("4105551212");
//        adminEntity.setSpaceEntityList(new ArrayList<>());
//        adminEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//
//        AppUserEntity appUserEntity1 = new AppUserEntity();
//        appUserEntity1.setAdminEntities(new ArrayList<>());
//        appUserEntity1.setConfirmPassword("iloveyou");
//        appUserEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//        appUserEntity1.setDecadevsEntityList(new ArrayList<>());
//        appUserEntity1.setEmail("jane.doe@example.org");
//        appUserEntity1.setId(123L);
//        appUserEntity1.setPassword("iloveyou");
//        appUserEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//
//        DecadevsEntity decadevsEntity = new DecadevsEntity();
//        decadevsEntity.setAbout("About");
//        decadevsEntity.setAppUserEntity(appUserEntity1);
//        decadevsEntity.setArticleEntityList(new ArrayList<>());
//        decadevsEntity.setAskQuestionEntityList(new ArrayList<>());
//        decadevsEntity.setCommentEntities(new ArrayList<>());
//        decadevsEntity.setCompanyName("Company Name");
//        decadevsEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//        decadevsEntity.setCurrentRole("Current Role");
//        decadevsEntity.setDisplayPicture("Display Picture");
//        decadevsEntity.setId(123L);
//        decadevsEntity.setLikeEntityList(new ArrayList<>());
//        decadevsEntity.setName("Name");
//        decadevsEntity.setPhoneNumber("4105551212");
//        decadevsEntity.setResidence("Residence");
//        decadevsEntity.setSpaceEntityList(new ArrayList<>());
//        decadevsEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//
//        AskQuestionEntity askQuestionEntity = new AskQuestionEntity();
//        askQuestionEntity.setAdminEntity(adminEntity);
//        askQuestionEntity.setCommentEntityList(new ArrayList<>());
//        askQuestionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//        askQuestionEntity.setDecadevsEntity(decadevsEntity);
//        askQuestionEntity.setId(123L);
//        askQuestionEntity.setLikeEntityList(new ArrayList<>());
//        askQuestionEntity.setQuestions("Questions");
//        askQuestionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
//        when(askQuestionService.askQuestion((AskQuestionRequest) any(), (Long) any())).thenReturn(askQuestionEntity);
//
//        AskQuestionRequest askQuestionRequest = new AskQuestionRequest();
//        askQuestionRequest.setQuestions("Questions");
//        String content = (new ObjectMapper()).writeValueAsString(askQuestionRequest);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/create-question/{id}", 123L)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(askQuestionController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "{\"message\":\"Question Created Successfuly\",\"status\":true,\"timeCreated\":\"2022-11--16 15-16\",\"data\":{\"id"
//                                        + "\":123,\"createdAt\":\"0001-01--01 01-01\",\"updatedAt\":\"0001-01--01 01-01\",\"questions\":\"Questions\","
//                                        + "\"commentEntityList\":[],\"likeEntityList\":[]}}"));
//    }
//}
//
