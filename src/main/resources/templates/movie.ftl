<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://maxcdn.bootstrapcdn.com/bootswatch/3.3.5/paper/bootstrap.min.css' rel='stylesheet'>

    <style type="text/css">
        <#include "style.css">
    </style>
</head>
<body>

    <div class=" container h-100">
        <div class="d-flex text-center h-100">
            <div class="my-auto w-100 text-white">
                <h2 style="color: whitesmoke" class="text-white">Movies</h2>
            </div>
        </div>
    </div>
    <hr class="mt-5">

    <div class="container" align="left">

        <form action="/">
            <button class="btn btn-sm btn-primary" type="submit">Back</button>
        </form>

        <br/><br/>

        <h5 style="color: whitesmoke">Find Movies By Title</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="text" placeholder="{Movie Title}" name="title"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Movies By Year</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="number" min="1900" max="2022" placeholder="{Movie Year}" name="year"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Movies By Genre</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="text" placeholder="{Movie Genre}" name="genre"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Movies By Rating</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="number" min="1" max="10" step="0.1" placeholder="{Movie Rating}"
                   name="rating"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Movies By Person Name</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="text" placeholder="{Person Name}" name="personName"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Movies By Person Name And Role</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="text" placeholder="{Person Name}" name="personName"/>
            <input style="width:30%;" type="text" placeholder="{Person Role}" name="personRole"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Movies By Year And Rating</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="number" min="1900" max="2022" placeholder="{Movie Year}" name="year"/>
            <input style="width:30%;" type="number" min="1" max="10" step="0.1" placeholder="{Movie Rating}"
                   name="rating"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find All Participation For Individual Person Per Genre</h5>
        <form action="/movie/search/individualParticipationPerGenre">
            <input style="width:30%;" type="text" placeholder="{Person Name}" name="name"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/>

        <h5 style="color: whitesmoke">Find Top Rated Movies</h5>
        <form action="/movie/search">
            <input style="width:30%;" type="number" min="1" max="50000" placeholder="{Number Of Movies}" name="topRatedMovies"/>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <br/><br/>

        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <form action="/movie/search/numberofMoviesPerGenre">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Find Number Of Movies Per Genre
                        </button>
                    </form>
                </div>
                <div class="col-sm-6">
                    <form action="/movie/search/numberofMoviesPerYearPerGenre">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Find Number Of Movies Per Year
                            and
                            Per Genre
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <form action="/movie/search/export">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Export All Movies To Csv</button>
                    </form>
                </div>
            </div>
        </div>

    </div>

    <br><br><br>

</body>
</html>
