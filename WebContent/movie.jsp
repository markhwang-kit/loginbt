<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>
<% if (dto == null) { %>
<script> 
	alert("로그인을 하면 이용 가능 합니다."); 
	location.href='login.nhn';
</script>
<% } %>

<div class="container">

<h3>영화 랭킹 출력</h3>
<div id="result"></div>

</div> 
<script>
$(document).ready(function(){
	var search = $("#search").val();
	$("#result").html("여기에 찍히나: " + search);
	console.log(search);
    $.get("movieok.nhn",
    function(data, status){
    	var html = "";
//     	console.log(data['total']);
//     	console.log(data.items);
//     	$.each(data.items, function(key, field){
//     		html += "<a href='" + field.link + "' target='_blank'>"
//     		html += field.title + "</a><br>";
// //             $("div").append(field + " ");
// //     		console.log("Data: " + field.title);  // field['title']
//           });
// 		$("#result").html(html);
    });
});
</script>
</body>
</html>