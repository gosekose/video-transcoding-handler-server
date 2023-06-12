package server.transcode.handler.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import server.transcode.handler.other.VideoDescription;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class VideoMetadata {

    @Id @GeneratedValue
    @Column(name = "video_metadata_id")
    private Long id;
    private String filePath;
    private String bitrate;
    private String format;
    private String duration;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "video_description_id")
    private VideoDescription videoDescription;

    @Builder
    public VideoMetadata(String filePath, String bitrate, String format,
                         String duration, VideoDescription videoDescription) {
        this.filePath = filePath;
        this.bitrate = bitrate;
        this.format = format;
        this.duration = duration;
        this.videoDescription = videoDescription;
    }
}
