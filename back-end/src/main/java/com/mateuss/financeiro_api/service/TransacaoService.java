package com.mateuss.financeiro_api.service;

public interface TransacaoService {
    void adicionarTransacao();
    void atualizarTransacao();
    void lerTransacao();
    void listarTransacao();
    void deletarTransacao();
}
