<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body bgcolor="brown">
  <h1>Customer Details</h1>
  <div style="background-color:aqua;height:180px;width: 300px;">
<h2>

Mobile No : &nbsp; <c:out value="${customer.mobileNo}"/><br>
Name :  &nbsp;<c:out value="${customer.name}"/><br>
Balance : &nbsp;<c:out value="${customer.balance}"/><br>
Account Type : &nbsp;<c:out value="${customer.accountType}"/><br>
</h2>
</div>
</body>
</html>