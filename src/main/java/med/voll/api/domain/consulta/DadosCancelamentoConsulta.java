package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCancelamentoConsulta (
        Long id,
        @NotBlank
        String motivo
        ){

}
