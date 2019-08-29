package com.hk.oa.common.msg.auth;

import com.hk.oa.common.constant.BaseContextConstants;
import com.hk.oa.common.msg.BaseResponse;

public class TokenForbiddenResponse extends BaseResponse {

    public TokenForbiddenResponse(String message) {
        super(BaseContextConstants.EX_TOKEN_FORBIDDEN_CODE, message);
    }
}
