package br.com.ayrton.excecoesspringapirest.controller;

import br.com.ayrton.excecoesspringapirest.model.Funcionario;
import br.com.ayrton.excecoesspringapirest.model.exception.ResourceNotFoundException;
import br.com.ayrton.excecoesspringapirest.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionarios")
    public List<Funcionario> buscarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable(value = "id") Long funcionarioId) throws ResourceNotFoundException{
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id :: " + funcionarioId));
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping("/funcionarios")
    public Funcionario criarFuncionario(@Valid @RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable(value = "id") Long funcionarioId, @Valid @RequestBody Funcionario funcionarioDetalhes) throws ResourceNotFoundException{
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id :: " + funcionarioId));

        funcionario.setEmailId(funcionarioDetalhes.getEmailId());
        funcionario.setSobrenome(funcionarioDetalhes.getSobrenome());
        funcionario.setNome((funcionarioDetalhes.getNome()));
        final Funcionario atualizarFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(atualizarFuncionario);
    }

    @DeleteMapping("/funcionarios/{id}")
    public Map<String, Boolean> deletarFuncionario(@PathVariable(value = "id") Long funcionarioId) throws ResourceNotFoundException{
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado para este id :: " + funcionarioId));

        funcionarioRepository.delete(funcionario);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
