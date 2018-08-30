<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado</title>
</head>
<body>

	<label>Filme:</label> ${filme.nome}<br>
	<label>Diretor:</label> ${filme.diretor}<br>
	<label>Descrição:</label> ${filme.descricao}<br>
	<label>Popularidade:</label>${filme.popularidade}<br>
	<label>Data de Lançamento:</label> ${filme.dataLancamento}
	
</body>
</html>