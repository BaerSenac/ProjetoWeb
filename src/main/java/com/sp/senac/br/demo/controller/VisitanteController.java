package com.sp.senac.br.demo.controller;

import com.sp.senac.br.demo.dao.RepositorioDAO;
import com.sp.senac.br.demo.dao.VisitanteDAO;
import com.sp.senac.br.demo.model.RepositorioEntity;
import com.sp.senac.br.demo.model.VisitanteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VisitanteController {

    @Autowired
    private VisitanteDAO dao;

    @PostMapping("/salvarVisitante")
    public String salvarVisitante(@ModelAttribute VisitanteEntity visitante) {
        dao.save(visitante);
        return "index";
    }

    @GetMapping("/cadastro_visitante")
    public ModelAndView getVisitante(VisitanteEntity visitante) {
       ModelAndView mv = new ModelAndView("cadastro_visitante");
       mv.addObject("visitante", visitante);


        return mv;
    }

    @GetMapping("/listar_visitantes")
    public ModelAndView listaVisitantes() {
        List<VisitanteEntity> visitantes = dao.findAll();
        ModelAndView mv = new ModelAndView("listar_visitantes");
        mv.addObject("visitante", visitantes);

        return mv;
    }

    @GetMapping ("/editar_visitante/{id}")
    public ModelAndView editarVisitante(@PathVariable Integer id) {
        VisitanteEntity visitante =  dao.findById(id).get();
        ModelAndView mv = new ModelAndView("editar_visitante");
        mv.addObject("visitante", visitante);

        return mv;
    }

    @PostMapping ("/editarVisitante/{id}")
    public String editar (@ModelAttribute VisitanteEntity visitante, @PathVariable Integer id) {
        visitante.setId(id);
        dao.save(visitante);
        return "listar_visitantes";
    }

    @GetMapping("/excluir_visitante/{id}")
    public String excluir (@PathVariable Integer id){
        dao.deleteById(id);
        return "index";
    }

}
