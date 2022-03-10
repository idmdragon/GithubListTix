package com.idmdragon.githublist.data.response

data class PagingDataResponse<DataType>(
    val incomplete_results: Boolean,
    val page: Int,
    val per_page: Int,
    val items: List<DataType>
)