package com.ufes.sistemalog;

public interface ILogAdapter {
    void logOperacao(String operacao, String nome, String usuario);
    void logFalhaOperacao(String operacao, String nome, String usuario, String mensagemErro);
}
