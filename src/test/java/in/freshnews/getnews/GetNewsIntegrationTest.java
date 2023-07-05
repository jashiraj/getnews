package in.freshnews.getnews;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GetNewsIntegrationTest {
    @Test
    public void testGetAllNews() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/newsapi/getAllNewsItems/world");
        HttpResponse response = HttpClientBuilder.create().build().execute( request );
        assertNotNull(response.getEntity());
        assertEquals(200 ,response.getStatusLine().getStatusCode());
    }
}
