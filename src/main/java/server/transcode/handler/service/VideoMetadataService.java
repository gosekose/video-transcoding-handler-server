package server.transcode.handler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.transcode.handler.domain.VideoMetadata;
import server.transcode.handler.repository.VideoMetadataRepository;
import server.transcode.handler.service.dto.TransVideoMetadataDto;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class VideoMetadataService {

    private final VideoMetadataRepository videoMetadataRepository;

    public void saveMetaDataAndSetCache(TransVideoMetadataDto metaDataList) {
        List<VideoMetadata> videoMetadataList = metaDataList.getMetas()
                .stream()
                .map(meta -> VideoMetadata.builder()
                        .transVideoFilePath(meta.getTransVideoFilePaths())
                        .bitrate(meta.getBitrate())
                        .format(meta.getFormat())
                        .duration(metaDataList.getDuration())
                        .build())
                .collect(Collectors.toList());

        videoMetadataRepository.saveAll(videoMetadataList);
    }

}
