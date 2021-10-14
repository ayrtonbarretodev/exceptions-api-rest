package br.com.ayrton.excecoesspringapirest;

import br.com.ayrton.excecoesspringapirest.model.Funcionario;
import br.com.ayrton.excecoesspringapirest.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ExcecoesspringapirestApplication implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExcecoesspringapirestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Funcionario f1 = new Funcionario(null, "Ayrton", "Barreto", "ayrtonsbarreto@gmail.com");
        Funcionario f2 = new Funcionario(null, "Alana", "Larissa", "alanalarissa@gmail.com");

        funcionarioRepository.saveAll(Arrays.asList(f1,f2));
    }
}
