package com.devProjeto.userProj.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devProjeto.userProj.entidades.ProdutoModelo;
import com.devProjeto.userProj.entidades.RespostaModelo;
import com.devProjeto.userProj.repositorio.ProdutoRepositorio;

@RestController //inicia as funcionalidades de controle de rotas
@RequestMapping("/api")// define que essa claase tem uma rota própria com o identificador único (seu endereço) /api
public class ProdutoControle {
	
	@Autowired //fornece um controle mais refinado sobre onde e como a fiação automática deve ser realizada 
	private ProdutoRepositorio acoes; //separo uma variável pára isso vinculada a classe que utiliza dos métodos que efetuará essas acoes
	
	//Listar Produtos
	@RequestMapping(value="/produtos", method=RequestMethod.GET) //este mapeamento dentro de uma classe jpa mapeada com a mesma anotation(@RequestMapping) está definindo um subdiretório(uma sub URL) com o method GET
	//como o value dele está vazio, este método "inicio" é o subdiretório principal!, ele que aparecerá se não definirmos um endereço completo (com um subdiretório não declarado na url)
	public @ResponseBody List<ProdutoModelo> listar() { //@ResponseBody é utilizado para que seja possível ser que o retorno seja exibido no navegador
		return acoes.findAll();
	}
	//cadastrar produtos
	@RequestMapping(value="/produtos", method=RequestMethod.POST) //eu posso ter o mesmo endereçamento no meu value, pois o meu method é diferente (um é GET e outro POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) { //uma requisição de corpo
		return acoes.save(produto);
	}
	
	//filtrar produtos
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) { //serve parra trabalhas com variável em uma url, como pode ver no requestMapping acima
		return acoes.findByCodigo(codigo);
	}
	
	//alterar produtos
	@RequestMapping(value="/produtos", method=RequestMethod.PUT) 
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//remover produtos
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
		
		RespostaModelo resposta = new RespostaModelo();
		
		try {
		ProdutoModelo produto = filtrar(codigo);
		
		this.acoes.delete(produto);
		resposta.setMensagem("Produto removido com sucesso!");
		}catch(Exception erro) {
			resposta.setMensagem("Falha ao remover: "+erro.getMessage());
		}
		return resposta;
		
	}

}
