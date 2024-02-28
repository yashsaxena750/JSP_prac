package org.example;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.text.StringEscapeUtils;
import java.util.logging.Logger;

@WebServlet(name = "formsubmitServlet", value = "/formsubmit-servlet")
public class Formsubmit extends HttpServlet {

    @Override
    public void init() {
        // init method part of life-cycle
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        Logger logger = Logger.getLogger(getClass().getName());
        try {
            PrintWriter out = response.getWriter();
            String name = StringEscapeUtils.escapeHtml4(request.getParameter("name"));
            String gender = StringEscapeUtils.escapeHtml4(request.getParameter("gndr"));
            String cnt = StringEscapeUtils.escapeHtml4(request.getParameter("cnt"));
            String[] lanlist = request.getParameterValues("lang");

            if (name == null || gender == null || cnt == null || lanlist == null) {
                out.println("<script>alert('Please fill all the details'); window.location.href='form.jsp';</script>");
            } else {
                out.print(name + "<br>");
                out.print(gender + "<br>");
                out.print(cnt + "<br>");
                for (int i = 0; i < lanlist.length; i++) {
                    out.println(StringEscapeUtils.escapeHtml4(lanlist[i]));
                    if (i < lanlist.length - 1)
                        out.println(", ");
                }
            }
        } catch (Exception e) {
            logger.info("Something bad happened.");
        }
    }

    @Override
    public void destroy() {
        // destroy method part of lifecycle
    }
}
