package com.cheesecake.data.mappers

interface IMapper<I,O> {
    fun map(input: I):O
}