package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");//서블릿은 http 스펙에 있는 데이터를 편리하게 받아올 수 있게 도와줌
        System.out.println("username = " + username);

        response.setContentType("text/plain");//헤더 정보 ContentType
        response.setCharacterEncoding("utf-8");//헤더 정보 ContentType
        response.getWriter().write("hello "+ username);//getWriter는 http바디에 메세지가 들어감

    }
}
