package com.example.votereligibility;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/voterEligibility")
public class VoterEligibilityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String message;

        try {
            int age = Integer.parseInt(ageStr);
            if (age >= 18) {
                message = "Hello " + name + ", you are eligible to vote!";
            } else {
                message = "Hello " + name + ", you are not eligible to vote yet.";
            }
        } catch (NumberFormatException e) {
            message = "Invalid age input. Please enter a valid number.";
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body><h2>" + message + "</h2></body></html>");
    }
}
