package server.transcode.handler.other;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import server.transcode.handler.exception.exception.NotFoundVideoDescriptionException;

@Slf4j
@RequiredArgsConstructor
@Service
public class VideoDescriptionService {

    private final VideoDescriptionRepository videoDescriptionRepository;

    public VideoDescription findById(Long id) {
        return videoDescriptionRepository.findById(id)
                .orElseThrow(() -> {throw new NotFoundVideoDescriptionException();
        });
    }
}
