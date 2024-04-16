

// const toastTrigger = document.getElementById('liveToastBtn')
const toastTemplate = document.getElementById('toast')
// const toastLiveExample = document.getElementById('liveToast')
const toastContainer = document.getElementById('toast-container')

export function succesToast(message) {
    const node = toastTemplate.content.cloneNode(true);
    const toastLiveExample = node.getElementById('liveToast')
    const toast = new bootstrap.Toast(toastLiveExample)
    toastLiveExample.classList.remove('bg-danger')
    toastLiveExample.classList.add('bg-success')
    toastLiveExample.querySelector('.toast-header').innerText = 'Exito'
    toastLiveExample.querySelector('.toast-body').innerText = message
    toastContainer.appendChild(node)
    toast.show()
}

export function errorToast(message) {
    const node = toastTemplate.content.cloneNode(true);
    const toastLiveExample = node.getElementById('liveToast')
    const toast = new bootstrap.Toast(toastLiveExample)
    toastLiveExample.classList.remove('bg-success')
    toastLiveExample.classList.add('bg-danger')
    toastLiveExample.querySelector('.toast-header').innerText = 'Error'
    toastLiveExample.querySelector('.toast-body').innerText = message
    toastContainer.appendChild(node)
    toast.show()
}