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

    @GetMapping("/adicionarPlacas")
    public String adicionarPlacas(Model model) {
        return "adicionarPlacas";
    }

    @GetMapping("/removerPlacas")
    public String removerPlacas(Model model) {
        return "removerPlacas";
    }

    @GetMapping("/visualizarPlacas")
    public String visualizarPlacas(Model model) {
        return "visualizarPlacas";
    }

    @GetMapping("/editarPlacas")
    public String editarPlacas(Model model) {
        return "editarPlacas";
    }

    //TECNICO - DIRETORIOS
    @GetMapping("/tecnico")
    public String tecnico(Model model) {
        return "tecnico";
    }

    @GetMapping("/adicionarTecnicos")
    public String adicionarTecnicos(Model model) {
        return "adicionarTecnicos";
    }

    @GetMapping("/removerTecnicos")
    public String removerTecnicos(Model model) {
        return "removerTecnicos";
    }

    @GetMapping("/visualizarTecnicos")
    public String visualizarTecnicos(Model model) {
        return "visualizarTecnicos";
    }

    @GetMapping("editarTecnicos")
    public String editarTecnicos(Model model) {
        return "editarTecnicos";
    }

    //INSTALACAO - DIRETORIOS
    @GetMapping("/instalacao")
    public String instalacao(Model model) {
        return "instalacao";
    }

    @GetMapping("/adicionarInstalacoes")
    public String adicionarInstalacoes(Model model) {
        return "adicionarInstalacoes";
    }

    @GetMapping("/removerInstalacao")
    public String removerInstalacao(Model model) {
        return "removerInstalacao";
    }

    @GetMapping("/visualizarInstalacao")
    public String visualizarInstalacao(Model model) {
        return "visualizarInstalacao";
    }

    @GetMapping("/editarInstalacao")
    public String editarInstalacao(Model model) {
        return "editarInstalacao";
    }

    //DASHBOARDS - DIRETORIOS
    @GetMapping("/dashboards")
    public String dashboards(Model model) {
        return "dashboards";
    }

    // CONSULTA TECNICO - DIRETÓRIOS
    @GetMapping("/consultatecnico")
    public String consultarTecnico(Model model) {
        return "consultatecnico"; // Nome do arquivo HTML na pasta "templates"
    }
    // FAZER PEDIDO - DIRETÓRIOS
    @GetMapping("/fazerpedido")
    public String fazerPedido(Model model) {
        return "fazerpedido"; // Nome do arquivo HTML na pasta "templates"
    }
    // ADD PEDIDO - DIRETÓRIOS
    @GetMapping("/addpedido")
    public String addPedido(Model model) {
        return "addpedido"; // Nome do arquivo HTML na pasta "templates"
    }

    // PAGAMENTO - DIRETORIOS
    @GetMapping("/realizarPagamento")
    public String realizarPagamento(Model model) {
        return "realizarPagamento"; // Nome do arquivo HTML na pasta "templates"
    }

    @GetMapping("/fazerPagamento")
    public String fazerPagamento(Model model) {
        return "fazerPagamento"; // Nome do arquivo HTML na pasta "templates"
    }

    // SUPERVISOR - DIRETORIOS
    @GetMapping("/supervisor")
    public String supervisor(Model model) {
        return "supervisor";
    }

    @GetMapping("adicionarSupervisores")
    public String adicionarSupervisors(Model model) {
        return "adicionarSupervisores";
    }

    @GetMapping("removerSupervisor")
    public String removerSupervisor(Model model) {
        return "removerSupervisor";
    }


}
