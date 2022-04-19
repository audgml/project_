<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp"%>
<%@ include file="../user/ustop.jsp"%>
<!--  회원정보<br> -->
<style>
body {
	width: 60%;
	margin: auto;
}
</style>
<link href="form-validation.css" rel="stylesheet">
</head>

<body class="bg-light">
	<main>
		<div class="row g-5">
			<div class="d-block mx-auto mb-6">
				<h2 class="mb-3">학생 정보</h2>
					<div class="row g-3">

						<input type="hidden" name="anum" value="${mbean.anum }"> 
						<input type="hidden" name="type" value="student">

						<div class="col-4">
							<label for="id" class="form-label">아이디</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control" value="${mbean.id }" disabled="disabled">
							</div>
						</div>

						<div class="col-3"></div>

						<div class="col-5"></div>

						<div class="col-4">
							<label for="pw" class="form-label">비밀번호</label>
							<div class="input-group has-validation">
								<input type="password" class="form-control" value="${mbean.pw }" disabled="disabled">
							</div>
						</div>

						<div class="col-8"></div>
						<div class="col-4"></div>
						<div class="col-8"></div>

						<div class="col-4">
							<label for="aname" class="form-label">이름*</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control" value="${mbean.aname }" disabled="disabled">
							</div>
						</div>

						<div class="col-1"></div>

						<div class="col-6">
							<label for="aname" class="form-label">주민등록번호</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control" value="${mbean.rrn1 }" disabled="disabled">&nbsp;<b>-</b>&nbsp; 
								<input type="password" class="form-control" value="${mbean.rrn2 }" disabled="disabled">
							</div>
						</div>
						
						<div class="col-4">
							<label for="aname" class="form-label">지역정보</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control" value="${mbean.addr }" disabled="disabled">
							</div>
						</div>

						<div class="col-12">
							<label for="email" class="form-label">E-mail*</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control" value="${mbean.email }" disabled="disabled">
							</div>
						</div>

						<div class="col-12">
							<label for="phone" class="form-label">핸드폰 번호*</label>
							<div class="input-group has-validation">
								<!-- <span class="input-group-text">@</span> -->
								<input type="text" class="form-control" value="${mbean.phone1 }" disabled="disabled"> &nbsp;<b>-</b>&nbsp; 
								<input type="text" class="form-control" value="${mbean.phone2 }" disabled="disabled"></a> &nbsp;<b>-</b>&nbsp; 
								<input type="text" class="form-control" value="${mbean.phone3 }" disabled="disabled"></a>
							</div>
						</div>

						<div class="col-4"></div>

						<div class="col-8"></div>

						<div class="col-4">
							<label for="id" class="form-label">회원가입일</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control" value="${mbean.joindate }" disabled="disabled"></a>
							</div>
						</div>
						
						<div class="col-12"></div>
						
						<div class="d-grid gap-2 col-6 mx-auto">
  							<button class="btn btn-primary" type="button" onClick="history.back()">뒤로가기</button>
  							<button class="btn btn-primary" type="button" onClick="location.href='update.mem?anum=${loginInfo.anum}'">내 정보 관리</button>
						</div>
					</div>
			</div>
		</div>
	</main>

<%@ include file="../user/usbottom.jsp"%>