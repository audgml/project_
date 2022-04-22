<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../user/ustop.jsp" %>
<style>
	main{
		width:1200px;
		/* margin:auto; */ 
		
	}
	h4{
		text-align: left;
	}
	
</style>
<link href="form-validation.css" rel="stylesheet">
</head>

<center>
	<main>
	<!-- <div class="py-5 text-center">
      <h2>강사 정보 보기</h2>
    </div> -->
	<br><br>    
    <div class="row g-5">
      <div class="d-block mx-auto mb-10">
        <h4 class="mb-3">강사 정보</h4>
		<form class="needs-validation" action="tcupdate.ad" method="post" enctype="multipart/form-data">
          <div class="row g-3">	
          
			<input type="hidden" name="anum" value="${tbean.anum }">
			<input type="hidden" name="tnum" value="${tbean.tnum }">
			<input type="hidden" name="type" value="teacher">
	
	        <div class="col-12">
              <!-- <label for="addr" class="form-label" id="label" align="center">강사사진</label> -->
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <img src="<%=request.getContextPath() %>/resources/images/${tbean.t_image}" width=150 height=180> 
				&nbsp;
				<c:set var="lenstr" value="${fn:length(tbean.t_image) }"/> 
				${fn:substring(tbean.t_image,37,lenstr)}
              </div>
            </div>

			<div class="col-6" style=text-align:left;>
              <label for="id" class="form-label" id="label">ID</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="id" class="form-control" value="${tbean.id }" disabled="disabled">
              </div>
            </div>
            
           <!-- <div class="col-2"></div> -->
            
            <div class="col-6" style=text-align:left;>
              <label for="pw" class="form-label" id="label">PW</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="password" name="pw" class="form-control" value="${tbean.pw }" disabled="disabled">
              </div>
            </div>
            <!--  -->
           
             <div class="col-6" style=text-align:left;>
              <label for="aname" class="form-label" id="label">이름</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="aname" class="form-control" value="${tbean.aname }" disabled>
              <div class="invalid-feedback">
                  이름을 작성해주세요.
                </div>
              </div>
            </div>
            
            <!-- <div class="col-2"></div> -->
            
            <div class="col-6" style=text-align:left;>
              <label for="aname" class="form-label" id="label">주민등록번호</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="rrn1" class="form-control" value="${tbean.rrn1 }" disabled>
                &nbsp;<b>-</b>&nbsp;
           		<input type="text" name="rrn2" class="form-control" value="${tbean.rrn2 }" disabled>
              </div>
            </div>
            <!--  -->
            <div class="col-6" style=text-align:left;>
              <label for="email" class="form-label" id="label">E-mail</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="email" class="form-control" value="${tbean.email }" disabled>
              <div class="invalid-feedback">
                  E-mail을 작성해주세요.
                </div>
              </div>
            </div>
            <!-- <div class="col-2"></div> -->
            <div class="col-6" style=text-align:left;>
              <label for="phone" class="form-label" id="label">핸드폰 번호</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="phone1" class="form-control" value="${tbean.phone1 }" disabled>
                &nbsp;<b>-</b>&nbsp;
                <input type="text" name="phone2" class="form-control" value="${tbean.phone2 }" disabled>
                &nbsp;<b>-</b>&nbsp;
                <input type="text" name="phone3" class="form-control" value="${tbean.phone3 }" disabled>
              <div class="invalid-feedback">
                  전화번호를 입력해주세요.
                </div>
              </div>
            </div>
            <!--  -->
            <div class="col-12" style=text-align:left;>
              <label for="addr" class="form-label" id="label">주소</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="sample4_postcode" name="addr_num" placeholder="우편번호" value="${fn:split(tbean.addr,'|')[1] } ${fn:split(tbean.addr,'|')[2] } (우편번호:${fn:split(tbean.addr,'|')[0] })" disabled>
				<span id="guide" style="color:#999"></span>
                <!-- <span class="input-group-text">@</span> -->
                <div class="invalid-feedback">
	               주소를 작성해주세요.
	            </div>
              </div>
            </div>
             
            <%-- 
            <div class="col-12">
              <label for="addr" class="form-label">주소</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="addr" class="form-control" value="${tbean.addr }">
	            <div class="invalid-feedback">
	               주소를 작성해주세요.
	            </div>
              </div>
            </div>
             --%>
            <!-- <div class="col-12"></div> -->
            <div class="col-6" style=text-align:left;>
              <label for="subject" class="form-label" id="label">과목</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
                <input type=text value="${tbean.subject }" class="form-control" disabled>
	            <div class="invalid-feedback">
	               과목을 선택해주세요.
	            </div>
              </div>
            </div>
			<!-- <div class="col-2"></div> -->
			<div class="col-6" style=text-align:left;>
              <label for="tterm" class="form-label" id="label">계약기간</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                 <!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
                <fmt:parseDate var="dateString" value="${tbean.tterm }" pattern="yyyy-MM-dd"></fmt:parseDate>	
				<input type="date" name="tterm" class="form-control" value="<fmt:formatDate value="${dateString }" type="both" pattern="yyyy-MM-dd"/>" disabled>
	            <div class="invalid-feedback">
	               계약기간을 선택해주세요.
	            </div>
              </div>
            </div>
            <!-- 
            <div class="col-12"></div>
             -->
            <div class="col-12" style=text-align:left;>
              <label for="tterm" class="form-label" id="label">강사소개</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <textarea class="form-control" name="introduction" style="height: 100px; resize: none;" disabled>${tbean.introduction }</textarea>
	            <div class="invalid-feedback">
	               강사소개를 입력해주세요.
	            </div>
              </div>
            </div>
            
            <div class="col-6" style=text-align:left;>
              <label for="twageratio" class="form-label" id="label">강사 임금 비율</label>
              <div class="input-group has-validation">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="twageratio" class="form-control" value="${tbean.twageratio }" disabled>
	            <div class="invalid-feedback">
	               임금 비율을 작성해주세요.
	            </div>
              </div>
            </div>
            <!-- <div class="col-2"></div> -->
            <div class="col-6" style=text-align:left;>
              <label for="visa" class="form-label" id="label">Visa</label>
              <div class="input-group">
                <!-- <span class="input-group-text">@</span> -->
                <input type="text" name="visa" class="form-control" value="${tbean.visa }" disabled>
              </div>
            </div>
            <hr class="my-4">
            <center>
			  <button type="button" class="btn btn-primary" onClick="history.back()" style="width:40%"> 마이페이지로 돌아가기 </button>
			</center>
		</div>
        </form>
      </div>
    </div>
  </main>
 </center>
  <!-- 
  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2021 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
   -->
<%@ include file="../user/usbottom.jsp" %>