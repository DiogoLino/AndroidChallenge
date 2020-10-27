# AndroidChallenge

This is Modularized Project with MvP pattern , to load Characters From https://developer.marvel.com/ and display in a alphabetic order.
This Api requires key authentication md5.

implemented pagination per offset.

Modules: Api -> where the service configuration and the api models live
         Repository -> where we decide to call api/db
         Domain -> where usecases live to call repository
         Presentaion -> where presenters and observers live
         Imageloader-> contain glide module. provide the loading of images
         base-di-> where dagger configurations live
         database-> database configuration , daos and entity models
         app-> where views live (this could be extracted to a feature module if the projects grows)
         

libs used in -> dependencies.gradle
            

