package server.transcode.handler.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.transcode.handler.repository.VideoMetadataRepository;
import server.transcode.handler.service.dto.TransVideoMeta;
import server.transcode.handler.service.dto.TransVideoMetadataDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoMetadataServiceTest {

    @Autowired private VideoMetadataService videoMetadataService;
    @Autowired private VideoMetadataRepository videoMetadataRepository;

    private String duration = "00:01:00.67";
    private TransVideoMetadataDto metadataDto;

    @BeforeEach
    void init() {
        List<TransVideoMeta> metas = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            metas.add(TransVideoMeta.builder()
                    .transVideoFilePaths("trans_test_path_" + i)
                    .bitrate("200" + i + "k")
                    .format("mp4")
                    .build());

        metadataDto = TransVideoMetadataDto.builder()
                .metas(metas)
                .duration(duration)
                .build();
    }

    @AfterEach
    void clearUp() {
        videoMetadataRepository.deleteAll();
    }

    @Test
    @DisplayName("")
    public void saveMetadatas() throws Exception {

        //when
        videoMetadataService.saveMetaDataAndSetCache(metadataDto);

        //then

    }
}