package com.geovani.dsf.utils;

import com.geovani.dsf.model.Autorizacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sucess", url = "http://o4d9z.mocklab.io/notify")
public interface SucessFeign {

    @GetMapping
    Autorizacao getSucess();

}
