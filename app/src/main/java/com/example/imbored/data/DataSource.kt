package com.example.imbored.data

import com.example.imbored.R
import com.example.imbored.model.Activity
import com.example.imbored.model.Category

object DataSource {

    val loremIpsum: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

    val categories = listOf(
        Category(
            name = "Go Outside",
            imageID = R.drawable.outdoors
        ),
        Category(
            name = "Play a Game",
            imageID = R.drawable.game
        ),
        Category(
            name = "Read a Book",
            imageID = R.drawable.book
        ),
        Category(
            name = "Practice an Instrument",
            imageID = R.drawable.clarinet
        ),
        Category(
            name = "Play with Toys",
            imageID = R.drawable.legos
        )
    )
    val activities = listOf(
        Activity(
            category = categories[0],
            name = "Ride a Bike",
            imageID = R.drawable.bicycle,
            description = loremIpsum
        ),
        Activity(
            category = categories[0],
            name = "Play at a Playground",
            imageID = R.drawable.playground,
            description = loremIpsum
        ),
        Activity(
            category = categories[1],
            name = "Play Chess",
            imageID = R.drawable.chess,
            description = loremIpsum
        ),
        Activity(
            category = categories[1],
            name = "Play Checkers",
            imageID = R.drawable.checkers,
            description = loremIpsum
        ),
        Activity(
            category = categories[3],
            name = "Practice the Clarinet",
            imageID = R.drawable.clarinet,
            description = loremIpsum
        ),
        Activity(
            category = categories[2],
            name = "Read a Book",
            imageID = R.drawable.book,
            description = loremIpsum
        ),
        Activity(
            category = categories[3],
            name = "Practice the Drums",
            imageID = R.drawable.drums,
            description = loremIpsum
        ),
        Activity(
            category = categories[4],
            name = "Play with Legos",
            imageID = R.drawable.legos,
            description = loremIpsum
        ),
    )
}