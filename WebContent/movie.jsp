<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>

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
    	console.log(data);
//     	console.log(data.items);
    	$.each(data, function(key, field){
//     		html += "<a href='" + field.link + "' target='_blank'>"
    		html += "<img src='" + field.img + "'></a><br>";
    		html += field.je + "<br>";
    		html += field.gam + "<br>";
    		html += field.bae + "<br>";
          });
		$("#result").html(html);
    });
});
</script>
</body>
</html>