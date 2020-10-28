package com.wisecoach.controller;

import com.baomidou.mybatisplus.annotation.TableId;
import com.wisecoach.annotation.PassToken;
import com.wisecoach.mapper.ArchiveMapper;
import com.wisecoach.pojo.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/archive")
public class ArchiveController {
    @Autowired
    private ArchiveMapper archiveMapper;

    @PassToken
    @GetMapping("")
    public Archive findById(
        @RequestParam("aid") Long aid
    ){
        Archive archive = archiveMapper.selectById(aid);
        return archive;
    }


}
