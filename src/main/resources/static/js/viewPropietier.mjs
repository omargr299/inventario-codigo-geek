

const dialogProp = document.querySelector('#propietier');
const content = dialogProp.querySelector('#propietierContent');
const closeButton = dialogProp.querySelector('#close');

export async function openPropietierDialog(id) {
        const newContent = await fetch('/propietario/' + id)
        // const newContentHTML = await newContent.text()z
        const contentJSON = await newContent.json()
        console.log(contentJSON)
        content.innerHTML = `
            <h3>Propietario</h3>
            <div><span class="propietario"><b>Nombre:</b> ${contentJSON.nombre}</span></div>
            <div><span class="propietario"><b>Apellido paterno:</b> ${contentJSON.apellidoPaterno}</span></div>
            <div><span class="propietario"><b>Apellido materno:</b> ${contentJSON.apellidoMaterno}</span></div>
        `;

        closeButton.addEventListener('click', () => {
            content.innerHTML = '';
            dialogProp.close();
        });
        dialogProp.showModal();
    };

