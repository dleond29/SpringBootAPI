window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/turnos/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(turno of data){

     console.log(turno.odontologo.id)

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                  ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                  ' type="button" onclick="findBy('+turno.id+')" class="btn btn-info btn_id">' +
                                  turno.id +
                                  '</button>';

      let tr_id = 'tr_' + turno.id;
      let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_fecha\">' + turno.fecha.toUpperCase() + '</td>' +
                '<td class=\"td_odontologoId\">' + turno.odontologo.id + '</td>' +
                '<td class=\"td_pacienteId\">' + turno.paciente.id + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#turnoTable tbody').append(turnoRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/html/turnos/turnos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})