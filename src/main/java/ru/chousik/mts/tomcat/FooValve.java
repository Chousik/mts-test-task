package ru.chousik.mts.tomcat;

import jakarta.servlet.ServletException;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import java.io.IOException;

public class FooValve extends ValveBase {
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        response.setHeader("Foo", "Bar");
        getNext().invoke(request, response);
    }
}
