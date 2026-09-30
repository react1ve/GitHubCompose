# GitHubCompose

**Android Showcase App built with Jetpack Compose with MVI architecture with Clean code, TDD & Best
Practices.**

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blue?logo=kotlin)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-BOM%202025.02.00-brightgreen?logo=jetpackcompose)
![Architecture](https://img.shields.io/badge/Architecture-MVI%20%2B%20Clean%20Code-orange)
![Maintainer](https://img.shields.io/badge/Maintainer-react1ve-purple?logo=github)

---

## Overview

**GitHubCompose** (`com.reactive.githubcompose`) is a high-performance, modern Android showcase
application designed and maintained by [**react1ve**](https://github.com/react1ve). It demonstrates
production-ready Android development standards, robust architecture, modern tooling, and seamless
UI/UX using Jetpack Compose.

---

## Tech Stack & Modern Tooling

* **UI & Design System**:
  * [Jetpack Compose](https://developer.android.com/jetpack/compose) (Declarative UI)
  * Material Design (Light & Dark theme support)
  * Adaptive **Edge-to-Edge** support across all Android versions with correct System Bar & IME
    insets.
* **Architecture & Concurrency**:
  * **MVI (Model-View-Intent)** Architectural Pattern
  * Kotlin Coroutines & Flow for asynchronous data streams and state management.
  * Single-Activity Architecture powered by Jetpack Navigation.
* **Dependency Injection & Networking**:
  * [Koin](https://insert-koin.io/) for lightweight, pragmatic dependency injection.
  * [Retrofit](https://square.github.io/retrofit/) & Gson for robust networking against the GitHub
    API.
  * [Coil](https://github.com/coil-kt/coil) for reactive image loading (`AsyncImage`).
* **Build & Performance**:
  * Gradle Version Catalogs (`gradle/libs.versions.toml`)
  * Parallel builds, build caching, and configuration caching enabled for maximum build performance.
  * Java 17 toolchain & JVM targets.

---

## Architecture (MVI)

The project enforces a strict separation of concerns utilizing the **Model-View-Intent (MVI)**
pattern:

* **View**: Composable screens observing reactive UI states (`State`), rendering UI components, and
  dispatching user interactions (`Event`).
* **ViewModel**: Manages business logic and state reduction, converting UI events into state updates
  and triggering one-time side effects (`Effect`).
* **Model**: Repository and data sources responsible for fetching and caching remote/local data
  cleanly.

### Core MVI Components:

1. **State**: Immutable data class representing the UI state at any given moment.
2. **Event**: User actions sent from the UI to the ViewModel.
3. **Effect**: One-time side effects (e.g., navigation, Snackbars) delivered via Coroutine Channels.

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/react1ve/GitHubCompose.git
   ```
2. Open the project in **Android Studio** (Koala / Ladybug or newer).
3. Sync Gradle and run the app on an emulator or physical device.

---
