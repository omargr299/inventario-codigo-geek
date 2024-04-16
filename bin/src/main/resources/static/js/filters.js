// Get the query parameters from the URL
const urlParams = new URLSearchParams(window.location.search);

// Get the form element
const form = document.getElementById('filterForm');

// Set the query parameters in the form inputs
form.querySelector('input[name="query"]').value = urlParams.get('query');
form.querySelector('input[name="fechaAdquiStart"]').value = urlParams.get('fechaAdquiStart');
form.querySelector('input[name="fechaAdquiEnd"]').value = urlParams.get('fechaAdquiEnd');
form.querySelector('select[name="ubicacion"]').value = urlParams.get('ubicacion');
form.querySelector('select[name="status"]').value = urlParams.get('status');