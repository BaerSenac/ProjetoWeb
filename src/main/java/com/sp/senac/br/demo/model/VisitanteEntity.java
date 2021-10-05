package com.sp.senac.br.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "Visitante")
public class VisitanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nomeVisitante;

    @Column
    private String emailVisitante;

    @Column
    private String telefone;

    @Column
    private boolean desejaReceber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public String getEmailVisitante() {
        return emailVisitante;
    }

    public void setEmailVisitante(String emailVisitante) {
        this.emailVisitante = emailVisitante;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isDesejaReceber() {
        return desejaReceber;
    }

    public void setDesejaReceber(boolean desejaReceber) {
        this.desejaReceber = desejaReceber;
    }
}
