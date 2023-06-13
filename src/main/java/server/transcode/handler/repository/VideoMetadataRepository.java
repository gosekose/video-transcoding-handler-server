package server.transcode.handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.transcode.handler.domain.VideoMetadata;
import server.transcode.handler.other.VideoDescription;

import java.util.List;

@Repository
public interface VideoMetadataRepository extends JpaRepository<VideoMetadata, Long> {
    List<VideoMetadata> findVideoMetadataByVideoDescription(VideoDescription videoDescription);
    VideoMetadata findVideoMetadataById(Long id);
}
