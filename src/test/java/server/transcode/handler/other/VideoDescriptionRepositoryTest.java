package server.transcode.handler.other;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import server.transcode.handler.other.dao.VideoDescriptionOnly;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class VideoDescriptionRepositoryTest {

    @Autowired VideoDescriptionRepository videoDescriptionRepository;

    @Test
    @DisplayName("이미 저장된 videoDescription 데이터를 가져오기")
    public void find() throws Exception {
        //given
        Long videoDescriptionId = 1L;

        //when
        VideoDescriptionOnly videoDescriptionOnly = videoDescriptionRepository
                .findVideoDescriptionOnlyById(videoDescriptionId);

        //then
        assertThat(videoDescriptionOnly.getId()).isEqualTo(videoDescriptionId);
    }

}