package server.transcode.handler.exception.exception;

import server.transcode.handler.exception.type.ExceptionCode;
import server.transcode.handler.exception.type.ExceptionMessage;

public class NotFoundVideoDescriptionException extends CommonException {
    public NotFoundVideoDescriptionException() {super(ExceptionCode.NOT_FOUND,
            ExceptionMessage.NOT_FOUND_VIDEO_DESCRIPTION);}
}
