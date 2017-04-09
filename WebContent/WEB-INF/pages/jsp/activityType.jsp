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
		($("#descriptionActivityType")).val('');
		$(".newRow").delay(20).fadeToggle();
	};

	function InsertForm() {
		var par = $(this).parent().parent();
		var idActivityTypeGroup = $('select[name="descriptionActivityTypeGroup"]').val();
		var dsActivityType = par.children("td:nth-child(3)");
		InsertUpdate(null, dsActivityType.children("input[type=text]").val(),idActivityTypeGroup);
		$(".newRow").delay(1500).fadeToggle();
	};
	
	function SaveGrid() {
		var par = $(this).parent().parent();
		var idActivityType = $(par.children(".idActivityType")).val();
		var dsActivityType = par.children("td:nth-child(2)");
		var dtCreated = par.children("td:nth-child(3)");
		var nmUserCreated = par.children("td:nth-child(4)");
		var tdButtons = par.children("td:nth-child(5)");
		dsActivityType.html(dsActivityType.children("input[type=text]").val());
		dtCreated.html(dtCreated.children("input[type=text]").val());
		nmUserCreated.html(nmUserCreated.children("input[type=text]").val());
		tdButtons
				.html("<span class='glyphicon glyphicon-edit btnEditGrid'></span>&nbsp&nbsp&nbsp<span class='glyphicon glyphicon-remove btnDelGrid'></span> ");

		$(".btnEditGrid").bind("click", EditGrid);
		$(".btnDelGrid").bind("click", RemoveGrid);

		InsertUpdate(idActivityType, dsActivityType.html(), null);

	};

	function EditGrid() {
		var par = $(this).parent().parent();
		var dsActivityType = par.children("td:nth-child(2)");
		var dtCreated = par.children("td:nth-child(3)");
		var nmUserCreated = par.children("td:nth-child(4)");
		var tdButtons = par.children("td:nth-child(5)");
		dsActivityType.html("<input type='text' id='dsActivityType' value='"+ dsActivityType.html() + "'/>");
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
		var idActivityType = $(par.children(".idActivityType")).val();
		par.remove();
		Delete(idActivityType);
	};

	function InsertUpdate(id, description, idGroup){
		var row = new Object();
		
		if(id != null){
			row.idActivityType = id;	
		}		
		row.dsActivityType = description;
		row.idActivityTypeGroup = idGroup;
		
		$.ajax({
            url:'${pageContext.request.contextPath}/saveactivitytype',
            data:{idActivityType:row.idActivityType, dsActivityType:row.dsActivityType, idActivityTypeGroup:row.idActivityTypeGroup},
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
		row.idActivityType = id;
		
		$.ajax({
            url:'${pageContext.request.contextPath}/deleteactivitytype',
            data:{idActivityType:row.idActivityType},
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
      <a class="navbar-brand" href="${pageContext.request.contextPath}/activitytype">Tipo de Atividade</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
        <li class="active btnAdd"><a href="#">Novo Registro<span class="sr-only">(current)</span></a></li>
      </ul>
      <form class="navbar-form navbar-left listactivitytype" action="${pageContext.request.contextPath}/listactivitytype" method="post">
        <div class="form-group">
          <input type="text" class="form-control" name="dsActivityType" value="${row.dsActivityType}" placeholder="descrição">
        </div>
        <button type="submit" class="btn btn-default">Pesquisar</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="newRow" style="display:none">
	<table>
		<tr><td>Grupo </td><td>&nbsp&nbsp&nbsp</td><td> <select name='descriptionActivityTypeGroup'>
			<option value="${selected}" selected id="descriptionActivityTypeGroup">${selected}</option>
			<c:forEach items="${listActivityTypeGroup}" var="row">
				<c:if test="${row != selected}">
					<option value="${row.idActivityTypeGroup}">${row.dsActivityTypeGroup}</option>
				</c:if>
			</c:forEach>
		</select></td></tr>
		<tr>
		<td>Descrição </td><td>&nbsp&nbsp&nbsp</td><td> <input type="text" name="dsActivityType" id="descriptionActivityType" class="descriptionActivityType"></td>
		<td>&nbsp&nbsp&nbsp <span class='glyphicon glyphicon-ok btnInsertForm' id="InsertMain"></span></td>
		</tr>
	</table>

	<div id="message"></div>
</div>



<div>
	<c:if test="${not empty listActivityType}">
		<table class="table table-striped">
			<thead>
				<th>Descrição</th>
				<th>Data da Criação</th>
				<th>Usuário da Criação</th>
				<th>Grupo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${listActivityType}">
					<tr>
						<input type="hidden" class="idActivityType"
							value=${row.idActivityType}></input>
						<td class="dsActivityType">${row.dsActivityType}</td>
						<td><fmt:formatDate value="${row.dtCreated}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td>${row.nmUserCreated}</td>
						<td>${row.activityTypeGroup.dsActivityTypeGroup}</td>
						<td><span class="glyphicon glyphicon-edit btnEditGrid"
							id="EditMain"></span>&nbsp&nbsp&nbsp <span
							class="glyphicon glyphicon-remove btnDelGrid" id="DeleteMain"></span></td>
						<th></th>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>