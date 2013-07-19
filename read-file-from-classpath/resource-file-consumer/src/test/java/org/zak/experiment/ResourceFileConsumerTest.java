package org.zak.experiment;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.readAllBytes;
import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class ResourceFileConsumerTest {

    @Test
    public void shouldBeAbleToReadFileFromJarDependenciesResources() throws Exception {
        assertThat(getExpectedJson(), sameJSONAs(getActualJson()));
    }

    private String getExpectedJson() throws IOException {
        return fileToString(getPath("expected-test.json"));
    }

    private String getPath(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getPath();
    }

    private String getActualJson() throws IOException {
        return fileToString(getPath("test.json"));
    }

    private String fileToString(String path) throws IOException {
        return new String(readAllBytes(new File(path).toPath()), defaultCharset());
    }
}
