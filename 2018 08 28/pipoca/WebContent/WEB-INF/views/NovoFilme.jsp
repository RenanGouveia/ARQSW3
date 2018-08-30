<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Filme</title>
</head>
<body>
	<form action="inserir" method="post" >
		
		<h2>Filme: </h2><input type="text" name ="nome">
		<h2>Diretor: </h2><input type="text" name="diretor">
		<h2>Descrição: </h2><input type="text" name="descricao">
		<h2>Data Lançamento: </h2><input type="date" name="dataLancamento">
		
		<br>
		
		
		<input type="submit">
			
	
	</form>
</body>
</html>