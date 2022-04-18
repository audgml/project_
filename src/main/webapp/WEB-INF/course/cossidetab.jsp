<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>   
<%@ include file="../user/ustop.jsp"%> 

<a href="start.jsp">시작페이지</a> <br>
<a href="logout.jsp">로그아웃</a>

sidetab<br>

<style type="text/css">

		* { /* 기본적인 마진,패딩 없앰*/
			margin:0;
			padding:0; 
			text-decoration : none; /* 밑줄 없애기 */
			list-style : none; /* 불릿 없애기 */
		}
		
		body { 
				width:100%;
				margin-top:30px;
		}
		
		h1 {
				font:20px "맑은 고딕",돋움,arial; 
				color:#fff;
				background-color:#690;
				border-radius:20px;
				padding:5px 30px;
				margin-bottom:20px;
		}
		
		/* img Layout */
		#teacher-img{
				
				border : 1px solid #D8D8D8;
				display : block;
				margin : 10px auto;
		}
		
		#category{
			   float:left;
			   text-align:center;
			   margin:80px 100px; /* 80px 위아래 auto 좌우 */
			   width:200px;
			   border : 1px solid #D8D8D8;
			   background-color:#F6F6F6;
			   /*border : 1px solid #D8D8D8; 바탕보다 진한 테두리 설정*/
			   /*float:left;*/
		}
		
		#category-top{

			    background-color:#365E43;
			    border : 1px solid #365E43;
			    width:200px;
			    line-height: 50px;
		}
		
		#category-center{
		 		background-color:white;
				text-color : #6C757D;
			    border : 1px solid #D8D8D8;
			    width:200px;
				line-height: 40px;
				text-decoration : none;
		}
		
		#main-title {
				float:left;
				width:800px;
				text-align:center;
				margin:80px auto;
				background-color:#F6F6F6;
				/*border-radius:10px;*/ /* 테두리 둥글게 설정 */
		}
		
		button{
			   background-color:gray;
			   width:110px;
			   border:0;
			   outline:0;
		}
		
		#td-title{ /* 강의 제목 설정 */
			   text-align:left;
		}
		
		/*
		footer {
				height: 120;
      			display:block;
				position: absolute;
				left: 200;
				bottom: 0;
				width: 100%;
				text-align: center;
      	}
      	
      	*/
      	a {
      			text-decoration : none; 
      	}
      	
      	#button1{ /* 수강신청 버튼 색상 설정 */
      			border : 1px solid #35BCAE;
		      	background-color:#35BCAE;
      	}
      	
      	#button2{ /* 강의질문 버튼 색상 설정 */
      			border : 1px solid gray;
		      	background-color: gray;
      	}
      	
      	#foot{
      			float:left;
      			width:100%;
      			text-align: center;
      	}
</style>
<body>
	<aside>
		<table id="category">
			<tr id="category-top">
				<td><a href="list.cos"><font color="white"><b>전체강좌</b></font></a></td>
			</tr>
			<tr id="category-center">
				<td><a href="side.cos"><font color="6C757D"><b>JAVA</b></font></a></td>
			</tr>
			<tr id="category-center">
				<td><a href=""><font color="6C757D"><b>DB</b></font></a></td>
			</tr>
			<tr id="category-center">
				<td><a href=""><font color="6C757D"><b>JSP</b></font></a></td>
			</tr>
			<tr id="category-center">
				<td><a href=""><font color="6C757D"><b>CSS</b></font></a></td>
			</tr>
			<tr id="category-center">
				<td><a href=""><font color="6C757D"><b>HTML</b></font></a></td>
			</tr>
		</table>
	</aside>	

<section>
	<div id="main-title">
		<h1>강좌 리스트 화면(coslist.jsp)</h1>
		<form action="list.cos" method="GET">
			<select name="whatColumn">
				<option value="">선택
				<option value="coname">강의명
				<option value="coteacher">선생님
				<option value="cosubject">과목명
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
		<table width="800">
			<tr>
				<td align="right" colspan="5">
					<input type="button" value="추가하기" onclick="insert()">
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<br>
				</td>
			</tr>
			<tr>
				<!-- <th>상품번호</th> -->
				<th align="center">이미지</th>
				<th align="center">강의명</th>
				<!-- <th>설명</th> -->
				<th align="center">가격</th>
				<th align="center">버튼</th>
				<th align="center">삭제|수정</th>
			</tr>
			<c:forEach var="course" items="${list}">
			<c:if test="${course=='JAVA'}">
			<tr>
				<td>
					<img id="teacher-img" src="<%=request.getContextPath()%>/resources/images/${course.coimage}" width=80 height=80>
				</td>
				<%-- <td>
					<c:out value="${course.conum }" />
				</td>	 --%>			
				<td>
					<a href="detail.cos?conum=${course.conum }&pageNumber=${pageInfo.pageNumber }">${course.coname }</a>
				</td>
				<%-- <td>
					${course.cocontent }
				</td> --%>
				<td>
					<fmt:formatNumber value="${course.coprice}" pattern="#,###"/>원
				</td>
				<td>
					<a href=""><button id="button1" type="button" class="btn btn-secondary btn-sm">수강신청 &nbsp;<img src="<%=request.getContextPath() %>/resources/images/book-outline.svg" width="20" height="20"/></button></a> &nbsp;
					<a href=""><button id="button2" type="button" class="btn btn-secondary btn-sm">강의질문 &nbsp;<img src="<%=request.getContextPath() %>/resources/images/질문게시판.svg" width="20" height="20"/></button></a>
				</td>
				<td colspan="2">
					<input type="button" value="수정">
					<input type="button" value="삭제">
				</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="5">
					<hr>
				</td>
			</tr>
			</c:forEach>
		</table>
		${pageInfo.pagingHtml }
	</div>
</section>

	
<div id=foot>
<hr>
<br><br>	
<%@ include file="../user/usbottom.jsp"%>
</div>
</body>