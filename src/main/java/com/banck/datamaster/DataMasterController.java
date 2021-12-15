/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.datamaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jnacarra
 */
@RestController
@RequestMapping("/datamaster")
public class DataMasterController {

    @Autowired
    private StringRedisTemplate template;

    @GetMapping("/modality")
    public String Modality() {

        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "MADALITY";
        if (!this.template.hasKey(key)) {
            ops.set(key, "VENTANILLA");
            ops.set(key, "POS");
            ops.set(key, "CAJERO");
            ops.set(key, "EFECTIVO-MOVIL");
            ops.set(key, "BANCA-MOVIL");
        }
        return ops.get(key);
    }
}
