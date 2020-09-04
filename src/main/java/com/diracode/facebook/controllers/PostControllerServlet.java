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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
* Servlet class to render dynamic jsp pages to web browser
 */

public class PostControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PostDAO postDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        postDAO = new PostDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String content = request.getParameter("content");
            String userId = request.getParameter("userId");

            System.out.println(content);
            System.out.println(userId);

            if (content != null && userId != null) {
                Post post = new Post(content, Integer.parseInt(userId), LocalDate.now());
                postDAO.createPost(post);

                List<Post> posts = postDAO.listPosts();
                request.setAttribute("posts", posts);

            }
            request.getRequestDispatcher("facebook/facebook.jsp").forward(request, response);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
