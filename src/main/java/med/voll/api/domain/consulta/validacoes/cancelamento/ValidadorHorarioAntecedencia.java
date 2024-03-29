package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosCancelamentoConsulta dados){
        var consulta = consultaRepository.getReferenceById(dados.id());
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, consulta.getData()).toHours();

        if(diferencaEmMinutos <  24){
            throw new ValidacaoException("Consulta deve ser cancelada com antencedencia minima de 24 horas");
        }
    }
}
