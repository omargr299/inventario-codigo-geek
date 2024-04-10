import { bindForm } from "./form.mjs";

import { createActivo,createAsociacion,createPropietario, createUbicacion } from './data.mjs';


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
    console.log('Form submitted');
    const formData = new FormData(form);

    
    if (formData.get('IdPropietario')) {
        console.log('con propietario');
        const ubicacion = await createUbicacion(formData);
        console.log(ubicacion);
        await createPropietario(formData);
        console.log(await createActivo(formData,ubicacion.idUbicacion));
        await createAsociacion(formData);
    }
    else{
        console.log('sin propietario');
        await createActivo(formData);
    }
    



});
