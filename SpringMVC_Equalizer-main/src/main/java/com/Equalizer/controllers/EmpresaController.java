package com.Equalizer.controllers;

import com.Equalizer.model.Empresa;
import com.Equalizer.model.Cliente;
import com.Equalizer.services.EmpresaService;
import com.Equalizer.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;

    @Autowired
    public EmpresaController(EmpresaService empresaService, ClienteService clienteService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listarEmpresas(Model model) {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        model.addAttribute("empresas", empresas);
        return "ListarEmpresas";
    }

    @GetMapping("/novo")
    public String exibirFormularioAdicao(Model model) {
        Empresa empresa = new Empresa();
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("empresa", empresa);
        model.addAttribute("clientes", clientes);
        return "empresaForm";
    }

    @PostMapping("/adicionar")
    public String adicionarEmpresa(@ModelAttribute("empresa") Empresa empresa) {
        empresaService.saveEmpresa(empresa);
        return "redirect:/empresas";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Empresa empresa = empresaService.getEmpresaById(id);
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("empresa", empresa);
        model.addAttribute("clientes", clientes);
        return "editarEmpresa";
    }

    @PostMapping("/editar/{id}")
    public String atualizarEmpresa(@PathVariable("id") Long id, @ModelAttribute("empresa") Empresa empresa) {
        empresaService.updateEmpresa(id, empresa);
        return "redirect:/empresas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);
        return "redirect:/empresas";
    }
}
