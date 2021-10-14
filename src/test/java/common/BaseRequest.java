package common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BaseRequest {
    private static RequestSpecification requestSpec;

    public RequestSpecification getDefaultRequestSpecification() throws FileNotFoundException {
        if(requestSpec == null) { // to avoid re-creating logging.txt
            PrintStream logStream = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpec = new RequestSpecBuilder().setBaseUri(Utils.getGlobalVariable("base.url"))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(logStream)) // log request to file
                    .addFilter(ResponseLoggingFilter.logResponseTo(logStream)) // log response to file
                    .build();
        }

        return requestSpec;

    }
}
