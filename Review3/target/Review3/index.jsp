<%--
  Created by IntelliJ IDEA.
  User: xxachark
  Date: 3/24/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <title>Student Record</title>
</head>
<body>
<form action="insertion" method="post">
    <h2>Student Details</h2>
    <div class="form-group">
        <label>Register number</label>
        <input type="number" class="form-control" name="reg_no" placeholder="Enter reg no">
    </div>
    <div class="form-group">
        <label>Student name</label>
        <input type="text" class="form-control" name="name" placeholder="Enter name">
    </div>
    <div class="form-group">
        <label>Age</label>
        <input type="number" class="form-control" name="age" placeholder="Enter age">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" class="form-control" name="email" placeholder="Enter Email">
    </div>

    <h2>Current Address</h2>

    <div class="form-group">
        <label>Street</label>
        <input type="text" class="form-control" name="street" placeholder="Enter Street">
    </div>
    <div class="form-group">
        <label>Door No</label>
        <input type="text" class="form-control" name="door_no" placeholder="Enter door no">
    </div>
    <div class="form-group">
        <label>City</label>
        <input type="text" class="form-control" name="city" placeholder="Enter City">
    </div>
    <div class="form-group">
        <label>Pincode</label>
        <input type="number" class="form-control" name="pincode" placeholder="Enter pincode">
    </div>


    <h2>Permanent Address</h2>
    <div class="form-group">
        <label>Door No</label>
        <input type="text" class="form-control" name="permanent_door_no" placeholder="Enter door no">
    </div>
    <div class="form-group">
        <label>Street</label>
        <input type="text" class="form-control" name="permanent_street" placeholder="Enter Street">
    </div>
    <div class="form-group">
        <label>City</label>
        <input type="text" class="form-control" name="permanent_city" placeholder="Enter City">
    </div>
    <div class="form-group">
        <label>Pincode</label>
        <input type="number" class="form-control" name="permanent_pincode" placeholder="Enter pincode">
    </div>

    <button type="submit" class="btn btn-primary">Login</button>
</form>

</body>
</html>