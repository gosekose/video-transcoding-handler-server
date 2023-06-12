package server.transcode.handler.other.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import server.transcode.handler.other.VideoDescriptionRepository;

@DataJpaTest
class VideoDescriptionOnlyTest {

    @Autowired
    VideoDescriptionRepository videoDescriptionRepository;

    @Test
    @DisplayName("projection test")
    public void find() throws Exception {
        //given

        //when

        //then

    }

}