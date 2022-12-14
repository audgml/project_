<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../admin/adtop.jsp" %>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="star-rating.css">
<script type="text/javascript">
	$(document).ready(function(){
		$("#s1").click(function(){
			$(".fa-star").css("color","black");
			$("#s1").css("color","yellow");
		});
		$("#s2").click(function(){
			$(".fa-star").css("color","black");
			$("#s1,#s2").css("color","yellow");
		});
		$("#s3").click(function(){
			$(".fa-star").css("color","black");
			$("#s1,#s2,#s3").css("color","yellow");
		});
		$("#s4").click(function(){
			$(".fa-star").css("color","black");
			$("#s1,#s2,#s3,#s4").css("color","yellow");
		});
		$("#s5").click(function(){
			$(".fa-star").css("color","black");
			$(".fa-star").css("color","yellow");
		}); */
		
		var rating = $('.review .rating');
		rating.each(function(){
			var targetScore = $(this).attr('data-rate');
			$(this).find('svg:nth-child(-n+' + targetScore +')').css({color:'#F05522'});
		});
		
		var userScore = $('#makeStar');
		userScore.change(function(){
			var userScoreNum = $(this).val();
			console.log(userScoreNum);
			$('.make_star svg').css({color:'#000'});
			$('.make_star svg:nth-child(-n' + userScoreNum +')').css({color:'#F05522'});
		});
		
		$('.make_star svg').click(function({
			var targetNum = $(this).index +1 ;
			$('.make_star svg').css({color:'#000'});
			$('.make_star svg:nth-child(-n+' + targetNum +')').css({color:'#F05522'});
		});
		
	});
</script>
<style type="text/css" >

	body{
		text-align:center;
	}
	
	table{
		margin:auto;
	}
	
	.err{
			color:red;
			font-weight:bold;
			font-size:9pt;
	}

	.star-rating {
	  border:solid 1px #ccc;
	  display:flex;
	  flex-direction: row-reverse;
	  font-size:1.5em;
	  justify-content:space-around;
	  padding:0 .2em;
	  text-align:center;
	  width:5em;
	}
	
	.star-rating input {
	  display:none;
	}
	
	.star-rating label {
	  color:#ccc;
	  cursor:pointer;
	}
	
	.star-rating :checked ~ label {
	  color:#f90;
	}
	
	.star-rating label:hover,
	.star-rating label:hover ~ label {
	  color:#fc0;
	}
	
	article {
	  background-color:#ffe;
	  box-shadow:0 0 1em 1px rgba(0,0,0,.25);
	  color:#006;
	  font-family:cursive;
	  font-style:italic;
	  margin:4em;
	  max-width:30em;
	  padding:2em;
	}
	
	.con{
		height:60px;
		width:500px;
		position:absolute;
		margin:auto;
		left:0;
		right:0;
		top:0;
		bottom:0;
	}
	
	.fa-star{
		font-size:65px;
	}	 
</style>

<!-- writeForm.jsp -->
<br><br>
<h2 align="center">???????????? ??????</h2>
<br>
<!-- BSBean bsbean -->
<form:form commandName="BSBean" method="post" action="insert.bs" enctype="multipart/form-data">
	<table border="0" width="40%" height="60%">

		<tr>
			<td align="center" width="100" bgcolor="#DCDCDC">??????</td>
			<td>
				<input type="text" name="writer" class="form-control" id="floatingInput" placeholder="???????????? ??????????????????">
				<form:errors cssClass="err" path="writer"/>
			</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#DCDCDC">??????</td>
			<td>
				<input type="text" name="subject" class="form-control" id="floatingInput" placeholder="????????? ??????????????????">
				<form:errors cssClass="err" path="subject"/>
			</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#DCDCDC">Email</td>
			<td><input type="text" name="email" class="form-control" id="floatingInput" placeholder="???????????? ??????????????????"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#DCDCDC">?????????</td>
			<td>
				<input class="form-control" id="formFile" type="file" name="upload" value="????????????"> <!-- ????????? ??????x ?????????o(??????)??? ???????????????. -->
			</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#DCDCDC">??????</td>
			<td>
				<textarea name="content" rows="15" cols="50" class="form-control" placeholder="????????? ??????????????????" id="floatingTextarea" style="resize:none;"></textarea>
				<form:errors cssClass="err" path="content"></form:errors>
			</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#DCDCDC">????????????</td>
			<td>	
				<div class="star-rating"> <!-- ????????????:????????? ??????, ??? ????????????(select, update??? ????????? ??????????????? ?????????) -->
				  <input type="radio" id="5-stars" name="rating" value="5"/>
				  <label for="5-stars" class="star">&#9733;</label>
				  <input type="radio" id="4-stars" name="rating" value="4"/>
				  <label for="4-stars" class="star">&#9733;</label>
				  <input type="radio" id="3-stars" name="rating" value="3"/>
				  <label for="3-stars" class="star">&#9733;</label>
				  <input type="radio" id="2-stars" name="rating" value="2"/>
				  <label for="2-stars" class="star">&#9733;</label>
				  <input type="radio" id="1-star" name="rating" value="1"/>
				  <label for="1-star" class="star">&#9733;</label>
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#DCDCDC">????????????</td>
			<td>
				<input type="password" name="passwd" class="form-control" id="floatingPassword" placeholder="???????????? ??????????????????">
				<form:errors cssClass="err" path="passwd" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<br>
				<input class="btn btn-secondary btn-sm" type="submit" value="?????????">
				<input class="btn btn-secondary btn-sm" type="reset" value="????????????">
				<input class="btn btn-secondary btn-sm" type="button" value="????????????" onClick="location.href='list.bs'">
			</td>
		</tr>
	</table>
</form:form>
<%@ include file="../admin/adbottom.jsp" %> 
