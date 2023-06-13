package server.transcode.handler.exception.exception;

import server.transcode.handler.exception.type.ExceptionCode;
import server.transcode.handler.exception.type.ExceptionMessage;

public class NotExistRefreshTokenException extends CommonException {

    public NotExistRefreshTokenException() {
        super(ExceptionCode.UNAUTHORIZED, ExceptionMessage.USER_NOT_REFRESHTOKEN);
    }
}
