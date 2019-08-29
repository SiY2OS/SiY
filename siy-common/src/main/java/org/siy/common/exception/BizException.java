package org.siy.common.exception;

import org.siy.common.enums.ResultStatus;

public class BizException extends RuntimeException {

    ResultStatus status;

    public BizException(ResultStatus status) {
        super(status.getMsg());
        this.status = status;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }
}
