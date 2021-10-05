package com.sp.senac.br.demo.controller;

import com.sp.senac.br.demo.dao.RepositorioDAO;
import com.sp.senac.br.demo.model.RepositorioEntity;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RepositorioController {

    @Autowired
    private RepositorioDAO dao;

    @PostMapping("/salvarRepositorio")
    public String salvarRepositorio(@ModelAttribute RepositorioEntity repositorio) {
        dao.save(repositorio);
        return "index";
    }

    @GetMapping("/cadastrar_repositorio")
    public ModelAndView paginaCadastroRepositorio(RepositorioEntity repositorio) {
        ModelAndView mv = new ModelAndView("cadastro_repositorio");
        mv.addObject("repositorio", repositorio);

        return mv;
    }

    @GetMapping("/repositorios")
    public ModelAndView paginaRepositorio() {
        List<RepositorioEntity> repositorios = dao.findAll();
        ModelAndView mv = new ModelAndView("repositorios");
        mv.addObject("repositorios", repositorios);

        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        dao.deleteById(id);

        return "index";
    }

    @GetMapping ("/editar/{id}")
    public ModelAndView editarRepositorio(@PathVariable Integer id) {
        RepositorioEntity repositorio =  dao.findById(id).get();
        ModelAndView mv = new ModelAndView("editar_repositorio");
        mv.addObject("repositorio", repositorio);

        return mv;
    }

    @PostMapping ("/editarRepositorio/{id}")
    public String editar (@ModelAttribute RepositorioEntity repositorio, @PathVariable Integer id) {
        repositorio.setId(id);
        dao.save(repositorio);
        return "repositorios";
    }


}