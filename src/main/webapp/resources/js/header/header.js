(function($) {

$().ready(function() {
       
        $('#login').click(function(){
        	$.openFancyBoxInterno("/opinae/login");
        });
        
        $('#cadastre').click(function(){
        	$.openFancyBoxInterno("/opinae/conta/criar");
        });
        
        $('#logado').click(function(){
        	$.informacoesUsuario();
        });
        
        $('#topo-logo').click(function(){
        	window.location.href = "/opinae/";
        });
        
        $('#logout').click(function(){
        	window.location.href = "/opinae/conta/logout";
        });
        
        $.extend({
	        openFancyBoxInterno : function(url){
	        	$.fancybox({
	        		'width': '50%',
					'height': '50%',
	                'autoScale': true,
	                'autoDimensions': true,
	                'autoHeight' : true,
	                'autoWidth' : true,
	                'type': 'ajax',
	                'onComplete' : function () {
	                	$.fancybox.center();
	                },
	                'afterClose' :function () {
				    	$('.noty.warning').remove();
				    },
	                'href': url
	            });
	        },
	        
	        informacoesUsuario : function(){
//				if($('#logado').attr('tipousuario') == 'FACEBOOK'){
//					window.open('http://www.facebook.com/'+$('#logado').attr('idusuario'));
//				}else{
					window.location.href = '/opinae/usuario/informacoes/'+$('#logado').attr('idusuario');
//				}
			}
    });
        
});

})(jQuery);