import { bindForm } from "./form.mjs";

import { createActivo,createAsociacion,createPropietario, createUbicacion } from './data.mjs';
import { errorToast } from "./toast.mjs";


await bindForm("#addForm");
const dialog = document.querySelector('#addForm');


const addButton = document.querySelector('#add');
const cancelButton = dialog.querySelector('#cancel');

addButton.addEventListener('click', () => {
    dialog.showModal();
});

cancelButton.addEventListener('click', () => {
    dialog.close();
});

const form = dialog.querySelector('form');
form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const errors = Array.from(dialog.querySelectorAll('.error'));
    const res = errors.every(error => error.classList.contains('d-none'));
    if (!res){
        errorToast('Por favor, corrija los errores en el formulario');
        return
    }

    console.log('Form submitted');
    const formData = new FormData(form);

    
    if (formData.get('IdPropietario')) {
        console.log('con propietario');
        const ubicacion = await createUbicacion(formData);
        console.log(ubicacion);
        const propietario = await createPropietario(formData);
        const activo = await createActivo(formData,ubicacion.idUbicacion);
        await createAsociacion(activo , propietario);
    }
    else{
        console.log('sin propietario');
        await createActivo(formData);
    }
});
