<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
// 	functions	
	public int myFactorial(int n ){
		int fact = 1;
		for(int i=1;i<=n;i++){
			fact = fact*i;
			}
	return fact;
}	

%>

<%
	String btn = request.getParameter("btn");
	if(btn.equals("add")){
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		int addition = n1+n2;
	
%>
Addition : <%=addition%>
<%
	}else{
		int n = Integer.parseInt(request.getParameter("num1"));
		int factorial = myFactorial(n);
%>
Factorial : <%=factorial%>
<% 		
	}
%>

</body>
</html>