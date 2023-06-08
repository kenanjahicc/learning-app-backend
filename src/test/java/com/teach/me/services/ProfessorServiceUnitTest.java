//package com.teach.me.services;
//
//import com.teach.me.data.ProfessorTest;
//import com.teach.me.models.ProfessorDto;
//import com.teach.me.repositories.ProfessorRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//@RunWith(SpringRunner.class)
//public class ProfessorServiceUnitTest {
//    @MockBean
//    private ProfessorRepository professorRepository;
//
//    @TestConfiguration
//    static class ProfessorServiceTestConfiguration {
//
//        @Bean
//        @Primary
//        public ProfessorService ProfessorService(ProfessorRepository professorRepository) {
//            return new ProfessorService(professorRepository);
//        }
//    }
//
//    @Autowired
//    private ProfessorService professorService;
//
//    @Test
//    public void givenValidId_whenGetProfessor_thenProfessorShouldBeFound() {
//        long id = 1L;
//        Mockito.when(professorRepository.findById(id))
//                .thenReturn(Optional.of(ProfessorTest.professor()));
//
//        ProfessorDto resultProfessor = professorService.getProfessor(id);
//
//        assertThat(resultProfessor.getFullName()).isEqualTo("Željko Jurić");
//    }
//
//    @Test
//    public void givenInvalidId_whenGetProfessor_thenExceptionShouldBeThrown() {
//        assertThatThrownBy(() -> professorService.getProfessor(3L))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessageContaining("does not exist");
//    }
//
//}
