package com.Equalizer.services;

import com.Equalizer.model.Empresa;

import java.util.List;

public interface EmpresaService {

	List<Empresa> getAllEmpresas();

	Empresa getEmpresaById(Long id);

	Empresa saveEmpresa(Empresa empresa);

	Empresa updateEmpresa(Long id, Empresa empresaAtualizada);

	void deleteEmpresa(Long id);
}

