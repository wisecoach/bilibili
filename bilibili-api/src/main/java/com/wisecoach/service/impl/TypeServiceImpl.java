package com.wisecoach.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wisecoach.mapper.TypeMapper;
import com.wisecoach.pojo.Type;
import com.wisecoach.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Type getAllType(){
        QueryWrapper<Type> allWrapper = new QueryWrapper<>();
        allWrapper.select("tid","parent","name","text");
        allWrapper.eq("tid", 0);
        Type all = typeMapper.selectOne(allWrapper);
        QueryWrapper<Type> typeWrapper = new QueryWrapper<>();
        typeWrapper.select("tid","parent","name","text");
        typeWrapper.eq("parent", all.getTid());
        List<Type> types = typeMapper.selectList(typeWrapper);
        all.setChilds(types);
        for (Type type : types) {
            QueryWrapper<Type> childWrapper = new QueryWrapper<>();
            childWrapper.select("tid","parent","name","text");
            childWrapper.eq("parent", type.getTid());
            List<Type> childs = typeMapper.selectList(childWrapper);
            type.setChilds(childs);
        }
        return all;
    }
}
