package com.vemser.dbc.searchorganic.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vemser.dbc.searchorganic.model.Cargo;
import com.vemser.dbc.searchorganic.model.Usuario;
import com.vemser.dbc.searchorganic.utils.TipoAtivo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    @NotBlank
    @Schema(description = "Nome do usuario", required = true, example = "Gabriel Antonio")
    private String nome;

    @NotBlank
    @Schema(description = "Sobrenome do usuario", required = true, example = "Nunes de Souza")
    private String sobrenome;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Data de nascimento do usuario", required = true, example = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Schema(description = "CPF", required = true, example = "46473219080")
    private String cpf;

    @NotNull
    @Schema(description = "Email", required = true, example = "Gabriel.nunes@dbccompany.com.br")
    private String email;

    @NotNull
    @NotBlank
    @Schema(description = "Login", required = true, example = "Tupi_Uzumaki321")
    private String login;

    @Schema(description = "Usuário ativo ou desativado", required = true, example = "S")
    private TipoAtivo tipoAtivo = TipoAtivo.S;
    private Set<CargoDTO> cargos = new HashSet<>();
    @Schema(description = "Carteira do usuario", required = true, example = "S")
    private CarteiraDTO carteira;

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.dataNascimento = usuario.getDataNascimento();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
        this.login = usuario.getLogin();
        this.tipoAtivo = usuario.getTipoAtivo();
        this.carteira = new CarteiraDTO(usuario.getCarteira());
        for (Cargo cargo : usuario.getCargos()) {
            this.cargos.add(new CargoDTO(cargo));
        }
    }
}
