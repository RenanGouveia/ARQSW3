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
		
		<label>Filme: </label><input type="text" name ="nome"><br>
		<label>Diretor: </label><input type="text" name="diretor"><br>
		<label>Descrição: </label><input type="text" name="descricao"><br>
		<label>Popularidade: </label><input type="number" name="popularidade"><br>
		<label>Data Lançamento: </label><input type="date" name="dataLancamento">
		<br>		
		<input type="submit">
			
	
	</form>
</body>
</html>