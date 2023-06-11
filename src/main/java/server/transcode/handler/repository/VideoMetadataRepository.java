package server.transcode.handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.transcode.handler.domain.VideoMetadata;

public interface VideoMetadataRepository extends JpaRepository<VideoMetadata, Long> {

}
