package com.wisecoach.controller;

import com.baomidou.mybatisplus.annotation.TableId;
import com.wisecoach.annotation.PassToken;
import com.wisecoach.mapper.ArchiveMapper;
import com.wisecoach.pojo.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/archive")
public class ArchiveController {
    @Autowired
    private ArchiveMapper archiveMapper;

    @PassToken
    @GetMapping("/{id}")
    public Archive findById(@PathVariable Long id){
        Archive archive = archiveMapper.selectById(257941);
        return archive;
    }
}
