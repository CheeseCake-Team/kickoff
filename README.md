# Kick Off

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Kick Off is an Android app that provides live scores, news, and player statistics for football enthusiasts.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Architecture](#architecture)
- [Contributing](#contributing)
- [Credits](#credits)
- [License](#license)


## Introduction

Kick Off is a feature-rich Android application designed to keep football fans up-to-date with live scores, news, and player statistics from various leagues around the world. This app aims to provide an immersive football experience, allowing users to stay connected with their favorite teams and players on the go.

## Features

- Live Scores: Get real-time updates on ongoing matches, including live scores, goals, and match events.
- News Feed: Stay up-to-date with the latest football news, transfer rumors, and match reports.
- Player Statistics: Access comprehensive player profiles with detailed statistics, including goals, assists, and disciplinary records.
- League Standings: View the standings and rankings of different football leagues, including points, goals scored, and goal difference.
- Team Information: Explore detailed information about teams, including squad lists, formations, and previous match results.
- Match Highlights: Watch video highlights of key moments and goals from past matches.

## Architecture

Kick Off follows a clean architecture approach to ensure separation of concerns and maintainability. The app is divided into the following layers:

![App Architecture]([https://github.com/CheeseCake-Team/kickoff/tree/development/app/src/main/assets/app_architecture.png](https://drive.google.com/file/d/1xvWoCDAYKjXtvCIHYmd5j31Wa0dq-1hB/view?usp=sharing))

- **Presentation Layer**: Responsible for handling UI-related tasks, including activities, fragments, and view models.
- **Domain Layer**: Contains the business logic of the application, including use cases and repositories.
- **Data Layer**: Deals with data management, including remote APIs, local databases, and data models.

The app uses the following architectural components and libraries:

- **MVVM**: The presentation layer follows the Model-View-ViewModel architectural pattern for better separation of concerns and testability.
- **Retrofit**: A type-safe HTTP client for making network requests and retrieving data from remote APIs.
- **Room**: An SQLite object-mapping library for local data storage and caching.
- **Coroutines**: A Kotlin library for asynchronous programming and simplifying concurrency.
- **Dependency Injection**: The app uses Dagger or Hilt for dependency injection to achieve better modularity and testability.

## Contributing

We welcome contributions from the community to enhance Kick Off. Bug reports, feature requests, and pull requests are all appreciated.

## Credits

Kick Off would like to give credit and thanks to the following resources:

- [Uncle Bareq](https://github.com/Bareq-altaamah) for guiding us all over the journey.
- [Football Data API](https://www.api-football.com) for providing the live scores, player statistics, and league standings data.
- [Iconsax](https://iconsax.io/) for the icons used in the app.

We appreciate the contributions of these resources, which have greatly enhanced the functionality and visual appeal of Kick Off.

If you have any questions or suggestions, please feel free to reach out to us.

## License

Kick Off is open source and released under the [MIT License](LICENSE).
``
