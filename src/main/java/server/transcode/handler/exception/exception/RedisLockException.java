package server.transcode.handler.exception.exception;

import server.transcode.handler.exception.type.ExceptionCode;
import server.transcode.handler.exception.type.ExceptionMessage;

public class RedisLockException extends CommonException {

    public RedisLockException() {
        super(ExceptionCode.CONFLICT, ExceptionMessage.REDIS_ROCK_EXCEPTION);
    }
}
