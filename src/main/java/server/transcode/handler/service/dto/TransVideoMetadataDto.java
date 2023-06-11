package server.transcode.handler.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TransVideoMetadataDto {

    private List<TransVideoMeta> metas;
    private String duration; // 지속 시간

    @Builder
    public TransVideoMetadataDto(List<TransVideoMeta> metas, String duration) {
        this.metas = metas;
        this.duration = duration;
    }
}
