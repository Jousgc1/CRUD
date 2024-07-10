const contenedor =document.querySelector('tbody');
let resultados =''

const modalArticulo = new bootstrap.Modal(document.getElementById('modalArticulo'))
const formArticulo =document.querySelector('form')
const dni = document.getElementById('dni')
const primerNombre=document.getElementById('PrimerNombre')
const segundoNombre =document.getElementById('SegundoNombre')
const apellidoPaterno =document.getElementById('ApellidoPaterno')
const apellidoMaterno =document.getElementById('ApellidoMaterno')
const dirección =document.getElementById('Dirección')
const curso =document.getElementById('Curso')
const fechadeNacimiento =document.getElementById('FechadeNacimiento')

let opcion = ''

btnCrear.addEventListener('click',()=>{
    estudianteDni.value=''
    primerNombre.value=''
    segundoNombre.value=''
    apellidoPaterno.value=''
    apellidoMaterno.value=''
    fechadeNacimiento.value=''
    dirección.value=''
    curso.value=''

    modalArticulo.show()
    opcion = 'crear'
});