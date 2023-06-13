package server.transcode.handler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.transcode.handler.service.dto.TransMetadataDto;

import static server.transcode.handler.common.MessageRouter.TRANSCODE_FINISH_QUEUE;

@Slf4j
@RequiredArgsConstructor
@Service
public class VideoMetadataConsumer {

    private final VideoMetadataService videoMetadataService;

    @RabbitListener(queues = "#{" + TRANSCODE_FINISH_QUEUE + ".name}")
    public void getMessageAndUpdateMeta(TransMetadataDto metaDataList) {
        try {
            videoMetadataService.saveMetaDataAndSetCache(metaDataList);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
