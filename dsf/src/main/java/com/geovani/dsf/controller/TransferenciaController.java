package com.geovani.dsf.controller;

import com.geovani.dsf.dto.TransferenciaDto;
import com.geovani.dsf.enuns.Type;
import com.geovani.dsf.repository.UsuarioRepository;
import com.geovani.dsf.utils.AutorizadoFeign;
import com.geovani.dsf.utils.SucessFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutorizadoFeign autorizadoFeign;

    @Autowired
    private SucessFeign sucessFeign;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> transferir(@RequestBody TransferenciaDto transferenciaDto) {
        var de = usuarioRepository.findById(transferenciaDto.getDe()).get();
        if (de.getType().equals(Type.LOJISTA)) {
            throw new RuntimeException("Logista não pode transferir, somente receber.");
        } else {
            if (de.getSaldo() >= transferenciaDto.getValor()) {

                var para = usuarioRepository.findById(transferenciaDto.getPara()).get();

                para.acrescentarSaldo(transferenciaDto.getValor());

                de.removerSaldo(transferenciaDto.getValor());

                autorizadoFeign.getMessege();

                usuarioRepository.save(para);

                usuarioRepository.save(de);

                sucessFeign.getSucess();

                return ResponseEntity.ok().build();
            }
        }
        throw new RuntimeException("Usuario não tem saldo suficiente!");

    }
}
