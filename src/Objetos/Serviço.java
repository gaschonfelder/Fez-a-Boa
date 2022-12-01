/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Gabriel
 */
public class Serviço {
    private String Empresa;
    private String CNPJEmpresa;
    private String Prestador;
    private String CPFPrestador;
    private String Serviço;
    private String Observação;
    private int horasTrab;
    
    public Serviço(){
        
    }

    public Serviço(String Empresa, String CNPJEmpresa, String Prestador, String CPFPrestador, String Serviço, String Observação, int horasTrab) {
        this.Empresa = Empresa;
        this.CNPJEmpresa = CNPJEmpresa;
        this.Prestador = Prestador;
        this.CPFPrestador = CPFPrestador;
        this.Serviço = Serviço;
        this.Observação = Observação;
        this.horasTrab = horasTrab;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getCNPJEmpresa() {
        return CNPJEmpresa;
    }

    public void setCNPJEmpresa(String CNPJEmpresa) {
        this.CNPJEmpresa = CNPJEmpresa;
    }

    public String getPrestador() {
        return Prestador;
    }

    public void setPrestador(String Prestador) {
        this.Prestador = Prestador;
    }

    public String getCPFPrestador() {
        return CPFPrestador;
    }

    public void setCPFPrestador(String CPFPrestador) {
        this.CPFPrestador = CPFPrestador;
    }

    public String getServiço() {
        return Serviço;
    }

    public void setServiço(String Serviço) {
        this.Serviço = Serviço;
    }

    public String getObservação() {
        return Observação;
    }

    public void setObservação(String Observação) {
        this.Observação = Observação;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
    }
    
    
}
