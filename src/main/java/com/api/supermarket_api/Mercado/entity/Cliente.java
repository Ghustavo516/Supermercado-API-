package com.api.supermarket_api.Mercado.entity;

import javax.persistence.*;

//Entidade Clinte
@Entity
@Table(name = "cliente")
public class Cliente {
    //Declaração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    //Declaração da coluna nome
    @Column(nullable = false)
    private String nome;

    //Declaração da coluna 
    @Column(nullable = false, unique = true)
    private int codigo;

    public Cliente() {
        // Construtor padrão é necessário para o JPA
    }

    public Cliente(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    //getter and setters Id
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //getter and setters Nome
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    //getter and setters Codigo
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }  
}
