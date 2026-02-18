package com.mateuss.financeiro_api.dto;

public record LoginRequestDTO(String email, String senha) {

    @Override
    public String email() {
        return email;
    }

    @Override
    public String senha() {
        return senha;
    }
}
