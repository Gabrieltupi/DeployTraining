package com.vemser.dbc.searchorganic.model;


import com.vemser.dbc.searchorganic.interfaces.IImpressao;
import com.vemser.dbc.searchorganic.utils.validadores.ValidadorCEP;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Schema(hidden = true)
@Entity(name = "ENDERECO")
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
    @SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "REGIAO")
    private String regiao;



}
