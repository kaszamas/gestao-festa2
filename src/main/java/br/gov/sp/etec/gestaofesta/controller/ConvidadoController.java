package br.gov.sp.etec.gestaofesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaofesta.model.Convidado;
import br.gov.sp.etec.gestaofesta.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {

	@Autowired
	ConvidadoRepository repository;
	
	
	
	@GetMapping("cadastro-convidado")
	public String abrirTelaCadastro() {
		return "convidado";
	}
	@PostMapping("salvar-convidado")
	public ModelAndView salvarConvidado(Convidado convidado) {
		 repository.save(convidado);
		 List<Convidado> lista = repository.findAll();
		 ModelAndView view = new ModelAndView("lista-convidado");
		 view.addObject("convidados",lista);
		 return view;
	 }
	@GetMapping("editar/{id}")
	public ModelAndView editarConvidado(@PathVariable Long id) {
		Convidado convidado = repository.findById(id).get();
		ModelAndView view = new ModelAndView("convidado-editar");
		view.addObject("convidado",convidado);
		return view;
	}
	@GetMapping("excluir/{id}")
	public ModelAndView excluirConvidado(@PathVariable Long id) {
		repository.deleteById(id);
		 List<Convidado> lista = repository.findAll();
		 ModelAndView view = new ModelAndView("lista-convidado");
		 view.addObject("convidados",lista);
		 return view;
		
	}
	
}
