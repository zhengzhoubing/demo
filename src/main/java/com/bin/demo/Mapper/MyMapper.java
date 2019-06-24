package com.bin.demo.Mapper;

import com.bin.demo.entity.TemplateType;
import org.springframework.stereotype.Repository;

/**
 * package: com.bin.demo.Mapper
 * class: MyMapper
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/4/29 0029.
 **/
@Repository
public interface MyMapper {

    TemplateType qryTemplateType(long templateTypeId);

}
