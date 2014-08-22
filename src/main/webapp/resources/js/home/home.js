(function($) {

$().ready(function() {
	
		$.paramsPage = {
	    		contexto : "/opinerama/produto/",
	    };
       
        if($('#mensagemIndex').val() != ''){
        	$.gerarNotificacao("topCenter","warning",false,"Atenção",$('#mensagemIndex').val());
		}
        
        $('.cad-categoria').click(function(){
        	window.location.href = "/opinae/categoria";
        });
        
        $('.cad-fornecedor').click(function(){
        	window.location.href = "/opinae/fornecedor";
        });
        
        $('.avaliar-produto').click(function(){
        	window.location.href = "/opinae/perfilProduto";
        });
        
        $('.pesquisaProduto').click(function(){
        	$.produtoPesq();
		});
        
        
        $('#nome-produto').keydown(function(event) {
            if(event.which === 13) {
            	$.produtoPesq();
            }
          });
        
        $.extend({
        	
        	produtoPesq : function(){
        		if($.trim($('.nome-produto').val()).length > 0){
            		$('body').css({'cursor':'wait'});
            		var url = $.paramsPage.contexto+"resultados";
            		$("#form").attr("action", url).submit();
            		$('.total-produtos').append($('#nome-produto-pesq').val());
            	}else{
            		alert('Por favor, digite o nome do produto');
            	}
        	}
        	
        });
        
        
});

})(jQuery);