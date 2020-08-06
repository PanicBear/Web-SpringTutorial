<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${value1} 더하기 ${value2}는 ${result} 입니다.
	<!-- 
	EL 표기법 
	
	인식 안될 경우, 버전 낮아서 그럼

	1. project properties - project facets
		Dynamic Web Modue 3.1로 변경

	2. web.xml에서 버전 표기 제거 
	
		<!DOCTYPE web-app PUBLIC
 			"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 			"http://java.sun.com/dtd/web-app_2_3.dtd" >
	
		<?xml version = "1.0" encoding = "UTF-8"?> 위에꺼 이렇게 바꾸기
		
	3. 실행중인 서버의 프로젝트 제거, 서버 중지 후 서버 재시작

-->

</body>
</html>