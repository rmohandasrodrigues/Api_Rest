package com.conectsistemas.apirest.services.impl;

import com.conectsistemas.apirest.Repository.UserRepository;
import com.conectsistemas.apirest.domain.User;
import com.conectsistemas.apirest.domain.dto.UserDTO;
import com.conectsistemas.apirest.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID = 1;
    public static final String NOME = "Valdir";
    public static final String EMAIL = "valdir@gmail.com";
    public static final String PASSWORD = "1234";
    @InjectMocks // Cria uma instancia real da classe UserServiceImplTest
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        // Quando o metodo userRepository.findById() qualquer valor for passado para ele retorne o optionalUser
        when(userRepository.findById(anyInt())).thenReturn(optionalUser);

        // Fazer a chamada para o metodo que será testado.
        User response = userService.findById(ID);

        // Testa se meu response não é nulo.
        assertNotNull(response);
        // Assegurar que sempre o retorno como a classe User sera igual a response.
        assertEquals(User.class, response.getClass());
        // Assegura que sempre o id seja igual o da resposta.
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado!"));

        try{
            userService.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado!", ex.getMessage());
        }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void upadate() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = new User(ID, NOME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NOME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NOME, EMAIL, PASSWORD));


    }
}