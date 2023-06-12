package server.transcode.handler.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VideoMetadataDto {
    private String transVideoFilePath; // 저장소 위치
    private String bitrate; // 비트레이트
    private String format; // 확장자
}
