<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

deleteForm.jsp<br>


<form method="post" action="delete.bod?num=${num }">
	<%-- <input type="hidden" name="num" value="<%=num %>"> --%>
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1" align="center">
		<tr>
			<td>비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<td>비밀번호: <input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onClick="location.href='list.bod?pageNumber=${pageNumber}'">
			</td>
		</tr>
	</table>
</form>