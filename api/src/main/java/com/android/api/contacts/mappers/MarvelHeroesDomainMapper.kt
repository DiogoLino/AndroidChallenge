package com.android.api.contacts.mappers

import com.android.api.contacts.model.ApiHeroes
import com.android.repository.contacts.models.Heroes

fun ApiHeroes.toDomain(): Heroes =
    Heroes(
        id = id,
        name = name,
        description = description
    )