window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_domicilio_form');
    formulario.addEventListener('submit', function (event) {
        let domicilioId = document.querySelector('#domicilio_id').value;
        const formData = {
            id: document.querySelector('#domicilio_id').value,
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,

        };
        const url = '/domicilios';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/domicilios'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let domicilio = data;
              document.querySelector('#domicilio_id').value = domicilio.id;
              document.querySelector('#calle').value = domicilio.calle;
              document.querySelector('#numero').value = domicilio.numero;
              document.querySelector('#localidad').value = domicilio.localidad;
              document.querySelector('#provincia').value = domicilio.provincia;

              document.querySelector('#div_domicilio_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }