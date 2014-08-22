(function($){
	
	$().ready(function(){
		
		$.context = {
				mensagemErro: [],
				botoesDesativados: false
			};
		
		$('.hide').hide();
		
		
		$(".item-table-action").click(function() {$.markTableItem(this);});
		
		$.extend({
			disableButtonsAndSubmit: function (desativar,url){
				if(desativar){
					if(!$.context.botoesDesativados){
						$.context.botoesDesativados = true;
						$(".bt").removeClass("bt").addClass("btdisabled");
						$(".btn-action").removeClass("btn-action").addClass("btn-action-disabled");
						$(".loading-footer").fadeIn('fast', function() {});
						$("#form").attr("action", url).submit();
					}
				}
				else{
					$.context.botoesDesativados = false;
					$(".btdisabled").removeClass("btdisabled").addClass("bt");
					$(".btn-action-disabled").removeClass("btn-action-disabled").addClass("btn-action");
				}
			},
			disableButtons: function (desativar){
				if(desativar){
					if(!$.context.botoesDesativados){
						$.context.botoesDesativados = true;
						$(".bt").removeClass("bt").addClass("btdisabled");
						$(".btn-action").removeClass("btn-action").addClass("btn-action-disabled");
						$(".loading-footer").fadeIn('fast', function() {});
					}
				}
				else{
					$.context.botoesDesativados = false;
					$(".btdisabled").removeClass("btdisabled").addClass("bt");
					$(".btn-action-disabled").removeClass("btn-action-disabled").addClass("btn-action");
				}
			},
			preValidate: function(){
				var correct = true;
				$.context.mensagemErro = [];
				if(!$.validateEmpty().liberado){
					correct = false;
					$.context.mensagemErro.push($.validateEmpty().mensagem);
				}
				if(!$.validateSelected().liberado){correct = false;$.context.mensagemErro.push($.validateEmpty().mensagem);}
				if(!$.validateDate().liberado){correct = false;$.context.mensagemErro.push($.validateDate().mensagem);}
				if(!$.validateEmail().liberado){correct = false;$.context.mensagemErro.push($.validateEmail().mensagem);}
				return correct;
			},
			validateEmpty: function(){
				var correct = true;
				$( ".obrigatorio:input[type='text'],select.obrigatorio,.obrigatorio:input[type='password'],textarea.obrigatorio" ).each(function() {
									
					if($.trim($(this).val())==""){
						$(this).css("border","solid 1px #ff0000");
						correct = false;
					}
					else{
						$(this).css("border","solid 1px #BFBFBF"); 
					}
				});
				
				return {liberado: correct, mensagem: "Por favor preencha os campos obrigatórios"};
			},
			validateSelected: function(){
				var correct = true;		
				return {liberado: correct, mensagem: "Por favor preencha os campos obrigatórios"};
			},
			validateDate: function(){
				var correct = true;
				$( ".data" ).each(function() {
					if($.trim($(this).val())!=""){
						if(!$.isValidDate($(this).val())){
							$(this).css("border","solid 1px #ff0000");
							correct = false;
						}
						else{
							$(this).css("border","solid 1px #BFBFBF"); 
						}
					}
				});
				return {liberado: correct, mensagem: "Por favor preencha uma data válida"};
			},
			validateEmail: function(){
				var correct = true;
				$( ".email" ).each(function() {
					if($.trim($(this).val())!=""){
						if(!$.isValidEmail($(this).val())){
							$(this).css("border","solid 1px #ff0000");
							correct = false;
						}
						else{
							$(this).css("border","solid 1px #BFBFBF"); 
						}
					}
				});
				return {liberado: correct, mensagem: "Por favor preencha um e-mail válido"};
			},
			isValidDate: function(s) {
			    // format D(D)/M(M)/(YY)YY
			    var dateFormat = /^\d{1,4}[\.|\/|-]\d{1,2}[\.|\/|-]\d{4}$/;

			    if (dateFormat.test(s)) {
			        // remove any leading zeros from date values
			        s = s.replace(/0*(\d*)/gi,"$1");
			        var dateArray = s.split(/[\.|\/|-]/);
			      
			        // correct month value
			        dateArray[1] = dateArray[1]-1;

			        // correct year value
			        if (dateArray[2].length<4) {
			            // correct year value
			            dateArray[2] = (parseInt(dateArray[2]) < 50) ? 2000 + parseInt(dateArray[2]) : 1900 + parseInt(dateArray[2]);
			        }

			        var testDate = new Date(dateArray[2], dateArray[1], dateArray[0]);
			        if (testDate.getDate()!=dateArray[0] || testDate.getMonth()!=dateArray[1] || testDate.getFullYear()!=dateArray[2]) {
			            return false;
			        } else {
			            return true;
			        }
			    } else {
			        return false;
			    }
			},
			isValidEmail: function(email) {
			    regex = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;
			    if(regex.exec(email))
			        return true;
			    else
			        return false;
			},
			isValidUF: function(uf) {
				regex = /^([A-Z]{2})$/;
				if(regex.exec(uf))
					return true;
				else
					return false;
			},
			isValidCPF: function(campo){
				 erro = new String;
				 cpfv = $(campo).val();
				if(cpfv.length == 14 || cpfv.length == 11){
				    cpfv = cpfv.replace('.', '');
				    cpfv = cpfv.replace('.', '');
				    cpfv = cpfv.replace('-', '');
				
				    var nonNumbers = /\D/;
				
				    if(nonNumbers.test(cpfv)){
				        erro = "A verificacao de CPF suporta apenas números!";
				    }else{
				        if (cpfv == "00000000000" ||
				            cpfv == "11111111111" ||
				            cpfv == "22222222222" ||
				            cpfv == "33333333333" ||
				            cpfv == "44444444444" ||
				            cpfv == "55555555555" ||
				            cpfv == "66666666666" ||
				            cpfv == "77777777777" ||
				            cpfv == "88888888888" ||
				            cpfv == "99999999999") {
				                                                
				            erro = "Número de CPF inválido!"
				        }
				        var a = [];
				        var b = new Number;
				        var c = 11;
				
				        for(i=0; i<11; i++){
				            a[i] = cpfv.charAt(i);
				            if (i < 9) b += (a[i] * --c);
				        }
				        if((x = b % 11) < 2){
				            a[9] = 0
				        }else{
				            a[9] = 11-x
				        }
				        b = 0;
				        c = 11;
				        for (y=0; y<10; y++) b += (a[y] * c--);
				
				        if((x = b % 11) < 2){
				            a[10] = 0;
				        }else{
				            a[10] = 11-x;
				        }
				        if((cpfv.charAt(9) != a[9]) || (cpfv.charAt(10) != a[10])){
				            erro = "Número de CPF inválido.";
				        }
				    }
				}else{
				    if(cpfv.length == 0){
				        return false;
				    }else{
				        erro = "Número de CPF inválido.";
				    }
				}
							
		        if (erro.length > 0){
		            $(campo).val('');
		            alert(erro);
		            setTimeout(function(){$(campo).focus();},100);
		            return false;
		        }			
			},
			markTableItem: function(item){
				try{
					var tempTable = $($(item).parents().eq(1)).dataTable();
		
					if($(item).hasClass('item-table-selected')){
						$(tempTable.fnGetNodes()).each(function() {
							$(this).removeClass("item-table-selected").addClass("gradeX odd even hover-table");
						});
						$.showActionsButtons($(item),false);
					}
					else{
						$(tempTable.fnGetNodes()).each(function() {
							$(this).removeClass("item-table-selected").addClass("gradeX odd even hover-table");
						});
						var no = tempTable.fnGetNodes(tempTable.fnGetPosition($(item).closest('tr').get(0)));
						$(no).removeClass("gradeX odd even hover-table").addClass("item-table-selected");
						$.showActionsButtons($(item),true);
					}
				}catch (e) {}
			},
			openFancyBox : function(url,largura,altura){
            	var temp = $('<div>');
    			$(temp).fancybox({
    				width		: (largura == null ? '90%' : largura),
    				height		: (altura == null ? '90%' : altura),
    				autoSize	: false,
    				closeClick	: false,
    				openEffect	: 'none',
    				closeEffect	: 'none',
    				type:'iframe',
    				href : url
    			}).click();
            }
			
		});
			
		
	});
	
})(jQuery);