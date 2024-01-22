package model;

import java.util.Date;

public class Usuario {

    // Atributes
    
    private int id;

    private String nome;

    private int idade;

    private String email;

    private String senha;

    private Date dt_cadastro;

    // Getters and Setters

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

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
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

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	// Constructor

	public Usuario(String nome, int idade, String email, String senha, Date dt_cadastro){
		setNome(nome);
		setIdade(idade);
		setEmail(email);
		setSenha(senha);
		setDt_cadastro(dt_cadastro);
	}

	public Usuario(){

	}

}
