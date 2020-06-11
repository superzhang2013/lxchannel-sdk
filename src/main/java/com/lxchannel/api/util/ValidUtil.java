package com.lxchannel.api.util;

import com.lxchannel.api.exception.BusinessException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * 参数校验工具方法
 * Created by Niki on 2019/5/14 10:38
 */
public class ValidUtil {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public static void checkParam(Object arg, Class... groups) {
        Set validResult = valid(arg, groups);
        if (!validResult.isEmpty()) {
            Iterator iterator = validResult.iterator();
            throw new BusinessException("1002",((ConstraintViolation)iterator.next()).getMessage());
        }
    }


    private static Set<ConstraintViolation<Object>> valid(Object o, Class... groups) {
        Validator validator = factory.getValidator();
        return validator.validate(o, groups);
    }
}
