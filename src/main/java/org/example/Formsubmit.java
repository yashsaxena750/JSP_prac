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

    @WebServlet(name = "sessionServlet", value = "/session-servlet")
    public static class Session extends HttpServlet {

        @Override
        public void init() {
            // part of life cycle
        }

        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");
            Logger logger = Logger.getLogger(getClass().getName());

            try {
                PrintWriter out = response.getWriter();
                String name = request.getParameter("fname");
                String pass = request.getParameter("pswd");

                if (name != null && pass != null && (name.equals("yash") && pass.equals("pass"))) {
                    HttpSession existingSession = request.getSession(false);
                    if (existingSession != null) {
                        existingSession.invalidate();
                    }

                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(60);
                    out.println(name + "\t" + pass);

                    if (session != null) {
                        response.sendRedirect(request.getContextPath() + "/note.txt");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/session.jsp");
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + "/session.jsp");
                }

            } catch (Exception e) {
                logger.info("Error");
            }
        }

        @Override
        public void destroy() {
            // part of servlet life cycle
        }
    }

}
