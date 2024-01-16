package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadores;

    public void cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados){
        if(dados.id() == null){
            throw new ValidacaoException("Id da consulta não pode ser nulo");
        }

       var consulta = consultaRepository.getReferenceById(dados.id());

       validadores.forEach(v -> v.validar(dados));

       consulta.cancelar(dados.motivo());

    }

}
