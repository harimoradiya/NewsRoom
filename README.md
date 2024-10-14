# 📱 NewsRoom - A Modern Android News App for Beginners

Welcome to **NewsRoom** – an Android application that fetches the latest news from [NewsAPI](https://newsapi.org/) while showcasing best practices like **MVVM architecture**, **Koin dependency injection**, and **Coil image loading**.

This project is designed for Android beginners looking to learn and implement industry-standard patterns and technologies to build modern Android apps. 

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/fir-demo-9e712.appspot.com/o/Screenshot_20241014_183546.png?alt=media&token=3d86e23b-eb0b-44c8-bd5d-9c405cdae64d" alt="NewsRoom">
</p>

---

## 🎥 App Demo

Watch the NewsRoom app in action! Click the video below:

[![NewsRoom App Demo]
<p align="center">
<video src="https://firebasestorage.googleapis.com/v0/b/fir-demo-9e712.appspot.com/o/Screen_recording_20241014_183649.webm?alt=media&token=6a957dd3-366f-43df-8365-7b06ca86ce35" width="320" height="240" controls></video>
</p>

---

## ✨ Features

- Fetch Latest News : Get up-to-date news articles using [NewsAPI](https://newsapi.org/).
- Search Functionality : Search for news based on user input.
- MVVM Architecture : Clean separation of concerns using ViewModel, Repository, and LiveData.
- Koin Dependency Injection : Implement DI for effortless management of dependencies.
- Coil Image Loading : Efficient image loading for news articles with support for caching.
- Network Handling : Material Alert Dialog for no internet connection.
- Shimmer Effect : Show cool shimmer loading effect while fetching data.

---

## 📚 Learning Objectives

- Learn how to implement - MVVM (Model-View-ViewModel)  pattern in Android.
- Understand Koin for managing dependencies.
- Utilize Coil for seamless image loading.
- Manage network calls and handle search queries dynamically.
- Use LiveData, ViewModel, and Repository layers for a clean architecture.
  
---

## 🛠 Tech Stack

- Programming Language : Kotlin
- Architecture : MVVM
- Dependency Injection : Koin
- Networking : Retrofit
- Image Loading : Coil
- UI Components : Material Design, RecyclerView, Shimmer Effect
- API : [NewsAPI](https://newsapi.org/)

---

## 🚀 How to Get Started

1. Clone the repository:
   ```bash
   git clone https://github.com/harimoradiya/NewsRoom.git


2. Get your free API key from NewsAPI and add it to your gradle.properties file::
   ```bash
   NEWS_API_KEY="your_api_key_here"


🔧 Project Structure
bash
NewsRoom/
├── data/
│   ├── api/
│   │   └── NewsApiService.kt      # Retrofit interface for News API
│   ├── model/
│   │   └── NewsArticle.kt         # Data class representing a news article
│   └── repository/
│       └── NewsRepository.kt      # Repository for fetching news data
├── di/
│   └── AppModule.kt               # Koin module for dependency injection
├── ui/
│   ├── main/
│   │   └── MainActivity.kt        # Main Activity with toolbar and search view
│   ├── home/
│   │   └── HomeFragment.kt        # Fragment to display news articles
│   └── viewmodel/
│       └── NewsViewModel.kt       # ViewModel for handling business logic
├── utils/
│   └── NetworkUtils.kt            # Utility class for network-related functions
└── ... App.kt                     # Application class


🌟 Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request.


🙌 Acknowledgments
Thanks to NewsAPI for the awesome API service.
Special shoutout to all Android developers who inspire learning and sharing knowledge.

Happy Coding! 🚀


