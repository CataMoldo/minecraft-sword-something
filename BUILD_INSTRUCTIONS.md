# AutoSword Mod - Build Instructions

## Quick Setup for NeoForge 1.21.8

Since your system doesn't have Java set up for building, here are the easiest ways to get the mod working:

### Option 1: Use a Pre-built JAR (Recommended)
1. Download a pre-built version from a mod repository
2. Or ask someone with Java installed to build it for you

### Option 2: Set up Java and Build Yourself
1. **Install Java 21:**
   - Download OpenJDK 21 from: https://adoptium.net/
   - Install it and add it to your PATH
   - Verify with: `java -version`

2. **Build the mod:**
   ```bash
   .\gradlew.bat build
   ```

3. **Find the JAR:**
   - Look in `build/libs/autosword-1.0.0.jar`
   - Copy this to your Minecraft mods folder

### Option 3: Use an Online Build Service
1. Upload the source code to GitHub
2. Use GitHub Actions or similar to build automatically

## Installation
1. Install NeoForge 1.21.8 for Minecraft
2. Place the JAR file in your `.minecraft/mods/` folder
3. Launch Minecraft with NeoForge profile
4. Press F6 to toggle auto-attack

## Features
- Automatic sword attacks with perfect timing
- Works when alt-tabbed or in menus
- Configurable settings
- F6 keybind to toggle on/off
