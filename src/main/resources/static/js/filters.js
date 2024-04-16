// Get the query parameters from the URL

const urlParams = new URLSearchParams(window.location.search);

// Get the form element
const form = document.getElementById('filterForm');

const query = form.querySelector('input[name="query"]')
const fechaAdquiStart = form.querySelector('input[name="fechaAdquiStart"]')
const fechaAdquiEnd = form.querySelector('input[name="fechaAdquiEnd"]')
const ubicacion = form.querySelector('select[name="ubicacion"]')
const statusForm = form.querySelector('select[name="status"]')

// Set the query parameters in the form inputs
query.value = urlParams.get('query');
fechaAdquiStart.value = urlParams.get('fechaAdquiStart');
fechaAdquiEnd.value = urlParams.get('fechaAdquiEnd');
ubicacion.value = urlParams.get('ubicacion');
statusForm.value = urlParams.get('status');

statusForm.addEventListener('change',(e)=>{
	if(e.target.value=="no_encontrado"){
		ubicacion.value=0;
		ubicacion.disabled=true;
		console.log(ubicacion.disaabled)
	}
	else{
		ubicacion.disabled=false;
	}
})