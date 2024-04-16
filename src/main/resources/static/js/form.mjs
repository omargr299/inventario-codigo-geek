import { errorToast } from "./toast.mjs";

function isAlphaNumeric(str) {
    return !(/[^a-z0-9\s]+/.test(str));
}

function isAlpha(str) {
    return !(/[^a-z\s]+/.test(str));
}

function check(form,id,checkFunc,errorMessage='error'){
    const input = form.querySelector(`#${id}`);
    input.addEventListener('input', (event) => {
        const error = form.querySelector(`#error-${id}`)
        error.classList.toggle('d-none', checkFunc(event.target.value));
        error.textContent = checkFunc(event.target.value) ? '' : errorMessage;
    });
}

const cancelDialog = document.querySelector('#cancel-confirm');
export function showCancel(dialog){
    cancelDialog.showModal();

    cancelDialog.querySelector('#seguir').addEventListener('click', () => {
        cancelDialog.close();
    });

    cancelDialog.querySelector('#aceptar').addEventListener('click', () => {
        cancelDialog.close();
        const inputs = Array.from(dialog.querySelectorAll('input, select, textarea'));
        inputs.forEach(input => {
            input.value = '';
        });
        const errors = Array.from(dialog.querySelectorAll('.error'));
        errors.forEach(error => error.classList.add('d-none'));
        dialog.close();
    });
}



export function checkErrors(dialog){
    const errors = Array.from(dialog.querySelectorAll('.error'));
    const no_errors = errors.every(error => error.classList.contains('d-none'));
    if (!no_errors){
        errorToast('Por favor, corrija los errores en el formulario');
    }
    return !no_errors;
}

export async function bindForm(query){
    const dialog = document.querySelector(query);
    const res = await fetch(window.location.pathname + 'form')
    const formText = await res.text()
    dialog.innerHTML += formText
    const form = document.querySelector(query+' form');
	
    check(form,'nombre',isAlphaNumeric,'El nombre solo puede contener letras minisculas, sin acentos o numeros');

    const ubicacion = form.querySelector('#ubicacion');
    const propietierContainer = form.querySelector('#propietier-container');

    ubicacion.addEventListener('change', (event) => {
        if (event.target.value === '3') {
            propietierContainer.classList.remove('d-none');
            check(form,'nombrePropietario',isAlpha,'El nombre del propietario solo puede contener letras minisculas, sin acento');
            check(form,'apellidoPaterno',isAlpha,'El apellido paterno solo puede contener letras minisculas, sin acento');
            check(form,'apellidoMaterno',isAlpha,'El apellido materno solo puede contener letras minisculas, sin acento');
            check(form,'calle',isAlphaNumeric,'La calle solo puede contener letras minisculas, sin acentos o numeros');
            check(form,'colonia',isAlphaNumeric,'La colonia solo puede contener letras minisculas, sin acentos o numeros');
            check(form,'municipio',isAlpha,'El municipio solo puede contener letras minisculas, sin acento');
            check(form,'estado',isAlpha,'El estado solo puede contener letras minisculas, sin acentos');
        }
        else {
            propietierContainer.classList.add('d-none');
            form.querySelector('#nombrePropietario').removeEventListener('input',check);
            form.querySelector('#apellidoPaterno').removeEventListener('input',check);
            form.querySelector('#apellidoMaterno').removeEventListener('input',check);
            form.querySelector('#calle').removeEventListener('input',check);
            form.querySelector('#colonia').removeEventListener('input',check);
            form.querySelector('#municipio').removeEventListener('input',check);
            form.querySelector('#estado').removeEventListener('input',check);
        }
    });

    const status = form.querySelector('#status');

    status.addEventListener('change', (event) => {
        if (event.target.value === 'no_encontrado') {
            ubicacion.selectedIndex=0;
        }
        else if (event.target.value === 'almacenado') {
            ubicacion.selectedIndex=1;
        }
        
        ubicacion.disabled= event.target.value === 'no_encontrado';
    });

    const IdPropietario = form.querySelector('#IdPropietario');
    const nombrePropietario = form.querySelector('#nombrePropietario');
    const apellidoPaterno = form.querySelector('#apellidoPaterno');
    const apellidoMaterno = form.querySelector('#apellidoMaterno');
    let timer = 0

    IdPropietario.addEventListener('input', (event) => {
        clearTimeout(timer);
        timer = setTimeout(async () => {
            let res;
            try{
                res = await fetch(`/propietario/${IdPropietario.value}`)
            }
            catch(error){
            }        

            if(res?.ok){
                const data = await res.json()            
                nombrePropietario.value = data.nombre;
                apellidoPaterno.value = data.apellidoPaterno;
                apellidoMaterno.value = data.apellidoMaterno;
            }
            else{
                nombrePropietario.value = '';
                apellidoPaterno.value = '';
                apellidoMaterno.value = '';
            }
        }, 300);
    });

}

