package server.transcode.handler.exception.exception;

import server.transcode.handler.exception.type.ExceptionCode;
import server.transcode.handler.exception.type.ExceptionMessage;

public class TooManyRequestException extends CommonException {

    public TooManyRequestException() {super(ExceptionCode.TOO_MANY_REQUEST, ExceptionMessage.TOO_MANY_REQUEST);}
}
