<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<script type="text/javascript">

messageSuccess = "Informações salvas com sucesso!";
messageError = "Erro ao salvar informações!";
messageWarning = "Verifique as mensagens de alerta!";
messageConfirmDelete = "Deseja excluir o registro?";

function goPage(page) {
    $('#pageNum').val(page);
    $("#sform").submit();
}

	function Add() {
		($("#descriptionActivityTypeGroup")).val('');
		$(".newRow").delay(20).fadeToggle();
	};

	function InsertForm() {
		var par = $(this).parent().parent();
		var dsActivityTypeGroup = par.children("td:nth-child(1)");
		InsertUpdate(null, dsActivityTypeGroup.children("input[type=text]").val());
		$(".newRow").delay(1500).fadeToggle();
	};
	
	function SaveGrid() {
		var par = $(this).parent().parent();
		var idActivityTypeGroup = $(par.children(".idActivityTypeGroup")).val();
		var dsActivityTypeGroup = par.children("td:nth-child(2)");
		var dtCreated = par.children("td:nth-child(3)");
		var nmUserCreated = par.children("td:nth-child(4)");
		var tdButtons = par.children("td:nth-child(5)");
		dsActivityTypeGroup.html(dsActivityTypeGroup.children("input[type=text]").val());
		dtCreated.html(dtCreated.children("input[type=text]").val());
		nmUserCreated.html(nmUserCreated.children("input[type=text]").val());
		tdButtons
				.html("<span class='glyphicon glyphicon-edit btnEditGrid'></span>&nbsp&nbsp&nbsp<span class='glyphicon glyphicon-remove btnDelGrid'></span> ");

		$(".btnEditGrid").bind("click", EditGrid);
		$(".btnDelGrid").bind("click", RemoveGrid);

		InsertUpdate(idActivityTypeGroup, dsActivityTypeGroup.html());

	};

	function EditGrid() {
		var par = $(this).parent().parent();
		var dsActivityTypeGroup = par.children("td:nth-child(2)");
		var dtCreated = par.children("td:nth-child(3)");
		var nmUserCreated = par.children("td:nth-child(4)");
		var tdButtons = par.children("td:nth-child(5)");
		dsActivityTypeGroup.html("<input type='text' id='dsActivityTypeGroup' value='"+ dsActivityTypeGroup.html() + "'/>");
		tdButtons.html("<span class='glyphicon glyphicon-ok btnSaveGrid'></span>&nbsp&nbsp&nbsp<span class='glyphicon glyphicon-remove btnDelGrid'></span> ");
		$(".btnSaveGrid").bind("click", SaveGrid);
		$(".btnDelGrid").bind("click", RemoveGrid);
	};

	function RemoveGrid(event) {
		
		var remove = confirm(messageConfirmDelete);
		
		if(remove==false){
			return;
		}

		var par = $(this).parent().parent();
		var idActivityTypeGroup = $(par.children(".idActivityTypeGroup")).val();
		par.remove();
		Delete(idActivityTypeGroup);
	};

	function InsertUpdate(id, description){
		var row = new Object();
		
		if(id != null){
			row.idActivityTypeGroup = id;	
		}		
		row.dsActivityTypeGroup = description;
		
		$.ajax({
            url:'${pageContext.request.contextPath}/saveactivitytypegroup',
            data:{idActivityTypeGroup:row.idActivityTypeGroup, dsActivityTypeGroup:row.dsActivityTypeGroup},
            type:'post',
            cache:false,
            success:function(data){
            	showSuccess(messageSuccess);
            },
            error:function(data, jqXHR, textStatus, errorThrown){
            	showError(messageError+" - "+errorThrown);
           }
         });

	};
	
	function Delete(id){
		var row = new Object();
		row.idActivityTypeGroup = id;
		
		$.ajax({
            url:'${pageContext.request.contextPath}/deleteactivitytypegroup',
            data:{idActivityTypeGroup:row.idActivityTypeGroup},
            type:'post',
            cache:false,
            success:function(data){
            	showSuccess(messageSuccess);
            },
            error:function(jqXHR, textStatus, errorThrown){
            	showError(messageError+" - "+errorThrown);
           }
         });
	};
		 
	$(function(e) {
		$(".btnEditGrid").bind("click", EditGrid);
		$(".btnDelGrid").bind("click", RemoveGrid);
		$(".btnAdd").bind("click", Add);
		$(".btnSaveGrid").bind("click", SaveGrid);
		$(".btnInsertForm").bind("click", InsertForm);
	});
	
</script>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/activitytypegroup">Grupo de Tipos de Atividade</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
        <li class="active btnAdd"><a href="#">Novo Registro<span class="sr-only">(current)</span></a></li>
      </ul>
      <form class="navbar-form navbar-left listactivitytype" action="${pageContext.request.contextPath}/listactivitytypegroup" method="post">
        <div class="form-group">
          <input type="text" class="form-control" name="dsActivityTypeGroup" value="${row.dsActivityTypeGroup}" placeholder="descrição">
        </div>
        <button type="submit" class="btn btn-default">Pesquisar</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="newRow" style="display:none">
	<table>
		Descrição do grupo de tipos de Atividade
		</br>
		<td><input type="text" name="dsActivityTypeGroup" id="descriptionActivityTypeGroup" class="descriptionActivityTypeGroup"></td>
		<td>&nbsp&nbsp&nbsp <span class='glyphicon glyphicon-ok btnInsertForm' id="InsertMain"></span></td>
	</table>

	<div id="message"></div>
</div>



<div>
	<c:if test="${not empty listActivityTypeGroup}">
		<table class="table table-striped">
			<thead>
				<th>Descrição</th>
				<th>Data da Criação</th>
				<th>Usuário da Criação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${listActivityTypeGroup}">
					<tr>
						<input type="hidden" class="idActivityTypeGroup"
							value=${row.idActivityTypeGroup}></input>
						<td class="dsActivityTypeGroup">${row.dsActivityTypeGroup}</td>
						<td><fmt:formatDate value="${row.dtCreated}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td>${row.nmUserCreated}</td>
						<td><span class="glyphicon glyphicon-edit btnEditGrid"
							id="EditMain"></span>&nbsp&nbsp&nbsp <span
							class="glyphicon glyphicon-remove btnDelGrid" id="DeleteMain"></span></td>
						<th></th>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>