package com.android.api.contacts.mappers

import com.android.api.contacts.model.ApiHeroThumbnail
import com.android.api.contacts.model.ApiHeroes
import com.android.repository.contacts.models.Hero
import com.android.repository.contacts.models.HeroThumbnail

fun ApiHeroes.toDomain(offset: Int): Hero =
    Hero(
        id = id,
        name = name,
        description = description,
        offset = offset,
        thumbnailPath = apiHeroThumbnail.toDomain()
    )


fun ApiHeroThumbnail.toDomain(): HeroThumbnail = HeroThumbnail(
    path = path,
    extension = extension
)


