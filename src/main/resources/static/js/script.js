(function() {

	var PasswordToggler = function(element, field) {
		this.element = element;
		this.field = field;

		this.toggle();
	};

	PasswordToggler.prototype = {
		toggle : function() {
			var self = this;
			self.element.addEventListener("change", function() {
				if (self.element.checked) {
					self.field.setAttribute("type", "text");
				} else {
					self.field.setAttribute("type", "password");
				}
			}, false);
		}
	};

	document.addEventListener("DOMContentLoaded", function() {
		var checkbox = document.querySelector("#show-hide"), pwd = document
				.querySelector("#password"), form = document
				.querySelector("#passwordSecurity");

		form.addEventListener("enviar", function(e) {
			e.preventDefault();
		}, false);

		var toggler = new PasswordToggler(checkbox, pwd);

	});

})();

$('#password').on('input', function(e) {
	// alert('Changed!')
	var senha = $('#password').val();
	var nrChar = null;
	$.ajax({
		method : "POST",
		url : "/verificarsenha",
		data : {
			dsSenha : senha
		},
		success : function(data) {
			atualizarFormulario(data);
		}

	}).done(function(msg) {

	});
});

function atualizarFormulario(data) {
	atualizarClassificacao(data);
	atualizarCampos(data);
}
function atualizarClassificacao(data) {
	
	$("#pontuacao").width(data.soma);
	removeClasses("#pontuacao", 'progress-bar-');
	$("#pontuacao").addClass(
			"progress-bar-" + data.classificacaoSenha.classeClassificacao);
	$('#valorPontuacao').text(data.soma + '%');
	removeClasses('#classificacao', 'label-');
	$('#classificacao').addClass(
			"label-" + data.classificacaoSenha.classeClassificacao);
	$('#classificacao').text(data.classificacaoSenha.dsClassificacao);
}
function atualizarCampos(data){
	$('#qtNumCaracteres').val(data.qtNumCaracteres);
	$('#bnsNumCaracteres').text(data.bnsNumCaracteres);
	$('#qtCarcMinusculos').val(data.qtCarcMinusculos);
	$('#bnsCarcMinusculos').text(data.bnsCarcMinusculos);
	$('#qtCarcMaiusculos').val(data.qtCarcMaiusculos);
	$('#bnsCarcMaiusculos').text(data.bnsCarcMaiusculos);
	$('#qtNumbers').val(data.qtNumbers);
	$('#bnsNumbers').text(data.bnsNumbers);
	$('#qtSimbolos').val(data.qtSimbolos);
	$('#bnsSimbolos').text(data.bnsSimbolos);
	$('#qtSeqNumSimb').val(data.qtSeqNumSimb);
	$('#bnsSeqNumSimb').text(data.bnsSeqNumSimb);
	$('#qtRequisitos').val(data.qtRequisitos);
	$('#bnsRequisitos').text(data.bnsRequisitos);
	$('#qtApenasLetras').val(data.qtApenasLetras);
	$('#bnsApenasLetras').text(data.bnsApenasLetras);
	$('#qtApenasNumeros').val(data.qtApenasNumeros);
	$('#bnsApenasNumeros').text(data.bnsApenasNumeros);
	$('#qtCarcRepetidos').val(data.qtCarcRepetidos);
	$('#bnsCarcRepetidos').text(data.bnsCarcRepetidos);
	$('#qtCaracMaiusculosConsecutivos').val(data.qtCaracMaiusculosConsecutivos);
	$('#bnsCaracMaiusculosConsecutivos').text(data.bnsCaracMaiusculosConsecutivos);
	$('#qtCaracMinusculosConsecutivos').val(data.qtCaracMinusculosConsecutivos);
	$('#bnsCaracMinusculosConsecutivos').text(data.bnsCaracMinusculosConsecutivos);
	$('#qtNumerosConsecutivos').val(data.qtNumerosConsecutivos);
	$('#bnsNumerosConsecutivos').text(data.bnsNumerosConsecutivos);
	$('#qtSequenciaLetras').val(data.qtSequenciaLetras);
	$('#bnsSequenciaLetras').text(data.bnsSequenciaLetras);
	$('#qtSequenciaNumeros').val(data.qtSequenciaNumeros);
	$('#bnsSequenciaNumeros').text(data.bnsSequenciaNumeros);
	$('#qtSequenciaSimbolos').val(data.qtSequenciaSimbolos);
	$('#bnsSequenciaSimbolos').text(data.bnsSequenciaSimbolos);
	console.log(data.qtSequenciaLetras);
}
function removeClasses(id, classe) {
	$(id).removeClass(classe + "danger");
	$(id).removeClass(classe + "warning");
	$(id).removeClass(classe + "info");
	$(id).removeClass(classe + "success");
}