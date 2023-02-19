package com.geovani.dsf.controller;

import com.geovani.dsf.dto.UsuarioDto;
import com.geovani.dsf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> findAll(UsuarioDto usuarioDto) {
        return usuarioService.findAll();

    }

    @GetMapping(value = "/{id}")
    public UsuarioDto findById(@PathVariable(value = "id") Long id) throws Exception {
        return usuarioService.findById(id);
    }

    @PostMapping
    public UsuarioDto create(@RequestBody UsuarioDto usuario) throws Exception {
        return usuarioService.create(usuario);
    }

    @PutMapping
    public UsuarioDto update(@RequestBody UsuarioDto usuario) throws Exception {
        return usuarioService.update(usuario);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
