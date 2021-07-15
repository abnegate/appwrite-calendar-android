# Let's build an Android Quiz Application with Appwrite

## 🤔 What is Appwrite?
In case you’re new to Appwrite, Appwrite is an new open-source, end-to-end, backend server for front-end and mobile developers that allows you to build apps much faster. Its goal is to abstract and simplify common development tasks behind REST APIs and tools, helping you to build advanced apps faster.

## 🤖 Appwrite for Android
Appwrite provides **sleek REST APIs** for various common features that are required for mobile application development such as a **database**, **storage**, **cloud functions**, **authentication** etc. so that we as a developer can focus on our application rather than on backend implementation. This makes Appwrite very suitable for those of us who want to build Android applications. And with the latest release, Appwrite now has an **official Android SDK** to make it even easier to use Appwrite in our Android applications. In this tutorial we'll build a simple android quiz application using Appwrite. So let's get started.

## 📝 Prerequisites
In order to continue with this tutorial, you need to have an Appwrite console that you can access and have permission to create a project or already have an existing project. If you have not already installed Appwrite, please do so. Installing Appwrite is really simple following Appwrite's official [installation docs](https://appwrite.io/docs/installation). Installation should be done in less than 2 minutes. Once installed login to your console and **create a new Project**.

##  💾 Setup Database
In the Appwrite console, let's select the project that we will be using for our Android app. If you don't have a project yet, you can easily create one by clicking on the Create Project button. Once inside, select Database from the left sidebar. Once on the database page click on the Add Collection button and inside the dialog set the collection name to Questions and then click the Create button. This will then create a collection and you will be redirected to the new collection's page where we can define rules for our collection. Define the following rules and click on the Update button.

- **Name**
    - label: Name
    - Key: name
    - Rule Type: Text
    - Required: true
    - Array: false
- **Date**
    - label: Date
    - Key: date
    - Rule Type: Numeric
    - Required: true
    - Array: false
- **Description**
    - label: Description
    - Key: description
    - Rule Type: Text
    - Required: false
    - Array: false
- **Start Time**
    - label: Start Time
    - Key: start_time
    - Rule Type: Numeric
    - Required: false
    - Array: false
- **End Time**
    - label: End Time
    - Key: end_time
    - Rule Type: Numeric
    - Required: false
    - Array: false
- **Notify**
    - label: Notify
    - Key: notify
    - Rule Type: Boolean
    - Required: false
    - Array: false

Now you can navigate to the **Documents** tab and using the **Add Document** button, you can manually add an event. Later we'll use the Android SDK to add new events from our app!

## ⚙️ Setup Android Project and Dependencies

Using Android Studio, create a new Android Application project choosing the **Empty Activity** template. Once the project is created, in your app's root level `build.gradle(.kts)` file,  add the `mavenCentral()` repository in order to fetch the Appwrite Android SDK.

```groovy
repositories {
    mavenCentral()
}
```

Next, add the dependency to your app's `build.gradle(.kts)` file:

```groovy
implementation("io.appwrite:sdk-for-android:0.0.1")
```

## ➕️ Add Android Platform
To initialize your SDK and start interacting with Appwrite services, you need to add a new Android platform to your project. To add a new platform, go to your Appwrite console, select your project (create one if you haven't already), and click the 'Add Platform' button on the project Dashboard.

From the options, choose to add a new Android platform and add your app credentials.

Add your app name and package name. Your package name is generally the `applicationId` in your app-level `build.gradle` file. You may also find your package name in your `AndroidManifest.xml` file. By registering a new platform, you are allowing your app to communicate with the Appwrite API.



## 🥂 Conclusion

I hope you enjoyed building this Quiz Application with Appwrite and Android. Let's us know if you have any feedback and suggestions. Can't wait for the community to build awesome apps with Appwrite and Android.

## 🎓 Learn More
- [Getting Started With Android](https://appwrite.io/getting-started-with-android)
- [Android Playground](https://github.com/appwrite/playground-for-android)
- [Demo Quiz Application](https://github.com/appwrite/demo-quiz-with-android)
- [Appwrite Docs](https://appwrite.io/docs)