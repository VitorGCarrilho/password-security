(function() {
	
	var PasswordToggler = function( element, field ) {
		this.element = element;
		this.field = field;
		
		this.toggle();	
	};
	
	PasswordToggler.prototype = {
		toggle: function() {
			var self = this;
			self.element.addEventListener( "change", function() {
				if( self.element.checked ) {
					self.field.setAttribute( "type", "text" );
				} else {
					self.field.setAttribute( "type", "password" );	
				}
            }, false);
		}
	};
	
	document.addEventListener( "DOMContentLoaded", function() {
		var checkbox = document.querySelector( "#show-hide" ),
			pwd = document.querySelector( "#password" ),
			form = document.querySelector( "#passwordSecurity" );
			
			form.addEventListener( "enviar", 
					function( e ) {
						e.preventDefault();
					}, false);
			
			var toggler = new PasswordToggler( checkbox, pwd );
		
	});
	
})();

$('#password').on('input',function(e){
    //alert('Changed!')
    var senha = $('#password').val();
    var nrChar = null;
    $.ajax({
    	  method: "POST",
    	  url: "/verificarsenha",
    	  data: { dsSenha: senha},
    	  success:function(data){
    		  console.log(data);
    		  $('#qtNumCaracteres').val(data.qtNumCaracteres);
    		  $("#pontuacao").width(data.soma);
    		  removePogressBarClasses("#pontuacao",'progress-bar-');
    		  $("#pontuacao").addClass("progress-bar-"+data.classificacaoSenha.classeClassificacao);
    		  $('#valorPontuacao').text(data.soma+'%');
    		  
    		  console.log("progress-bar-"+data.classificacaoSenha.classeClassificacao);
    	  }
    	  
    })
    .done(function( msg ) {
  
   });
});

function refreshFields(data){
	//console.log(data.qtNumCaracteres);
	$('#qtNumCaracteres').val('eita');
}
function removePogressBarClasses(id, classe){
	$(id).removeClass(classe+"danger");
	$(id).removeClass(classe+"warning");
	$(id).removeClass(classe+"info");
	$(id).removeClass(classe+"success");
}