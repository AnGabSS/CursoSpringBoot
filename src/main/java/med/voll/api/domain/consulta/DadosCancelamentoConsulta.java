package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotBlank;

public record DadosCancelamentoConsulta (
        Long Id,
        @NotBlank
        String motivo){

}
