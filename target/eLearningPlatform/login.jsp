<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <!-- External CSS for styling -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            max-width: 500px;
            margin: 40px auto;
            background-color: #fff;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h2 {
            text-align: center;
            color: #4CAF50;
            margin-bottom: 20px;
        }

        label {
            font-size: 1rem;
            color: #555;
            margin: 10px 0;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            font-size: 1rem;
            border-radius: 5px;
            border: 1px solid #ddd;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            font-size: 1rem;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        p {
            text-align: center;
            font-size: 1rem;
            color: #555;
        }

        a {
            color: #4CAF50;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .error-message {
            color: red;
            font-size: 0.9rem;
            text-align: center;
        }

        .success-message {
            color: green;
            font-size: 0.9rem;
            text-align: center;
        }

        .form-footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Login</h2>

        <form action="LoginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required/><br/>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required/><br/>

            <input type="submit" value="Login"/>
        </form>

        <!-- Error message display -->
        <div class="error-message">
            <p>
                <% 
                    String error = request.getParameter("error");
                    if (error != null) {
                        out.print(error);
                    }
                %>
            </p>
        </div>

        <!-- Success message for successful registration -->
        <div class="success-message">
            <p>
                <% 
                    String msg = request.getParameter("msg");
                    if (msg != null) {
                        out.print("Registration successful. Please login.");
                    }
                %>
            </p>
        </div>

        <!-- Footer with link to Register -->
        <div class="form-footer">
            <p>New user? <a href="register.jsp">Register here</a></p>
        </div>
    </div>

</body>
</html>
