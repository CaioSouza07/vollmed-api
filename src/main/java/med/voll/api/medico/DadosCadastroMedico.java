package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

//Esse record chegou oficialmente no java 16, serve para criar uma classe imutavel mto mais enxuto que manualmente
public record DadosCadastroMedico(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}

//Segue abaixo exemplo do código acima sem utilizar o record, caso fosse feito em java 8
/*

public final class DadosCadastroMedicoExemplo {

    private final String atributoExemplo;
    private final String outroAtributoExemplo;

    public DadosCadastroMedicoExemplo(String atributoExemplo, String outroAtributoExemplo) {
        this.atributoExemplo = atributoExemplo;
        this.outroAtributoExemplo = outroAtributoExemplo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(atributoExemplo, outroAtributoExemplo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof DadosCadastroMedicoExemplo)) {
            return false;
        } else {
            DadosCadastroMedicoExemplo other = (DadosCadastroMedicoExemplo) obj;
            return Objects.equals(atributoExemplo, other.atributoExemplo)
                    && Objects.equals(outroAtributoExemplo, other.outroAtributoExemplo);
        }
    }

    public String getAtributoExemplo() {
        return this.atributoExemplo;
    }

    public String getOutroAtributoExemplo() {
        return this.outroAtributoExemplo;
    }
}


*/