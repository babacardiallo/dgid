package com.groupeidyal.dgid.dto;

import com.groupeidyal.dgid.domain.CommunauteArrondissementRurale;
import com.madtech.apitools.annotation.InputIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConfirmationRedressementDto {

    @InputIgnore(optional = true)
    private List<InfractionDto>  infractionDtos;

    @InputIgnore(optional = true)
    private String nomServiceParent;

    @InputIgnore(optional = true)
    private String nomServiceGrandParent;

    @InputIgnore(optional = true)
    private String titreDGSociete;

    @InputIgnore(optional = true)
    private AdresseDto adresseSocietedto;

    @InputIgnore(optional = true)
    private String textAccuseReception;

    @InputIgnore(optional = true)
    private String nomChefServiceGrandParent;

    @InputIgnore(optional = true)
    private String nomChefServiceParent;

    @InputIgnore(optional = true)
    private ArrayList<AccountDto> verificateurs;

    @InputIgnore(optional = true)
    private  String titreChefServiceParent;

    public ConfirmationRedressementDto() {
    }

    public ConfirmationRedressementDto(List<InfractionDto> infractionDtos,
                                       String nomServiceParent,
                                       String nomServiceGrandParent,
                                       String titreDGSociete,
                                       AdresseDto adresseSocietedto,
                                       String textAccuseReception,
                                       String nomChefServiceGrandParent,
                                       String nomChefServiceParent,
                                       ArrayList<AccountDto> verificateurs,
                                       String titreChefServiceParent) {
        this.infractionDtos = infractionDtos;
        this.nomServiceParent = nomServiceParent;
        this.nomServiceGrandParent = nomServiceGrandParent;
        this.titreDGSociete = titreDGSociete;
        this.adresseSocietedto = adresseSocietedto;
        this.textAccuseReception = textAccuseReception;
        this.nomChefServiceGrandParent = nomChefServiceGrandParent;
        this.nomChefServiceParent = nomChefServiceParent;
        this.verificateurs = verificateurs;
        this.titreChefServiceParent = titreChefServiceParent;
    }

    public List<InfractionDto> getInfractionDtos() {
        return infractionDtos;
    }

    public void setInfractionDtos(List<InfractionDto> infractionDtos) {
        this.infractionDtos = infractionDtos;
    }

    public String getNomServiceParent() {
        return nomServiceParent;
    }

    public void setNomServiceParent(String nomServiceParent) {
        this.nomServiceParent = nomServiceParent;
    }

    public String getNomServiceGrandParent() {
        return nomServiceGrandParent;
    }

    public void setNomServiceGrandParent(String nomServiceGrandParent) {
        this.nomServiceGrandParent = nomServiceGrandParent;
    }

    public String getTitreDGSociete() {
        return titreDGSociete;
    }

    public void setTitreDGSociete(String titreDGSociete) {
        this.titreDGSociete = titreDGSociete;
    }

    public AdresseDto getAdresseSociete() {
        return adresseSocietedto;
    }

    public void setAdresseSociete(AdresseDto adresseSocietedto) {
        this.adresseSocietedto = adresseSocietedto;
    }

    public String getTextAccuseReception() {
        return textAccuseReception;
    }

    public void setTextAccuseReception(String textAccuseReception) {
        this.textAccuseReception = textAccuseReception;
    }

    public String getNomChefServiceGrandParent() {
        return nomChefServiceGrandParent;
    }

    public void setNomChefServiceGrandParent(String nomChefServiceGrandParent) {
        this.nomChefServiceGrandParent = nomChefServiceGrandParent;
    }

    public String getNomChefServiceParent() {
        return nomChefServiceParent;
    }

    public void setNomChefServiceParent(String nomChefServiceParent) {
        this.nomChefServiceParent = nomChefServiceParent;
    }

    public ArrayList<AccountDto> getVerificateurs() {
        return verificateurs;
    }

    public void setVerificateurs(ArrayList<AccountDto> verificateurs) {
        this.verificateurs = verificateurs;
    }

    public String getTitreChefServiceParent() {
        return titreChefServiceParent;
    }

    public void setTitreChefServiceParent(String titreChefServiceParent) {
        this.titreChefServiceParent = titreChefServiceParent;
    }
}