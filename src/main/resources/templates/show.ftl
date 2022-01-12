<!DOCTYPE html>
<html>
<head>
    <title>Shows</title>
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
            <h2 style="color: whitesmoke" class="text-white">Shows</h2>
        </div>
    </div>
</div>
<hr class="mt-5">

<div class="container" align="left">

    <form action="/">
        <button class="btn btn-sm btn-primary" type="submit">Back</button>
    </form>

    <br/><br/>

    <h5 style="color: whitesmoke">Find Shows By Title</h5>
    <form action="/show/search">
        <input style="width:30%;" type="text" placeholder="{Show Title}" name="title"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Year</h5>
    <form action="/show/search">
        <input style="width:30%;" type="number" min="1900" max="2022" placeholder="{Show Year}" name="year"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Genre</h5>
    <form action="/show/search">
        <input style="width:30%;" type="text" placeholder="{Show Genre}" name="genre"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Rating</h5>
    <form action="/show/search">
        <input style="width:30%;" type="number" min="1" max="10" step="0.1" placeholder="{Show Rating}"
               name="rating"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Number Of Episodes</h5>
    <form action="/show/search">
        <input style="width:30%;" type="number" min="1" max="5000" step="1" placeholder="{Show Episodes}"
               name="numberOfEpisodes"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Number Of Seasons</h5>
    <form action="/show/search">
        <input style="width:30%;" type="number" min="1" max="5000" step="1" placeholder="{Show Seasons}"
               name="numberOfSeasons"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Person Name</h5>
    <form action="/show/search">
        <input style="width:30%;" type="text" placeholder="{Person Name}" name="personName"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Shows By Person Name And Role</h5>
    <form action="/show/search">
        <input style="width:30%;" type="text" placeholder="{Person Name}" name="personName"/>
        <input style="width:30%;" type="text" placeholder="{Person Role}" name="personRole"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Show By Year And Rating</h5>
    <form action="/show/search">
        <input style="width:30%;" type="number" min="1900" max="2022" placeholder="{Show Year}" name="year"/>
        <input style="width:30%;" type="number" min="1" max="10" step="0.1" placeholder="{Show Rating}"
               name="rating"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find All Participation For Individual Person Per Genre</h5>
    <form action="/show/search/individualParticipationPerGenre">
        <input style="width:30%;" type="text" placeholder="{Person Name}" name="name"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/>

    <h5 style="color: whitesmoke">Find Top Rated Movies</h5>
    <form action="/show/search">
        <input style="width:30%;" type="number" min="1" max="50000" placeholder="{Number Of Shows}" name="topRatedShows"/>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <br/><br/>

    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <form action="/show/search/numberofShowsPerGenre">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Find Number Of Shows Per Genre
                    </button>
                </form>
            </div>
            <div class="col-sm-6">
                <form action="/show/search/numberofShowsPerYearPerGenre">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Find Number Of Shows Per Year
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
                <form action="/show/search/export">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Export All Shows To Csv</button>
                </form>
            </div>
        </div>
    </div>

</div>

<br><br><br>

</body>
</html>
