package com.vemser.dbc.searchorganic.service;

import com.vemser.dbc.searchorganic.model.Cupom;
import com.vemser.dbc.searchorganic.repository.CupomRepository;
import org.springframework.stereotype.Service;

@Service
public class CupomService {
    CupomRepository repository = new CupomRepository();

    public void adicionarCupom(Cupom cupom) {
        try {
            repository.adicionar(cupom);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cupom: " + e.getMessage());
        }
    }

    public void listarCupons() {
        try {
            for (Cupom cupom : repository.listar()) {
                cupom.imprimir();
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar cupons: " + e.getMessage());
        }
    }

    public void imprimirCuponsDisponiveis() {
        try {
            for (Cupom cupom : repository.listar()) {
                if (cupom.isAtivo().equals("S")) {
                    System.out.println("Nome: " + cupom.getNomeCupom() + " Valor do cupom: " +
                            cupom.getTaxaDeDesconto() + " Status: " + cupom.isAtivo());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao imprimir cupons disponíveis: " + e.getMessage());
        }
    }

    public Cupom buscarCupomPorId(int id) {
        try {
            for (Cupom cupom : repository.listar()) {
                System.out.println("Verificando Cupom por Id:" + cupom.getCupomId());
                if (cupom.getCupomId() == id) {
                    System.out.println("Cupom encontrado:" + cupom.getCupomId());
                    cupom.imprimir();
                    return cupom;
                }
            }
            System.out.println("Cupom com ID " + id + " não encontrado");
        } catch (Exception e) {
            System.out.println("Erro ao buscar cupom por ID: " + e.getMessage());
        }
        return null;
    }

    public void atualizarCupom(int id, Cupom cupom) {
        try {
            if (cupom.getCupomId() == id) {
                System.out.println("Cupom encontrado, atualize as informações: " + cupom.getCupomId());
                repository.editar(id, cupom);
                System.out.println("Cupom atualizado com sucesso!");
                return;
            }
            System.out.println("Cupom não pode ser atualizado");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cupom: " + e.getMessage());
        }
    }

    public void removerCupom(int id) {
        try {
            repository.remover(id);
            System.out.println("Cupom removido com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao deletar cupom: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
