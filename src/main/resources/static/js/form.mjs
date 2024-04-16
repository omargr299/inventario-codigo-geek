

export async function bindForm(query){
    const dialog = document.querySelector(query);
    const res = await fetch(window.location.pathname + 'form')
    const formText = await res.text()
    dialog.innerHTML += formText
    const form = document.querySelector(query+' form');

    const ubicacion = form.querySelector('#ubicacion');
    const propietierContainer = form.querySelector('#propietier-container');

    ubicacion.addEventListener('change', (event) => {
        if (event.target.value === '3') {
            propietierContainer.classList.remove('d-none');
        }
        else {
            propietierContainer.classList.add('d-none');
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

