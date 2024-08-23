package br.com.fiap.primeira_api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cliente_nome", length = 200, nullable = false)
    private String nome;
    @Column(name = "cliente_email", length = 200, nullable = false, unique = true)
    private String email;
    @Column(name = "cliente_senha")
    private String senha;
    @Column(name = "cliente_altura")
    private double altura;
    @Column(name = "cliente_ano_nascimento")
    private int anoNascimento;
    @Column(name= "data_nascimento")
    private Date dataNascimento;
    @Column(name = "cliente_cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
