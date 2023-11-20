
package com.Equalizer.servicesImpl;

import com.Equalizer.model.Empresa;
import com.Equalizer.repositories.EmpresaRepository;
import com.Equalizer.services.EmpresaService;
import com.Equalizer.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ClienteService clienteService;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository, ClienteService clienteService) {
        this.empresaRepository = empresaRepository;
        this.clienteService = clienteService;
    }

    @Override
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa getEmpresaById(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    @Transactional
    public Empresa updateEmpresa(Long id, Empresa empresaAtualizada) {
        Empresa empresaExistente = empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa com ID " + id + " não encontrada."));

        // Adicione aqui as atualizações necessárias, como setClientes, setDepartamento, etc.
        empresaExistente.setNome(empresaAtualizada.getNome());
        empresaExistente.setDescricao(empresaAtualizada.getDescricao());
        empresaExistente.setClientes(empresaAtualizada.getClientes());

        return empresaRepository.save(empresaExistente);
    }

    @Override
    @Transactional
    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
