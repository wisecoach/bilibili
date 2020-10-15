package com.wisecoach.controller;

import com.wisecoach.pojo.Type;
import com.wisecoach.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/all")
    public Type listAll(){
        Type allType = typeService.getAllType();
        return allType;
    }
}
