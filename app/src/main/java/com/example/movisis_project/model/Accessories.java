package com.example.movisis_project.model;

public class Accessories {

    private String nome;
    private String tipo;
    private double preco;

    public Accessories(String nome, String tipo, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }
}