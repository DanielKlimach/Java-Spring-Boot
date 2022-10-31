package com.devProjeto.userProj.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository; //com essa importação e o extends agora tenhos as funcionalidades de banco de dados

import com.devProjeto.userProj.entidades.ProdutoModelo; //está suprindo o tipo do CrudRepository


public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer> { //escrevi extends crud dei Ctrl + Espaço
//<T, ID> = <type(elemento que irei utilizar como base para manipular dados[ex: cadastrar ou selecionar dados]), identificador(no nosso modelo definimos que o id é do tipo int,
//então aqui será integer)>

	
	//listar todos os produtos
	List<ProdutoModelo> findAll(); //basicamente este trecho está fazendo um select * from ProdutoModelo
	
	//pesquisar por codigo
	ProdutoModelo findByCodigo(int codigo); //este comando findByColunaQueQuerTrabalhar, se minha coluna id fosse codigo então seria findByCodigo();
	//entre parêntenteses é os parâmetros deste método, quando chama-lo terá que dar um valor int
	
	//remover produto
	void delete(ProdutoModelo produto);
	
	//Cadastrar/Alterar produto
	<ProdTempMod extends ProdutoModelo> ProdTempMod save(ProdTempMod entity);  //<S extends T> S save(S entity); onde (S é uma classe temporária que criarei no próprio parâmetro desse método, T é a classe  base que trabalharei)
	
	
}
