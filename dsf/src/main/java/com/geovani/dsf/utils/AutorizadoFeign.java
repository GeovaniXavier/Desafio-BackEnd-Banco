package com.geovani.dsf.utils;

import com.geovani.dsf.model.Autorizacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mensagem", url = "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6")
public interface AutorizadoFeign {

    @GetMapping
    Autorizacao getMessege();

}
