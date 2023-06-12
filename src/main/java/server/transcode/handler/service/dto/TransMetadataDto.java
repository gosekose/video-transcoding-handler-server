package server.transcode.handler.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * From: Transcoding-Server
 * To: Transcoding-Handler-Server

 * infoMetadata: 동영상에 관한 제목 설명을 저장한 pk
 * videoMetadataDtoList: 변경한 동영상 포멧등이 담긴 동영상 메타 정보
 * duration: 동영상 영상 길이
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransMetadataDto {

    private DescriptionMetadataDto descriptionMetadataDto;
    private List<VideoMetadataDto> videoMetadataDtoList;
    private String duration; // 지속 시간

    public Long getDescriptionId() {
        return descriptionMetadataDto.getDescriptionId();
    }
}
