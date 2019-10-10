package com.gustavo.githubrepositories.common.mock

import com.gustavo.githubrepositories.entity.Owner
import com.gustavo.githubrepositories.entity.Repository

object MockData {

    fun mockRepositoryList(): List<Repository>? {
        val list = mutableListOf<Repository>()
        for (i in 1..10) list += mockRepository(i)
        return list
    }

    fun mockRepository(number: Int): Repository {
        return Repository(
            "desc$number",
            "user$number",
            Owner(
                "login$number",
                number,
                "https://avatars2.githubusercontent.com/u/32128408?v=4",
                ""
            ),
            number % 3 != 0
        )
    }

}