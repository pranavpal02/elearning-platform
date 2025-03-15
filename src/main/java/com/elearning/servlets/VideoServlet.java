package com.elearning.servlets;

import com.elearning.db.VideoDAO;
import com.elearning.beans.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int courseId = Integer.parseInt(request.getParameter("courseId"));
        VideoDAO videoDAO = new VideoDAO();

        try {
            List<Video> videos = videoDAO.getVideosByCourseId(courseId);
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("videos.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
