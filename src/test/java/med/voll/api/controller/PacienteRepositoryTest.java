package med.voll.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;

@SpringBootTest
public class PacienteRepositoryTest {

     @Autowired
     private PacienteRepository pacienteRepository;
    
     private static final Logger logger = LoggerFactory.getLogger(PacienteRepositoryTest.class);

    @Test
    void deveSalvarEPersistirPaciente() {
        // Criando um novo paciente
        Endereco endereco = new Endereco("Casada do Arvoreiro", "Parque das arvores", "04824010", "160", "Casa",
                "São Paulo", "SP");
        
        Paciente paciente = new Paciente(1L, "Gabriel Peter","gabriel_peter@hotmail.com", "11976854335","42243671816", endereco, true);
        Paciente salvo = pacienteRepository.save(paciente);
  
        // Verificando se o paciente foi salvo com sucesso
        assertNotNull(salvo.getId());
        assertEquals("Gabriel Peter", salvo.getNome());

        Paciente testeSalvo = pacienteRepository.findById(paciente.getId()).get();
        assertEquals("Gabriel Peter", testeSalvo.getNome());
        logger.info("Paciente recuperado: {}", testeSalvo.getEmail());
    }
}
