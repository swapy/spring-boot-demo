package com.example.accessingdatamysql;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import org.junit.jupiter.api.Test;

public class SampleUnitTest {

    @Test
    void assertAdd(){
        assertThat(2+2).isEqualTo(4);
//        fail("some fail message");
    }

}
