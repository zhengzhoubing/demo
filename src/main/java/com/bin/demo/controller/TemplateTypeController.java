package com.bin.demo.controller;

import com.bin.demo.entity.TemplateType;
import com.bin.demo.service.TemplateTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * package: com.bin.demo.controller
 * class: TemplateTypeController
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/6/17 0017.
 **/
@RestController
@RequestMapping("/templateType")
public class TemplateTypeController {

    @Autowired
    private TemplateTypeService typeService;

    private Logger logger = LoggerFactory.getLogger(TemplateTypeController.class);

    @RequestMapping("getTemplateType/{templateTypeId}")
    public TemplateType getTemplateType(@PathVariable long templateTypeId){
        TemplateType templateType = typeService.qryTemplateType(templateTypeId);
        logger.info(templateType.toString());
        return templateType;
    }
}
