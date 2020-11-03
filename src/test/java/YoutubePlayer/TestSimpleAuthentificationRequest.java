package YoutubePlayer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestSimpleAuthentificationRequest {
    @Test
    public void testSimpleAuthentificationRequest() throws IOException {
        SimpleAuthorizationRequest simpleAuthorizationRequest =
                new SimpleAuthorizationRequest("Евгений Борисов Java", 25);
        StringBuffer stringBuffer = simpleAuthorizationRequest.getResponce();
        System.out.println(stringBuffer.toString());
        stringBuffer = simpleAuthorizationRequest.getResponce();
        System.out.println(stringBuffer.toString());
    }
}
