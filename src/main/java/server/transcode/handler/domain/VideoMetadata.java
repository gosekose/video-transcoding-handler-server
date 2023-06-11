package server.transcode.handler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class VideoMetadata {

    @Id @GeneratedValue
    @Column(name = "video_metadata_id")
    private Long id;
    private String transVideoFilePath;
    private String bitrate;
    private String format;
    private String duration;

    @Builder
    public VideoMetadata(String transVideoFilePath, String bitrate, String format,
                         String duration) {
        this.transVideoFilePath = transVideoFilePath;
        this.bitrate = bitrate;
        this.format = format;
        this.duration = duration;
    }
}
