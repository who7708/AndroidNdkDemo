# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

# 指定cmake版本
#cmake_minimum_required(VERSION 3.10.2)
cmake_minimum_required(VERSION 3.4.1)

#set(key helloworld)
#message(${key})
#
#message(${CMAKE_CURRENT_LIST_FILE})
#message(${CMAKE_CURRENT_LIST_DIR})
#
#if (TRUE)
#    message("this is true")
#endif ()


# Declares and names the project.

project("android-ndk-demo")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        invoke-lib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        jni/jni_invoke.cpp
        people/People.cpp
        )

add_library(
        dynamic-lib
        SHARED
        jni/jni_dynamic_load.cpp
)

add_library(
        basic-type-lib
        SHARED
        jni/jni_basic_type.cpp
)

add_library(
        string-lib
        SHARED
        jni/jni_string.cpp
)

add_library(
        reference-lib
        SHARED
        jni/jni_reference_type.cpp
)

add_library(
        access-field-lib
        SHARED
        jni/jni_access_field.cpp
)

add_library(
        access-method-lib
        SHARED
        jni/jni_access_method.cpp
)

add_library(
        callback-lib
        SHARED
        base/jvm.cpp
        jni/jni_invoke_method.cpp
)

# 定义搜索路径
include_directories(${CMAKE_SOURCE_DIR}/base/)
include_directories(${CMAKE_SOURCE_DIR}/people/)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        invoke-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        dynamic-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        basic-type-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        string-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        reference-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        access-field-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        access-method-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        callback-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})