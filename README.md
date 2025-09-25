# Listify

## Description
Listify is a simple and intuitive shopping list application for Android. It helps you keep track of the items you need to buy, with the added functionality of saving a location for each item. The app is built with a modern tech stack, featuring a reactive UI with Jetpack Compose and location services using the Google Maps API.

---

## Key Features
* **Create and Manage Shopping Lists:** Easily add, edit, and delete items from your shopping list.
* **Location-Based Items:** Associate a location with each shopping item, helping you remember where to buy it.
* **Interactive Map:** Select and save locations for your shopping items using an interactive Google Map.
* **Clean and Simple UI:** A user-friendly interface built with Jetpack Compose and Material Design 3.

---

## Technologies Used
* **Kotlin:** The primary programming language for building the application.
* **Jetpack Compose:** For building the entire user interface of the app.
* **Google Maps API:** To display maps and allow users to select a location.
* **Retrofit:** For making API calls to the Google Maps Geocoding API to get address details.
* **ViewModel:** To manage and store UI-related data in a lifecycle-conscious way.
* **Material Design 3:** The app follows the latest Material Design guidelines for a modern and intuitive user experience.

---

## Setup Instructions
To set up and run this project locally, you will need to do the following:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/adityabharde/listify.git](https://github.com/adityabharde/listify.git)
    ```
2.  **Open in Android Studio:** Open the cloned project in Android Studio.
3.  **Get a Google Maps API Key:**
    * Go to the [Google Cloud Console](https://console.cloud.google.com/).
    * Create a new project or select an existing one.
    * Enable the "Maps SDK for Android" and "Geocoding API".
    * Create an API key.
4.  **Add the API Key to the project:**
    * In the `app/src/main/AndroidManifest.xml` file, replace `"API_Key"` with your actual Google Maps API key.
    * In the `app/src/main/java/com/example/shoppinglistapp/LocationViewModel.kt` file, replace the placeholder API key in the `fetchAddress` function with your API key.
5.  **Build and run the app:** Build and run the application on an Android emulator or a physical device. Make sure the device has Google Play Services installed.
