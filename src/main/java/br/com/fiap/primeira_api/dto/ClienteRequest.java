package br.com.fiap.primeira_api.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class ClienteRequest {
    @NotBlank(message = "O nome do cliente é obrigatório")
    private String nome;
    @Email(message = "O email está fora de padrão")
    private String email;
    @Size(min = 8, message = "A senha deve ter no mínimo 8 dígitos")
    private String senha;
    @DecimalMin(value = "1.2", message = "A altura mínima é 1.2")
    private double altura;
    @Min(value = 1900, message = "O ano deve ser posterior a 1900")
    @Max(value = 2024, message = "O ano deve ser anterior ao ano atual")
    private int anoNascimento;
    private Date dataNascimento;
    @CPF(message = "CPF fora do padrão")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
