/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Gabriel
 */
public class Prestador {
    private String nome;
    private String email;
    private String sexo;
    private int idade;
    private String cpf;
    private String endereco;
    private String servicos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }
    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getServicos() {
        return servicos;
    }

    public String getSexo() {
        return sexo;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
