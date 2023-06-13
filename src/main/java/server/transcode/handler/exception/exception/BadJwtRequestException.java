package server.transcode.handler.exception.exception;


import server.transcode.handler.exception.type.ExceptionCode;
import server.transcode.handler.exception.type.ExceptionMessage;

public class BadJwtRequestException extends CommonException {

    public BadJwtRequestException() {super(ExceptionCode.BAD_REQUEST, ExceptionMessage.BAD_REQUEST);}
}
