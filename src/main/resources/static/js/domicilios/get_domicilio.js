window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/domicilios/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(domicilio of data){

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + domicilio.id + '\"' +
                                  ' type="button" onclick="deleteBy('+domicilio.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + domicilio.id + '\"' +
                                  ' type="button" onclick="findBy('+domicilio.id+')" class="btn btn-info btn_id">' +
                                  domicilio.id +
                                  '</button>';

      let tr_id = 'tr_' + domicilio.id;
      let domicilioRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_nombre\">' + domicilio.calle.toUpperCase() + '</td>' +
                '<td class=\"td_apellido\">' + domicilio.numero.toUpperCase() + '</td>' +
                '<td class=\"td_matricula\">' + domicilio.localidad.toUpperCase() + '</td>' +
                '<td class=\"td_matricula\">' + domicilio.provincia.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#domicilioTable tbody').append(domicilioRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/html/domicilios/domicilios.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})