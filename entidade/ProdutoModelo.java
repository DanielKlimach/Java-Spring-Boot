package com.devProjeto.userProj.entidades;

import javax.persistence.Column;
import javax.persistence.Entity; //aperte Ctrl + Shift + O para fazer as importações automáticas, não escolha o hibernate,
//OU Ctrl + espaço no anotation que deseja fazer a importação
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //mapeaia a classe para que o programa saiba que esta classe é uma tabela, o @table name também faz parte e já nomeia a tabela que essa classe representa
@Table(name = "tb_Produto")
public class ProdutoModelo {
	
	@Id //estabelece que a variável id é o meu ID no mapeamento que estou fazendo para o meu banco de dados e o programa (sts)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="valor")
	private double valor;
	

	//Cliquei com botão direito na tela de cógigos, fui em Source > generate getters e setters e selecionei meus atributos, então gerou automaticamente.
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
RespostaModelo:
package com.devProjeto.userProj.entidades;

public class RespostaModelo {
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}

