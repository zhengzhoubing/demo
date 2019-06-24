package com.bin.demo.service;

import com.bin.demo.Mapper.MyMapper;
import com.bin.demo.entity.TemplateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * package: com.bin.demo.service
 * class: TemplateTypeService
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/6/17 0017.
 **/
@Service
public class TemplateTypeService {

    @Autowired
    private MyMapper templateTypeMapper;

    public TemplateType qryTemplateType(long templateTypeId) {
        return templateTypeMapper.qryTemplateType(templateTypeId);
    }
}
