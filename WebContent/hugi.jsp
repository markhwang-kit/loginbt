<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.naver.dto.HugiPrintDto"%>
<%@page import="java.util.ArrayList"%>
    
<%@ include file="top.jsp" %>
<%
	ArrayList<HugiPrintDto> list = (ArrayList<HugiPrintDto>)request.getAttribute("hugiList");
%>

<!-- bar-rating -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-bar-rating/1.2.2/themes/fontawesome-stars.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-bar-rating/1.2.2/jquery.barrating.min.js"></script>

<div class="container">					
<h3>여기에 후기가 쫙!~</h3>
  <table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>영화제목</th>
        <th>후기제목</th>
        <th>점수</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>

<% for (HugiPrintDto d : list) { %>
     <tr>
        <td><%=d.getNo() %></td>
        <td><%=d.getJe() %></td>
        <td><%=d.getTitle() %></td>
        <td><%=d.getScore() %></td>
        <td><%=d.getName() %></td>
      </tr>
<% } %>
    
    </tbody>
  </table>
</div>								

<script>
$(document).ready(function(){
//     $.get("movieok.nhn",
//     function(data, status){
//     	var html = "";
//     	console.log(data);
// //     	console.log(data.items);
//     	$.each(data, function(key, field){
//     		console.log(key);	
//     		console.log(field);	
// //     		html += "<a href='" + field.link + "' target='_blank'>"
// //     		html += "<img src='" + field.img + "'></a><br>";
// //     		html += field.je + "<br>";
// //     		html += field.gam + "<br>";
// //     		html += field.bae + "<br>";
//           });
// 		$("#result").html(html);
//     });
});
</script>
</body>
</html>