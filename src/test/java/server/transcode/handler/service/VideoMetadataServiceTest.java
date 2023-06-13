package server.transcode.handler.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import server.transcode.handler.domain.VideoMetadata;
import server.transcode.handler.other.VideoDescription;
import server.transcode.handler.other.VideoDescriptionService;
import server.transcode.handler.service.dto.DescriptionMetadataDto;
import server.transcode.handler.service.dto.TransMetadataDto;
import server.transcode.handler.service.dto.VideoMetadataDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class VideoMetadataServiceTest {

    @Autowired VideoMetadataService videoMetadataService;
    @Autowired VideoDescriptionService videoDescriptionService;

    String[] bitrates = {"1000k", "1600k", "2440K"};
    String[] formats = {"mp4", "mp3"};
    String duration = "00:10:50.540";

    @Test
    @DisplayName("video metadata 저장 테스트")
    public void save() throws Exception {
        //given
        Long descriptionId = 1L;
        DescriptionMetadataDto descriptionMetadataDto = new DescriptionMetadataDto(descriptionId);
        List<VideoMetadataDto> videoMetadataDtoList = new ArrayList<>();

        int pathIndex = 1;
        for (String bitrate : bitrates) {
            for (String format : formats) {
                videoMetadataDtoList.add(new VideoMetadataDto("path_" + pathIndex, bitrate, format));
            }
        }
        //when
        TransMetadataDto transMetadataDto = new TransMetadataDto(descriptionMetadataDto, videoMetadataDtoList, duration);
        videoMetadataService.saveMetaDataAndSetCache(transMetadataDto);
        VideoDescription videoDescription = videoDescriptionService.findById(descriptionId);
        List<VideoMetadata> metas = videoMetadataService.findMetaDataListByDescription(videoDescription);

        //then
        assertThat(metas.size()).isEqualTo(bitrates.length * formats.length);
        assertThat(metas.get(0).getBitrate()).isEqualTo(bitrates[0]);
        assertThat(metas.get(0).getFormat()).isEqualTo(formats[0]);
    }

}