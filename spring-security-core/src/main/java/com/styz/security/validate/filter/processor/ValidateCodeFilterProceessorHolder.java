package com.styz.security.validate.filter.processor;

import com.styz.security.exception.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * creat date:2019-07-16 12:36
 * author:xxydliuyss
 * note:
 */
@Component
public class ValidateCodeFilterProceessorHolder {
    @Autowired
    private Map<String,ValidateCodefilterProcessor> validateCodeProcessors = new HashMap<String,ValidateCodefilterProcessor>();

    public ValidateCodefilterProcessor findValidate(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodefilterProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodefilterProcessor.class.getSimpleName();
        ValidateCodefilterProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
