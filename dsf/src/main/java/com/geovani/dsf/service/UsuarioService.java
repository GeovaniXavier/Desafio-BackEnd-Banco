package com.geovani.dsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovani.dsf.config.DozzerMapper;
import com.geovani.dsf.dto.UsuarioDto;
import com.geovani.dsf.model.Usuario;
import com.geovani.dsf.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<UsuarioDto> findAll(){		
		var entity = DozzerMapper.parseListObject(usuarioRepository.findAll(), UsuarioDto.class);
		return entity;
	}
	
	public UsuarioDto findById(Long id) throws Exception {
		var entity = usuarioRepository.findById(id).orElseThrow(() -> new Exception("ID NÃO ENCONTRADO."));
		var conv = DozzerMapper.parseObject(entity, UsuarioDto.class);
		return conv;
	}
	
	public UsuarioDto create(UsuarioDto usuario) throws Exception {
		if(usuario == null) throw new Exception("Erro ao Criar um usuario");
		var entity = DozzerMapper.parseObject(usuario, Usuario.class);
        var vo = DozzerMapper.parseObject(usuarioRepository.save(entity), UsuarioDto.class);
        return vo;
	}

    public UsuarioDto update(UsuarioDto usuario) throws Exception {
        if(usuario == null) throw new Exception("Erro ao criar usuario.");
        var entity = usuarioRepository.findById(usuario.getKey())
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        var vo = DozzerMapper.parseObject(usuarioRepository.save(entity), UsuarioDto.class);
        return vo;
    }
    
    public void delete(Long id) throws Exception {
        var entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        usuarioRepository.delete(entity);
    }
	
}
