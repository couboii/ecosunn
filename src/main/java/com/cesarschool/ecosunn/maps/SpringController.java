package com.cesarschool.ecosunn.maps;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping("")
    public String home(Model model) {
        return "home";
    }

    //CLIENTE - DIRETORIOS
    @GetMapping("/cliente")
    public String cliente(Model model) {
        return "cliente";
    }

    @GetMapping("/adicionarCliente")
    public String adicionarCliente(Model model) {
        return "adicionarCliente";
    }

    //FORNECEDOR - DIRETORIOS
    @GetMapping("/fornecedores")
    public String fornecedores(Model model) {
        return "fornecedores";
    }

    //PLACAS - DIRETORIOS
    @GetMapping("/placas-solares")
    public String placasSolares(Model model) {
        return "placas-solares";
    }


    //TECNICO - DIRETORIOS
    @GetMapping("/tecnico")
    public String tecnico(Model model) {
        return "tecnico";
    }

    //INSTALACAO - DIRETORIOS
    @GetMapping("/instalacao")
    public String instalacao(Model model) {
        return "instalacao";
    }

}
