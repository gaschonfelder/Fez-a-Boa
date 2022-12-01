/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Gabriel
 */
public class Empresa {
    private String razaoSocial;
    private String enderenco;
    private String telefone;
    private String email;
    private String CNPJ;

    public Empresa(String razaoSocial, String enderenco, String telefone, String email, String CNPJ) {
        this.razaoSocial = razaoSocial;
        this.enderenco = enderenco;
        this.telefone = telefone;
        this.email = email;
        this.CNPJ = CNPJ;
    }
    
    public Empresa(){
        
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(String enderenco) {
        this.enderenco = enderenco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
    
    
    
}
