@echo off
echo Building AutoSword Mod for NeoForge 1.21.8...
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 21 from: https://adoptium.net/
    pause
    exit /b 1
)

echo Java found! Building mod...
echo.

REM Build the mod
call gradlew.bat build

if %errorlevel% equ 0 (
    echo.
    echo SUCCESS! Mod built successfully!
    echo.
    echo The JAR file is located at: build\libs\autosword-1.0.0.jar
    echo.
    echo To install:
    echo 1. Copy the JAR file to your .minecraft\mods\ folder
    echo 2. Make sure you have NeoForge 1.21.8 installed
    echo 3. Launch Minecraft with NeoForge profile
    echo 4. Press F6 to toggle auto-attack
    echo.
    pause
) else (
    echo.
    echo ERROR: Build failed!
    echo Check the error messages above.
    pause
)
