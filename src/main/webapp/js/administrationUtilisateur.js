// Ajouter utilisateur

function ajouterUtilisateur(event){
	if(/*verificationMail($("#newMail").val())&&*/$("#newNom").val().length>1&&$("#newPrenom").val().length>1&&$("#newEcole").val().length>1){
		var confirmation= confirm("Etes vous sur de vouloir creer cet utilisateur");
	} else {
		alert("Veuillez remplir tous les champs de textes");
	}
	alert("ok");
	
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				requete:"inscription",
				mail:$("#newMail").val(),
				nom:$("#newNom").val(),
				prenom:$("#newPrenom").val(),
				mdp:$("#newMdp").val(),
				rang:$("#newRang").val(),
				ecole:$("#newEcole").val(),
				pageGere:$("#pageGere").val()
			}
		})
		alert("L'utilisateur a bien été ajouté!");
		window.location.replace("administrationUtilisateur");
	}
}
$("#caseajouterUtilisateur").click(function(){ajouterUtilisateur(event);});

function montrerFormulaireCreationUtilisateur(event){
	$("#ajoutUtilisateur").show();
	$("#montrerFormCreationUtilisateur").hide();
	$("#modifierUtilisateur").hide();
}
$("#montrerFormCreationUtilisateur").click(function(){montrerFormulaireCreationUtilisateur(event);});



//verificationMail
function verificationMailExistance(mail){
	var rep=false;
	var positionArobase=1;
	while(mail.charAt(positionArobase)!='@' && positionArobase<mail.length){
		positionArobase++;
	}
	var positionPoint=positionArobase;
	while(mail.charAt(positionPoint)!='.' && positionPoint<mail.length){
		positionPoint++;
	}

	if(0<positionArobase && positionArobase<positionPoint-1 && positionPoint<mail.length-1){
		rep=true;
	}
	return rep;
}


// Supprimer utilisateur
function supprimerUtilisateur(event){
	var confirmation= confirm("Etes vous sur de vouloir creer cet utilisateur : "+event.currentTarget.id);
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				requete:"suppression",
				mail:event.currentTarget.id
			}
		})
		alert("L'utilisateur a bien été ajouté!");
		window.location.replace("administrationUtilisateur");
	}
}
$(".casesupprimer").click(function(){supprimerUtilisateur(event);});

// MODIFIER UTILISATEUR
function montrerFormulaireModifierUtilisateur(event){
	$("#modifierUtilisateur").show();
	$("#ajoutUtilisateur").hide();
	var mail="";
	for (var i=23;i<event.currentTarget.id.length;i++){
		mail=mail+event.currentTarget.id[i];
	}
	$("#modMail").val(mail);
}
$(".caseModifierUtilisateur").click(function(){montrerFormulaireModifierUtilisateur(event);});


function cacherNewGerePage(){
	if ($("#newRang option:selected").val()=="administrateur"){
		$("#pageGeretr").hide();
	} else {
		$("#pageGeretr").show();
	}	
}
$( "#newRang" ).change(function() {
	cacherGerePage();
});

function cacherModifGerePage(){
	if ($("#modRang option:selected").val()=="administrateur"){
		$("#modpageGeretr").hide();
	} else {
		$("#modpageGeretr").show();
	}	
}
$( "#modRang" ).change(function() {
	cacherModifGerePage();
});
function modifierUtilisateur(event){
	var confirmation= confirm("Etes vous sur de vouloir modifier cet utilisateur ?");
	if(confirmation){
		$.ajax({
			url:"administrationUtilisateur",
			type:"POST",
			dataType:"json",
			data:{
				requete:"modification",
				mail:$("#modMail").val(),
				rang:$("#modRang").val(),
				ecole:$("#modEcole").val(),
				pageGere:$("#modPageGere").val()
			}
		})
		alert("L'utilisateur a bien été modifié!");
		window.location.replace("administrationUtilisateur");
	}
}
$("#casemodifierUtilisateur").click(function(){modifierUtilisateur(event);});

