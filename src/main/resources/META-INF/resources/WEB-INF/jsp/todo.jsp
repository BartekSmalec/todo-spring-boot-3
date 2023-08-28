<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add todo Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div><h1> Enter todo details </h1></div>
    <form method="post">
        Description: <input type="text" name="description">
        <input type="submit" class="btn btn-success"/>

    </form>

</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>