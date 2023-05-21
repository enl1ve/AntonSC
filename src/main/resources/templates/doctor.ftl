<#import "templ/templ.ftl" as c>
<@c.pages>
    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if allDoctorsByCategory??>
            <#list allDoctorsByCategory as payment>
                <div class="col">
                    <div class="card">

                        <form action="/cart" method="post">

                            <input type="hidden" name="id" id="id_" value="${payment.id}">
                            <img src="${payment.image}" class="card-img-top" alt="${payment.name}">
                            <div class="card-body">
                                <h5 class="card-title">Ім'я: ${payment.name}</h5>
                                <p class="card-text">Price: ${payment.price}</p>
                                <p class="card-text">Спеціальніть: ${payment.description}</p>


                                <a href="/category" class="card-link" class="btn btn-success">to category</a>
                            </div>
                        </form>
                    </div>
                </div>
            </#list>
        </#if>

    </div>

</@c.pages>