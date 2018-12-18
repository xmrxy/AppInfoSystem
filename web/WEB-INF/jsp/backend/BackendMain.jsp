<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/backend/common/header.jsp" %>
<div class="page-title">
	<div class="title_left">
		<h3>
			<h3>
			欢迎你：${backendUser.userName }<strong> | 角色：${dictionary.valueName }</strong>
			</h3>
		</h3>
	</div>
</div>
<div class="clearfix"></div>        
<%@include file="/WEB-INF/jsp/backend/common/footer.jsp" %>
     