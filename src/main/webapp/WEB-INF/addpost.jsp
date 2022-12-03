<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.crud.myapp.board.BoardDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.crud.myapp.board.BoardVO" />
<jsp:setProperty property="*" name="u"/>

<%
	BoardDAO boardDAO = new BoardDAO();
	int i = boardDAO.insertBoard(u);
	String msg = "Data Add Success !";
	if(i == 0) msg = "Error Adding Data ";
%>

<script>
	alert('<%=msg%>');
	location.href='posts.jsp';
</script>