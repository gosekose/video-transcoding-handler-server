package server.transcode.handler.exception.type;

public class ExceptionMessage {
    public static final String USER_NOT_FOUND = "존재하지 않는 회원입니다.";
    public static final String USER_NOT_REFRESHTOKEN = "존재하지 않는 refreshToken 입니다,";
    public static final String TOO_MANY_REQUEST = "너무 많은 요청으로 사이트에서 일시적 차단되었습니다.";
    public static final String BAD_REQUEST = "유효하지 않은 요청입니다.";
    public static final String NOT_FOUND_VIDEO_DESCRIPTION = "존재하지 않는 동영상 정보입니다.";
    public static final String INTERNAL_SERVER_ERROR = "일시적인 서버 에러입니다.";
    public static final String REDIS_ROCK_EXCEPTION = "다른 요청이 처리 중입니다.";
}
