package br.com.ayrton.excecoesspringapirest.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalhesErros {
    private Date dataHora;
    private String mensagem;
    private String detalhes;
}
