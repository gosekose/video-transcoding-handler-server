package server.transcode.handler.other;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.transcode.handler.other.dao.VideoDescriptionOnly;

@Repository
public interface VideoDescriptionRepository extends JpaRepository<VideoDescription, Long> {
    VideoDescriptionOnly findVideoDescriptionOnlyById(Long id);
}
