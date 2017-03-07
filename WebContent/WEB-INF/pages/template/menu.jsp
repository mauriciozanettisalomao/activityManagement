<script type="text/javascript">
$(document).ready(function() {
    $(".dropdown-toggle").dropdown();
    alert("123");
});
</script>


<ul class="nav nav-tabs">
	<li><a href="${pageContext.request.contextPath}/">Home</a></li>
<!-- 	<li role="presentation" class="dropdown"><a -->
<!-- 		class="dropdown-toggle" data-toggle="dropdown" role="button" -->
<!-- 		aria-haspopup="true" aria-expanded="false"> Gestão de Atividades <span -->
<!-- 			class="caret"></span> -->
<!-- 			<ul class="dropdown-menu"> -->
<!-- 			<li><a href="#">Action</a></li> -->
<!--             <li><a href="#">Another action</a></li> -->
<!--             <li><a href="#">Something else here</a></li> -->
<%-- 				<li><a href="${pageContext.request.contextPath}/activitytype">Teste1</a></li> --%>
<!-- 			</ul> -->
<!-- 	</a></li> -->
	<li><a href="${pageContext.request.contextPath}/activitytypegroup">Grupos de Tipo de Atividade</a></li>
	<li><a href="${pageContext.request.contextPath}/activitytype">Tipos de Atividade</a></li>
</ul>
