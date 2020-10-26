package com.android.api.contacts.mappers

import com.android.api.contacts.model.ApiHeroes
import com.android.repository.contacts.models.Hero

fun ApiHeroes.toDomain(): Hero =
    Hero(
        id = id,
        name = name,
        description = description
    )