package com.mateuss.financeiro_api.dto;

public class UsuarioDTORequest {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    public UsuarioDTORequest(String senha, String email, String sobrenome, String nome) {
        this.senha = senha;
        this.email = email;
        this.sobrenome = sobrenome;
        this.nome = nome;
    }

    public UsuarioDTORequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioDTORequest{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
