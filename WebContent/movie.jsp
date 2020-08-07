<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>

<div class="container">

<h3>영화 랭킹 출력</h3>
<!-- <button type="button" class="btn btn-success" onclick="modal_show('영화제목')">후기작성</button><br> -->
<div id="result"></div>


 <!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">영화 후기 작성</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
       
            <div class="form-group">
              <label for="m_tit">영화제목:</label>
              <input type="text" class="form-control" id="m_tit" placeholder="영화제목" name="m_tit">
            </div>
            <div class="form-group">
              <label for="name">작성자:</label>
              <input type="text" class="form-control" id="name" placeholder="작성자" name="name">
            </div>
           <div class="form-group">
              <label for="h_tit">후기제목:</label>
              <input type="text" class="form-control" id="h_tit" placeholder="후기제목" name="h_tit">
            </div>
    
            <div class="form-group">
              <label for="hugi">후기 작성:</label>
              <textarea class="form-control" rows="5" id="hugi" name="hugi"></textarea>
            </div>
            

        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">작성완료</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
	</div>
	</div>
 <!-- The Modal -->
</div>  
<script>
function modal_show (je) {
    $("#myModal").modal("show");
    console.log(je);
}

$(document).ready(function(){
//     $("#close_modal").click(function() {
//         $("#myModal").modal("hide");
//     });
	
	var search = $("#search").val();
	$("#result").html("여기에 찍히나: " + search);
	console.log(search);
    $.get("movieok.nhn",
    function(data, status){
    	var html = "";
    	console.log(data);
//     	console.log(data.items);
    	$.each(data, function(key, field){
    		console.log(key);	
    		console.log(field);	
    		html += "<a href='" + field.link + "' target='_blank'>"
    		html += "<img src='" + field.img + "'></a><br>";
    		html += field.je + "<br>";
    		html += field.gam + "<br>";
    		html += field.bae + "<br>";
//     		html += "<input type='hidden' value='" + field.num + "'>";
    		html += '<button type="button" class="btn btn-success" onclick="modal_show(' + field.num +')">후기작성</button><br>>';
//     		html += '<button type="button" class="btn btn-success">후기작성</button><br>';
          });
		$("#result").html(html);
    });
});
</script>
</body>
</html>