package server.transcode.handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.transcode.handler.domain.VideoMetadata;

@Repository
public interface VideoMetadataRepository extends JpaRepository<VideoMetadata, Long> {
}
