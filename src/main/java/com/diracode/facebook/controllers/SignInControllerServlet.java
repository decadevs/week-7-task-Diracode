package com.diracode.facebook.controllers;

import com.diracode.facebook.dao.PostDAO;
import com.diracode.facebook.dao.UserDAO;
import com.diracode.facebook.model.Post;
import com.diracode.facebook.model.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/*
 * Servlet class to render dynamic jsp pages to web browser
 */

public class SignInControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private PostDAO postDAO;
    private Gson gson;

    public void init(){
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
        postDAO = new PostDAO(jdbcURL, jdbcUsername, jdbcPassword);

        gson = new Gson();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = userDAO.getUser(request.getParameter("email"), request.getParameter("password"));

            if (user == null) {
                request.getRequestDispatcher("./signup.jsp").forward(request, response);
            } else {
                request.setAttribute("userObj", user);

                request.setAttribute("user", gson.toJson(user));

                List<Post> posts = postDAO.listPosts();
                request.setAttribute("posts", posts);

                request.getRequestDispatcher("facebook/facebook.jsp").forward(request, response);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String path = request.getServletPath();


    }
}
