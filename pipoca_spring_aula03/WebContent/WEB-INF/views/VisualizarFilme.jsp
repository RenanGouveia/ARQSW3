<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Filme</title>

            <link href="/pipoca_spring_aula03/css/bootstrap.min.css" rel="stylesheet">
            <link href="/pipoca_spring_aula03/css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Filme</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir este filme?
                            </div>
                            <div class="modal-footer">
                                <form action="/pipoca_spring_aula03/excluir_filme" method="post">
                                    <input type="hidden" name="id" value="${filme.id}" />
                                    <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                
                
                
                
	<div id="main" class="container">
		<h3 class="page-header">${filme.id} - ${filme.titulo}</h3>
		<div class="row">
			<div class="col-md-4">
				<img alt="?" src="/pipoca_spring_aula03/${filme.posterPath}" class="img-responsive">
			</div>
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-12">
						<p><strong>Gênero:&nbsp;</strong>${filme.genero.nome}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<p><strong>Direção:&nbsp;</strong>${filme.diretor}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<p>${filme.descricao}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<p><strong>Lançamento:&nbsp;</strong>
							<fmt:formatDate value="${filme.dataLancamento}" pattern="dd/MM/yyyy"/></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<p><strong>Popularidade:&nbsp;</strong>${filme.popularidade}</p>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="/pipoca_spring_aula03/editar_filme/${filme.id}" class="btn btn-primary">Editar</a> 
				<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a> 
				<a href="/pipoca_spring_aula03/listar_filmes" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="/pipoca_spring_aula03/js/jquery.min.js"></script>
    <script src="/pipoca_spring_aula03/js/bootstrap.min.js"></script>
    <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('filme');
                    $("#id_excluir").val(recipient);
                });
    </script>
  </body>
</html>