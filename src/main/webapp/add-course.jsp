<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Course</title>
</head>
<body>

<h2>Add a New Course</h2>

<form action="CourseServlet" method="POST">
    <label for="courseName">Course Name:</label><br>
    <input type="text" name="courseName" placeholder="Course Name" required /><br><br>

    <label for="courseDescription">Course Description:</label><br>
    <input type="text" name="courseDescription" placeholder="Course Description" required /><br><br>

    <label for="videoUrl">Video URL:</label><br>
    <input type="text" name="videoUrl" placeholder="Video URL" required /><br><br>

    <button type="submit">Add Course</button>
</form>

</body>
</html>
