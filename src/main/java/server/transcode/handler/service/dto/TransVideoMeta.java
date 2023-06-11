package server.transcode.handler.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TransVideoMeta {
    private String transVideoFilePaths; // 저장소 위치
    private String bitrate; // 비트레이트
    private String format; // 확장자

    @Builder
    public TransVideoMeta(String transVideoFilePaths, String bitrate, String format) {
        this.transVideoFilePaths = transVideoFilePaths;
        this.bitrate = bitrate;
        this.format = format;
    }
}
