//package com.livrosservice;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.livrosservice.exceptions.IdNaoEncontradoException;
//import com.livrosservice.model.Livro;
//import com.livrosservice.repository.LivroRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class LivrosServiceApplicationTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @Test
//    @DisplayName("Salvar um livro")
//    void salvar() throws Exception {
//        Livro livro = new Livro();
//        livro.setId(1);
//        livro.setTitulo("Livro 1");
//        livro.setAutor("Autor 1");
//        livro.setIsbn("12348789");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonLivro = objectMapper.writeValueAsString(livro);
//
//        mockMvc.perform(post("/livros")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(jsonLivro))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @DisplayName("Buscar um livro por id")
//    void buscarPorId() throws Exception {
//
//        mockMvc.perform(get("/livros/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.titulo").value("Livro 1"))
//                .andExpect(jsonPath("$.autor").value("Autor 1"))
//                .andExpect(jsonPath("$.isbn").value("12348789"));
//    }
//
//    @Test
//    @DisplayName("Buscar todos o livros")
//    void buscarTodos() throws Exception {
//        mockMvc.perform(get("/livros"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray());
//    }
//
//
//    @Test
//    @DisplayName("Retornar status 404 ao buscar livro por um id inexistente")
//    void buscarPorIdInexistente() throws Exception {
//        mockMvc.perform(get("/livros/0"))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$").doesNotExist());
//    }
//
//}
