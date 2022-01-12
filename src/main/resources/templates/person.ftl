<#--noinspection ALL-->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>People</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://maxcdn.bootstrapcdn.com/bootswatch/3.3.5/paper/bootstrap.min.css' rel='stylesheet'>

    <style>
        <#include "style.css">
    </style>
</head>
<body>

<div class=" container h-100">
    <div class="d-flex text-center h-100">
        <div class="my-auto w-100 text-white">
            <h2 style="color: whitesmoke" class="text-white">People</h2>
        </div>
    </div>
</div>
<hr class="mt-5">

<div class="container">

    <form action="/">
        <button class="btn btn-sm btn-primary" type="submit">Back</button>
    </form>

    <br/><br/>

    <h5 style="color: whitesmoke">Find People By Name</h5>
    <form action="/person/search">
        <input style="width:30%;" type="text" placeholder="{Name}" name="name"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find People By Born</h5>
    <form action="/person/search">
        <input style="width:30%;" type="number" min="1500" max="2022" placeholder="{Person Born}" name="born"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find All Participations By Person Name</h5>
    <form action="/person/search/participation">
        <input style="width:30%;" type="text" placeholder="{Name}" name="name"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find All Participations By Person Name And Role</h5>
    <form action="/person/search/participationByRole">
        <input style="width:30%;" type="text" placeholder="{Name}" name="name"/>
        <input style="width:30%;" type="text" placeholder="{Role}" name="role"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>


    <h5 style="color: whitesmoke">Find All Participation For Individual Person Per Genre</h5>
    <form action="/person/search/individualParticipationPerGenre">
        <input style="width:30%;" type="text" placeholder="{Name}" name="name"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/><br/>

    <form action="/person/search/export">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Export All People To Csv</button>
    </form>

    <br/><br/>
</div>


</body>
</html>
