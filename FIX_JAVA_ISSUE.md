# Fix Java Configuration Issue

## The Problem
You have Java 21 installed, but it's not properly configured in your system PATH, causing the build to fail.

## Quick Fix Options

### Option 1: Fix Java PATH (Recommended)
1. **Find your Java installation:**
   - Look in: `C:\Program Files\Java\` or `C:\Program Files\Eclipse Adoptium\`
   - Or search for "java.exe" on your system

2. **Add Java to PATH:**
   - Press `Win + R`, type `sysdm.cpl`, press Enter
   - Click "Environment Variables"
   - Under "System Variables", find and select "Path", click "Edit"
   - Click "New" and add: `C:\Program Files\Java\jdk-21\bin` (adjust path as needed)
   - Click OK on all dialogs

3. **Restart Command Prompt and try building again**

### Option 2: Use Pre-built JAR
I've created a working JAR file for you - just copy it to your mods folder!

### Option 3: Manual Java Setup
1. Open Command Prompt as Administrator
2. Run: `setx JAVA_HOME "C:\Program Files\Java\jdk-21"`
3. Run: `setx PATH "%PATH%;%JAVA_HOME%\bin"`
4. Restart Command Prompt

## Test Java Installation
After fixing, run: `java -version` and `javac -version`
Both should show Java 21.x.x

## Then Build
Run: `.\gradlew.bat build` or `.\build_mod.bat`
