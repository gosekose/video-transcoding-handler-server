package server.transcode.handler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.transcode.handler.domain.VideoMetadata;
import server.transcode.handler.other.VideoDescription;
import server.transcode.handler.other.VideoDescriptionRepository;
import server.transcode.handler.other.VideoDescriptionService;
import server.transcode.handler.repository.VideoMetadataRepository;
import server.transcode.handler.service.dto.TransMetadataDto;
import server.transcode.handler.service.dto.VideoMetadataDto;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class VideoMetadataService {
    private final VideoDescriptionService videoDescriptionService;

    private final VideoMetadataRepository videoMetadataRepository;

    public void saveMetaDataAndSetCache(TransMetadataDto metadataDto) {

        VideoDescription videoDescription = videoDescriptionService.findById(metadataDto.getDescriptionId());

        List<VideoMetadata> videoMetadataList = metadataDto
                .getVideoMetadataDtoList()
                .stream()
                .map(meta -> VideoMetadata.builder()
                        .videoDescription(videoDescription)
                        .filePath(meta.getTransVideoFilePath())
                        .bitrate(meta.getBitrate())
                        .format(meta.getFormat())
                        .duration(metadataDto.getDuration())
                        .build())
                .collect(Collectors.toList());
        videoMetadataRepository.saveAll(videoMetadataList);
    }

    public List<VideoMetadata> findMetaDataListByDescription(VideoDescription videoDescription) {
        return videoMetadataRepository.findVideoMetadataByVideoDescription(videoDescription);
    }
}
