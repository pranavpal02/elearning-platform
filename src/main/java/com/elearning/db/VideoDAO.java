package com.elearning.db;

import com.elearning.beans.Video;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    // Method to get videos for a specific course
    public List<Video> getVideosByCourseId(int courseId) throws SQLException {
        List<Video> videos = new ArrayList<>();
        String query = "SELECT * FROM videos WHERE course_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                videos.add(new Video(
                    rs.getInt("id"),
                    rs.getInt("course_id"),
                    rs.getString("video_title"),
                    rs.getString("video_url")
                ));
            }
        }
        return videos;
    }
}
