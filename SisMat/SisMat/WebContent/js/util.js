function fn_validaEntero(e) {
	tecla = (document.all) ? e.keyCode : e.which;
	if (tecla==8 || tecla==0) return true; //Tecla de retroceso (para poder borrar)
	patron = /[0-9]/;
	te = String.fromCharCode(tecla);
	return patron.test(te);
}

function showPopUp(page, formId, width, height) {
	var pathArray = (window.location.pathname).split('/');
	var newPathname = "";
	for ( var i = 0; i < pathArray.length-1; i++ ) {
	  newPathname += pathArray[i];
	  newPathname += '/';
	}
	
	var pdfWin = window.open(newPathname+page,formId,'width='+width+',height='+height+',toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes');
    if (window.focus) {
    	pdfWin.focus();
    }
    return false;
}