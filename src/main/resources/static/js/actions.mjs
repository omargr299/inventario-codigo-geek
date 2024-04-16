import {openPropietierDialog} from './viewPropietier.mjs'
import { bindForm, checkErrors, showCancel } from "./form.mjs";
import { deleteActivo, editActivo, getActivo, getPropAssociation } from './data.mjs';

await bindForm("#editForm");
const dialog = document.querySelector('#editForm');

const form = dialog.querySelector('form');
form.addEventListener('submit', async (event) => {
    event.preventDefault();
    const error = checkErrors(dialog);
    if (error) return;
    const formData = new FormData(form);
    const idActivo = formData.get('IdActivo');
    await editActivo(idActivo, formData);
    const idPropietario = formData.get('IdPropietario');
    if (!idPropietario) return;
    await editActivo(idPropietario,formData);
    window.location.reload();
});

const activos = document.querySelectorAll('.activo');
const deleteConfirm = document.querySelector('#delete-confirm');
activos.forEach(activo => {
    const editButton = activo.querySelector('.edit');
    const deleteButton = activo.querySelector('.delete');
    const viewButton = activo.querySelector('.view');

    editButton.addEventListener('click', async function() {
        const id = editButton.getAttribute('data-id');
        const activo = await getActivo(id);
        dialog.querySelector('#nombre').value = activo.nombre;
        dialog.querySelector('#total').value = activo.total;
        dialog.querySelector('#descripcion').value = activo.descripcion;
        dialog.querySelector('#detalle').value = activo.detalle;
        dialog.querySelector('#fechaAdqui').value = activo.fechaAdqui.substring(0, 10);
        dialog.querySelector('#ubicacion').value = activo.ubicacion.idUbicacion;
        dialog.querySelector('#status').value = activo.status;
     
        if(activo.ubicacion.idUbicacion >= 3) {
            document.querySelector('#editForm #propietier-container').classList.remove('d-none');
            const propietario = await getPropAssociation(activo.idActivo);
            console.log(propietario);
            dialog.querySelector('#IdPropietario').value = propietario.idPropietario;
            dialog.querySelector('#nombrePropietario').value = propietario.nombre;
            dialog.querySelector('#apellidoPaterno').value = propietario.apellidoPaterno;
            dialog.querySelector('#apellidoMaterno').value = propietario.apellidoMaterno;
        }
        else{
            document.querySelector('#editForm #propietier-container').classList.add('d-none');
        }

        dialog.showModal();
    });

    dialog.querySelector('#cancel').addEventListener('click', () => {
        showCancel(dialog);
        dialog.close();
    });

    deleteButton.addEventListener('click', async function() {
        
        deleteConfirm.innerHTML = `
            <p>¿Estás seguro de que deseas eliminar '${activo.getAttribute('data-name')}'?</p>

            <button id="closeConfirm" class="btn btn-outline-danger" id="close">Cerrar</button>
            <button id="aceptConfirm" class="btn btn-danger" id="close">Eliminar</button>
        `

        deleteConfirm.showModal();

        deleteConfirm.querySelector('#closeConfirm').addEventListener('click', () => {
            deleteConfirm.close();
        });

        deleteConfirm.querySelector('#aceptConfirm').addEventListener('click', async () => {
            deleteActivo(activo.getAttribute('data-id'),activo);
            deleteConfirm.close();
        });
    });

    if (viewButton === null) return;
    viewButton.addEventListener('click', function() {
        openPropietierDialog(activo.getAttribute('data-id'));
    });
});
