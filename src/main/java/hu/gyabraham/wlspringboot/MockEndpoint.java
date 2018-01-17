package hu.gyabraham.wlspringboot;

import hu.gyorgyabraham.RequestStructure;
import hu.gyorgyabraham.ResponseStructure;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class MockEndpoint {

    @PayloadRoot(namespace = "http://gyorgyabraham.hu", localPart = "RequestStructure")
    @ResponsePayload
    public ResponseStructure responseStructure(@RequestPayload RequestStructure request) {
        return new ResponseStructure() {{
            setRsuid(request.getRquid());
            setMessage("Hello from example app!");
        }};
    }

}
