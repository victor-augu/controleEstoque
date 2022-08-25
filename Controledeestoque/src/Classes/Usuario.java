/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Usuario {
    private Integer idUsuario;
    private String nome;
    private Date dataNacimento;
    private String situacao;
    private String login;
    private String senha;
    private Date dataAtivacao;
    private Date dataDesativacao;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNacimento
     */
    public Date getDataNacimento() {
        return dataNacimento;
    }

    /**
     * @param dataNacimento the dataNacimento to set
     */
    public void setDataNacimento(Date dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the dataAtivacao
     */
    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    /**
     * @param dataAtivacao the dataAtivacao to set
     */
    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    /**
     * @return the dataDesativacao
     */
    public Date getDataDesativacao() {
        return dataDesativacao;
    }

    /**
     * @param dataDesativacao the dataDesativacao to set
     */
    public void setDataDesativacao(Date dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

   
}
