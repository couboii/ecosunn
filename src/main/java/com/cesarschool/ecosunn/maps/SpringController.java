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

    @GetMapping("/removerCliente")
    public String removerCliente(Model model) {
        return "removerCliente";
    }

    @GetMapping("/visualizarCliente")
    public String visualizarCliente(Model model) {
        return "visualizarCliente";
    }

    @GetMapping("/editarCliente")
    public String editarCliente(Model model) {
        return "editarCliente";
    }

    //FORNECEDOR - DIRETORIOS
    @GetMapping("/fornecedor")
    public String fornecedor(Model model) {
        return "fornecedor";
    }

    @GetMapping("/adicionarFornecedores")
    public String adicionarFornecedores(Model model) {
        return "adicionarFornecedores";
    }

    @GetMapping("/removerFornecedores")
    public String removerFornecedores(Model model) {
        return "removerFornecedores";
    }

    @GetMapping("/visualizarFornecedores")
    public String visualizarFornecedores(Model model) {
        return "visualizarFornecedores";
    }

    @GetMapping("/editarFornecedores")
    public String editarFornecedores(Model model) {
        return "editarFornecedores";
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
