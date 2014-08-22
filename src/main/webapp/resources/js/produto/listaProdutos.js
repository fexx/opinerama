(function($) {

$().ready(function() {
        $.paramsPage = {
        		contexto : "/opinerama/produto/",
        };
        
        
        $('#bt-buscar-produto').click(function(){$.pesquisaProduto();});
		
		$("#nome-produto-pesq").keydown(function(event) {
            if(event.which === 13) {
            	$.pesquisaProduto();
            }
          });
        
		$.extend({
			
			pesquisaProduto : function(){
				if($.trim($('#nome-produto-pesq').val()).length > 0){
					$(".buscando-loading").addClass('loading-cicle');
					$('.produtos-encontrados').load($.paramsPage.contexto +"listaProduto/termo/"+$('#nome-produto-pesq').val()+"/categoria/"+$('#idCategoriaSuperPai').val());
					$('.total-produtos').append($('#nome-produto-pesq').val());
					$(".buscando-loading").removeClass('loading-cicle');
				}else{
					alert('Por favor, digite o nome do produto');
				}
			}
			
		});	
		
});

})(jQuery);