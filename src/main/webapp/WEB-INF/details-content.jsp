<img src="${vehicle.imgUrl}" class="card-img-top" alt="...">

<div class="card-body">

<h5 class="card-title text-center"> ${vehicle.name} </h5>

<p>${vehicle.description}</p>

<p>${vehicle.price}</p>

<h6 class="card-subtitle"> ${vehicle.category.getName()}</h6>

<c:if test="${!empty isLogged}">
  <a class="btn btn-primary" role="button" href="/edit-vehicle?id=${vehicle.id}">Edit</a>
</c:if>