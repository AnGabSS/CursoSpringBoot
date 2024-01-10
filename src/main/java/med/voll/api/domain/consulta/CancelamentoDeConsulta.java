package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class CancelamentoDeConsulta {

    private ConsultaRepository consultaRepository;
    private LocalDateTime dataAgora = LocalDateTime.now();

    private LocalDateTime dataPermitida = dataAgora.plusHours(24);

    public void cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados){
       var consulta = consultaRepository.getReferenceById(dados.Id());

       if(dados.motivo() != null && consulta.getData().isBefore(dataPermitida)){
          // consulta.cancelar(dados.motivo());
       }

    }

}
