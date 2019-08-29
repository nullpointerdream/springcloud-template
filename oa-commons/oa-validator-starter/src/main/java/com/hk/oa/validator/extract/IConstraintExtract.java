package com.hk.oa.validator.extract;


import com.hk.oa.validator.model.FieldValidatorDesc;
import com.hk.oa.validator.model.ValidConstraint;

import java.util.Collection;
import java.util.List;


/**
 * 提取指定表单验证规则
 *
 * @author zuihou
 * @date 2019-06-12
 */
public interface IConstraintExtract {

    /**
     * 提取指定表单验证规则
     *
     * @param constraints
     * @return
     * @throws Exception
     */
    Collection<FieldValidatorDesc> extract(List<ValidConstraint> constraints) throws Exception;
}
