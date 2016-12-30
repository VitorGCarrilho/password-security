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
    $.ajax({
    	  method: "POST",
    	  url: "/home",
    	  data: { dsSenha: senha},
    	  success:function(data){
    		  refreshFields(data);
    	  }
    	  
    })
    .done(function( msg ) {
    	//$("#qtNumCaracteres").reload();
    	//$('#qtNumCaracteres').load('home');
   });
});

function refreshFields(data){
	var json = JSON.parse(data);

    $.each(json, function(i, item) {
        var obj = json[i];
        console.log(obj);
    });
}