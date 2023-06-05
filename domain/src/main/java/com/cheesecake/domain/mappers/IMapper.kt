package com.cheesecake.domain.mappers

interface IMapper<I,O> {
    fun map(input: I):O
}