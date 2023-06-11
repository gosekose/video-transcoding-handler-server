package server.transcode.handler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import server.transcode.handler.service.dto.TransVideoMetadataDto;

import static server.transcode.handler.common.MessageRouter.TRANSCODE_FINISH_QUEUE;

@Slf4j
@RequiredArgsConstructor
@Service
public class VideoMetadataConsumer {

    private final VideoMetadataService videoMetadataService;

    @RabbitListener(queues = "#{" + TRANSCODE_FINISH_QUEUE + ".name}")
    public void getMessageAndUpdateMeta(TransVideoMetadataDto metaDataList) {
        try {
            videoMetadataService.saveMetaDataAndSetCache(metaDataList);
        } catch (Exception e) {
            log.error(e.getMessage());
            // 실패 핸들러에 추가하여 추후 다시 재시도 할 수 있도록 요청 로직 작성 필요
        }
    }
}
