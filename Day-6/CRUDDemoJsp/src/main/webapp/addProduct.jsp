<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addproduct">
Product Id : <input type="text" name="pid" id="pid"><br>
Product name : <input type="text" name="pname" id="pname"><br>
Product Quantity : <input type="text" name="qty" id="qty"><br>
Product Price : <input type="text" name="price" id="price"><br>
Product Expire Date : <input type="date" name="expdate" id="expdate"><br>
Product Category ID : <input type="text" name="cid" id="cid"><br>
<button type="submit" name="btn" id="btn" value="add">Add Product</button>
</form><br>
<a href="logout">Logout</a>
</body>
</html>