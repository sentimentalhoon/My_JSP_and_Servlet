<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%
int firstNumber = 0;
int secondNumber = 0;
int numPlus = 0;
request.setCharacterEncoding("utf-8");
String op = request.getParameter("op");
Gson gson = new Gson();
try {
	/* request객체에서 받아온 파라미터값 저장 */
	
	firstNumber = Integer.parseInt(request.getParameter("first"));
	secondNumber = Integer.parseInt(request.getParameter("second"));	
	numPlus = firstNumber + secondNumber;

%>
{ "code" : "ok", "firstNumber" : "<%=firstNumber%>", "secondNumber" : "<%=secondNumber%>",
"op" : "<%=op%>", "numPlus" : "<%=numPlus%>" }
<%
} catch (NumberFormatException exp) {
%>
{ "code" : "숫자 입력이 틀렸습니다.", "firstNumber" : "0", "secondNumber"
: "0", "op" : "0", "numPlus" : "0" }
<%
}
%>