import { errorToast, succesToast } from "./toast.mjs"

function formatActivo(formData,ubicacion) {
    return {
        nombre: formData.get('nombre'),
        total: Number(formData.get('total')),
        detalle: formData.get('detalle')!=="" ? formData.get('detalle') : null,
        descripcion: formData.get('descripcion') ?? null,
        fechaAdqui: formData.get('fechaAdqui'),
        ubicacion: ubicacion ?? formData.get('ubicacion'),
        status: formData.get('status'),
    }
}

function formatPropietario(formData) {
    return {
        idPropietario: Number(formData.get('IdPropietario')),
        nombre: formData.get('nombrePropietario'),
        apellidoPaterno: formData.get('apellidoPaterno'),
        apellidoMaterno: formData.get('apellidoMaterno'),
    }
}

function formatUbicacion(formData) {
    return {
        calle: formData.get('calle'),
        numero: Number(formData.get('numero')),
        colonia: formData.get('colonia'),
        municipio: formData.get('municipio'),
        estado: formData.get('estado'),
        cp: Number(formData.get('cp')),
    }
}

function formatAsociacion(formData) {
    return {
        idActivo: Number(formData.get('IdActivo')),
        idPropietario: Number(formData.get('IdPropietario')),
    }
}

export async function getActivo(id) {
    const res = await fetch(window.location.pathname + 'activo/' + id)
    return await res.json()
}

export async function getPropietario(id) {
    const res = await fetch(window.location.pathname + 'propietario/' + id)
    return await res.json()
}

export async function getPropAssociation(id) {
    const res = await fetch(window.location.pathname + 'asociacion/' + id + '/propietario')
    return await res.json()
}

export async function createActivo(formData) {
    const activo = formatActivo(formData);

    console.log(activo);
    const res = await fetch(window.location.pathname + 'activo', {
        method: 'POST',
        body: JSON.stringify(activo),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        
    if (res.ok) {
        succesToast("Activo agregado correctamente");
    } else {
        const data = await res.json()
        const [message,field] = data.message.split(':');
        if(field === "id") {
            document.querySelector('#error-id').classList.remove('d-none');
        }
        else if(field === "nombre") {
            document.querySelector('#error-nombre').classList.remove('d-none');
        }
        
        if(data?.error==="Conflict"){
			console.log(data?.errors);
			data?.errors?.forEach((error)=>{
				errorToast(error?.defaultMessage);
			})
			
		}
		else{			
        	errorToast(message);
		}
    }

    return res;
}

export async function createPropietario(formData) {
    const propietario  = formatPropietario(formData);

   const res = await fetch(window.location.pathname + 'propietario', {
        method: 'POST',
        body: JSON.stringify(propietario),
        headers: {
            'Content-Type': 'application/json'
        }
    })

     if (res.ok) {
        succesToast("Propietario agregado correctamente");
    } else {
        const data = await res.json()
		const [message,field] = data.message.split(':');
         if(data?.error==="Conflict"){
			console.log(data?.errors);
			data?.errors?.forEach((error)=>{
				errorToast(error?.defaultMessage);
			})
			
		}
		else{			
        	errorToast(message);
		}
    }

    return res;
 
}

export async function createUbicacion(formData) {
    const ubicacion = formatUbicacion(formData);
    console.log(ubicacion);
    const res = await fetch(window.location.pathname + 'ubicacion', {
        method: 'POST',
        body: JSON.stringify(ubicacion),
        headers: {
            'Content-Type': 'application/json'
        }
    })

    if (!res.ok) {
        const data = await res.json()
		const [message,field] = data.message.split(':');
		console.log(data?.errors)
         if(data?.error==="Conflict"){
			console.log(data?.errors);
			data?.errors?.forEach((error)=>{
				errorToast(error?.defaultMessage);
			})
			
		}
		else{			
        	errorToast(message);
		}
    }           
    return res;
}

export async function createAsociacion(activo,propietario) {


    const res = await fetch(window.location.pathname + 'asociacion', {
        method: 'POST',
        body: JSON.stringify({
			idActivo: activo.idActivo,
			idPropieatrio: propietario.idPropietario
		}),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    if (!res.ok) {
        const data = await res.json()
        errorToast(data.message);
    }           
   

}

export async function editActivo(id,formData) {
    const activo = formatActivo(formData);

    const res = await fetch(window.location.pathname + `activo/${id}`, {
        method: 'PUT',
        body: JSON.stringify(activo),
        headers: {
            'Content-Type': 'application/json'
        }
    })

    if (res.ok) {
        succesToast("Activo editado correctamente");
    } else {
        const data = await res.json()
        errorToast(data.message);
    }

    return res;
}

export async function editPropietario(id,formData) {
    const propietario  = formatPropietario(formData);

   const res = await fetch(window.location.pathname + `propietario/${id}`, {
        method: 'PUT',
        body: JSON.stringify(propietario),
        headers: {
            'Content-Type': 'application/json'
        }
    })

     if (res.ok) {
        succesToast("Propietario editado correctamente");
    } else {
        const data = await res.json()
        errorToast(data.message);
    }

    return res;
}

export async function deleteActivo(id,activo) {
    const response = await fetch(window.location.pathname + 'activo/' + id, {
        method: 'DELETE'
    });
    if (response.ok) {
        succesToast("Activo eliminado correctamente");
        activo.remove();
    }
    else {
        const data = await response.json()
        errorToast(data.message);
    }
}
