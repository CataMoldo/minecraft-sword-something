# GitHub Setup Instructions

## Step 1: Create GitHub Repository

1. **Open GitHub Desktop**
2. **Click "Create a new repository on GitHub"**
3. **Repository name:** `mc-sword-spam`
4. **Description:** `Minecraft AutoSword Mod for NeoForge 1.21.8`
5. **Make it Public** (so GitHub Actions can work)
6. **Click "Create repository"**

## Step 2: Add Files to Repository

1. **In GitHub Desktop, you should see your local folder**
2. **All your mod files should appear in the "Changes" tab**
3. **Add a commit message:** "Initial commit - AutoSword Mod"
4. **Click "Commit to main"**
5. **Click "Push origin"** to upload to GitHub

## Step 3: Enable GitHub Actions

1. **Go to your repository on GitHub.com**
2. **Click the "Actions" tab**
3. **You should see the build workflow**
4. **Click "Run workflow"** to test it

## Step 4: Download Your Built Mod

1. **Go to the "Actions" tab**
2. **Click on the latest workflow run**
3. **Scroll down to "Artifacts"**
4. **Download "autosword-mod"**
5. **Extract the JAR file**
6. **Copy to your Minecraft mods folder**

## What Happens Next

- **Every time you push changes**, GitHub will automatically build the mod
- **The JAR file will be available** in the Actions tab
- **Releases will be created** automatically with the built mod

## Troubleshooting

- **If Actions don't run:** Make sure the repository is public
- **If build fails:** Check the Actions tab for error details
- **If JAR is missing:** Wait for the build to complete (takes 2-3 minutes)

Your mod will be automatically built and ready to download!
